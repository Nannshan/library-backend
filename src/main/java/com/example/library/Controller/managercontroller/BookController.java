package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.library.entity.Book;
import com.example.library.mapper.BookMapper;
import com.example.library.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(int id) {
        int rows = bookMapper.deleteById(id);
        if (rows > 0) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.ok("删除失败");
        }
    }

    @PostMapping("/update")
    public int updateBook(String isbn, String name, float price, String author, String publisher, String createTime,
                          int borrowNum, String description, int restNum, int total, String place) {
        int rows = bookMapper.updateBook(isbn, name, price, author, publisher, createTime, borrowNum,
                description, restNum, total, place);
        return rows;
    }
}
