package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.Book;
import com.example.library.mapper.BookMapper;
import com.example.library.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
            return Result.error().data(" info", "添加失败,参数错误");
        }
    }

    @DeleteMapping("/deleteBook")
    public Result  deleteBook(int id) {
        try{
            bookMapper.deleteById(id);
            return Result.ok().data("info", "删除成功");
        }catch (Exception e){
            System.out.println(e);
        }
        return Result.error().data("info", "读者可能有未归还的借阅记录");

    }
    @PostMapping("/update")
    public int updateBook(@RequestBody Book book){
        int i = bookMapper.updateById(book);
        return i;

    }
    @GetMapping("/getBookByCondition")
    public Result getBookByCondition(String isbn, String name, String author, int current, int size){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        try{
            queryWrapper.like("isbn", isbn);
            queryWrapper.like("name", name);
            queryWrapper.like("author", author);
            // 设置起始值及每页条数
            Page<Book> page = new Page<>(current,size);
            IPage iPage = bookMapper.selectPage(page,queryWrapper);
            return Result.ok().data("book", iPage);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "参数错误");
        }
    }
}
