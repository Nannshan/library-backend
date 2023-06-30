package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.User;
import com.example.library.mapper.UserMapper;
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
    public IPage getAllUsers( String id, String username, String nickname, int current, int size){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        // role为0表示读者角色
        queryWrapper.eq("role",0);
        // 设置起始值及每页条数
        Page<User> page = new Page<>(current,size);
       IPage iPage = userMapper.selectPage(page, queryWrapper);
        return  iPage;
    }

    @PutMapping("/updateUserInfo")
    public String updateUserInfo(@RequestBody User user){
        int i = userMapper.updateById(user); // 返回的是影响的条目数,0修改失败,1修改成功
        return ""+i;
    }

}
