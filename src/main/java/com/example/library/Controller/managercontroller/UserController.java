package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.User;
import com.example.library.mapper.UserMapper;
import com.example.library.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param id
     * @param username 用户名
     * @param nickname 昵称
     * @param current 当前页码
     * @param size 页码大小
     * @return
     */
    @PostMapping("/findAll")
    public Result getAllUsers( String id, String username, String nickname, int current, int size){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        // role为0表示读者角色
        queryWrapper.eq("role",0);
        // 设置起始值及每页条数
       try{
           Page<User> page = new Page<>(current,size);
           IPage iPage = userMapper.selectPage(page, queryWrapper);
           return Result.ok().data("users", iPage);
       }catch (Exception e){
           System.out.println(e);
       }
        return  Result.error();
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

}
