package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.library.entity.Book;
import com.example.library.mapper.BookMapper;
import com.example.library.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookMapper bookMapper;

    @PostMapping("/addBook")
    public Result addBook(@RequestBody Book book){
        try{
            // 设置初始的剩余数量(一开始剩余数量等于馆藏数量)
            book.setrestnum(book.getTotal());
            bookMapper.insert(book);
            return Result.ok().data("info", "插入成功");
        }catch (DuplicateKeyException e){
            System.out.println(e);
            return  Result.error().data("info", "ISBN号已存在");
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "添加失败,参数错误");
        }
    }
}
