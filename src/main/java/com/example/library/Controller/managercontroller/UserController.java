package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.User;
import com.example.library.mapper.UserMapper;
import com.example.library.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    public Result deleteUserById(String id){
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
}
