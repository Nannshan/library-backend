package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.User;
import com.example.library.mapper.UserMapper;
import com.example.library.utils.JwtUtils;
import com.example.library.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取所有读者
     * @param id
     * @param username 用户名
     * @param nickname 昵称
     * @param current 当前页码
     * @param size 页码大小
     * @return
     */
//    @PostMapping("/findAll")
//    public Result getAllUsers( String id, int current, int size){
//        QueryWrapper<User> queryWrapper = new QueryWrapper();
//        // role为0表示读者角色
//        queryWrapper.eq("role",0);
//       try{
//           // 设置起始值及每页条数
//           Page<User> page = new Page<>(current,size);
//           IPage iPage = userMapper.selectPage(page, queryWrapper);
//           return Result.ok().data("users", iPage);
//       }catch (Exception e){
//           System.out.println(e);
//       }
//        return  Result.error();
//    }

    /**
     * 多条件分页查询用户
     * @param id 读者编号
     * @param username 用户名
     * @param nickname 密码
     * @param current 当前页码
     * @param size 每页大小
     * @return
     */
    @GetMapping("/getUsersByCondition")
    public Result getUsersByCondition(String id, String username, String nickname, int current, int size){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        try{
            queryWrapper.like("id", id);
            queryWrapper.like("username", username);
            queryWrapper.like("nick_name", nickname);
            // 设置起始值及每页条数
            Page<User> page = new Page<>(current,size);
            IPage iPage = userMapper.selectPage(page, queryWrapper);
            return Result.ok().data("users", iPage);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "参数错误");
        }
    }

    @GetMapping("/getUserById")
    public Result getUserById(String id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        try {
            User user = userMapper.selectById(id);
            if(user != null){
                return Result.ok().data("user", user);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return Result.error().data("info", "无法获取该用户");
    }
    @PutMapping("/updateUserInfo")
    public Result updateUserInfo(@RequestBody User user){
        try {
            userMapper.updateById(user);
            return Result.ok();
        }catch (Exception e){

        }
        return Result.error();
    }

    @DeleteMapping("/deleteUser")
    public Result deleteUserById(Integer id){
        try{
            userMapper.deleteById(id);
            return Result.ok().data("info", "删除成功");
        }catch (Exception e){
            System.out.println(e);
        }
        return Result.error().data("info", "读者可能有未归还的借阅记录");
    }

    @PutMapping("/updatePassword")
    public Result updatePassword(String uid, String oldPwd, String newPwd, String confirmPwd){
        System.out.println(uid+oldPwd+confirmPwd+newPwd);
        // 校验查询用户的校验密码是否正确
        User user;
        try{
            Map<String, Object> queryMap = new HashMap<>();
            queryMap.put("id", Integer.parseInt(uid));
            queryMap.put("password", oldPwd);
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.allEq(queryMap, false);
            user = userMapper.selectOne(queryWrapper);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "参数错误");
        }
        if(user == null){
            return Result.error().data("info", "密码错误");
        }
        // 修改密码
        if(newPwd.equals(confirmPwd)){
            user.setPassword(newPwd);
            userMapper.updateById(user);
        }else {
            return Result.error().data("info", "确认密码不一致");
        }
        return Result.ok();
    }


    /**
     * 管理员登录(查询时role值需要是1)
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/managerLogin")
    public Result managerLogin(String username, String password){
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", username);
            queryWrapper.eq("password",password);
            queryWrapper.eq("role", 1);
            User userResult = userMapper.selectOne(queryWrapper);
            if(userResult == null){
                return Result.error().data("info", "用户名或密码错误");
            }

            String token = JwtUtils.generateToken(userResult.getUsername());
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("uid", userResult.getId());
            resultMap.put("username", userResult.getUsername());
            resultMap.put("token", token);
            return Result.ok().data("data", resultMap);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "参数错误");
        }
    }

    /**
     * 管理员登录(查询时role值需要是1)
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Result login(String username, String password){
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", username);
            queryWrapper.eq("password",password);
            User userResult = userMapper.selectOne(queryWrapper);
            if(userResult == null){
                return Result.error().data("info", "用户名或密码错误");
            }

            String token = JwtUtils.generateToken(userResult.getUsername());
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("uid", userResult.getId());
            resultMap.put("username", userResult.getUsername());
            resultMap.put("token", token);
            return Result.ok().data("data", resultMap);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "参数错误");
        }
    }

    /**
     * 管理员注册(将role设置为1)
     * @param user
     * @return
     */
    @PostMapping("/managerRegister")
    public Result managerRegister(@RequestBody User user){
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", user.getUsername());
            User userFind = userMapper.selectOne(queryWrapper);
            if(userFind != null){
                return Result.error().data("info", "用户名已存在");
            }
            user.setRole(1);
            userMapper.insert(user);
            return Result.ok().data("info", "注册成功");
        }catch (Exception e){
            return Result.error().data("info", "参数错误");
        }
    }

    /**
     * 用户注册(不传role,默认的role值是0)
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", user.getUsername());
            User userFind = userMapper.selectOne(queryWrapper);
            if(userFind != null){
                return Result.error().data("info", "用户名已存在");
            }
            userMapper.insert(user);
            return Result.ok().data("info", "注册成功");
        }catch (Exception e){
            return Result.error().data("info", "参数错误");
        }
    }
}
