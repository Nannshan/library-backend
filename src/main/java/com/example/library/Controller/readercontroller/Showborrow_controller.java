package com.example.library.Controller.readercontroller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.bookwithuser;
import com.example.library.mapper.bookwithusermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Showborrow_controller {
    @Autowired
    private bookwithusermapper sc;


    //使用分页查询获取借阅记录
    @PostMapping("/showborrow")
    public Page<bookwithuser> find(String isbn, String book_name, Integer uid, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int rows){
        //查询条件序列
        QueryWrapper<bookwithuser> queryWrapper = new QueryWrapper();
        queryWrapper.eq("isbn",isbn);
        queryWrapper.eq("book_name",book_name);
        queryWrapper.eq("uid",uid);
        //分页查询
        Page<bookwithuser> bpage = new Page<>(page,rows);
        sc.selectPage(bpage,queryWrapper);
        return bpage;
    }

}
