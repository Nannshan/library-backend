package com.example.library.Controller.readercontroller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.LendRecordWithBooknameView;
import com.example.library.mapper.LendRecordWithBooknameViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reader")
public class ShowBorrowController {
    @Autowired
    private LendRecordWithBooknameViewMapper lrm;
    //使用分页查询获取借阅记录
    @PostMapping("/showBorrow")
    public Page<LendRecordWithBooknameView> find(String isbn, String bookname, Integer readerId, @RequestParam(defaultValue = "1")int current, @RequestParam(defaultValue = "10")int size){
        //查询条件序列
        QueryWrapper<LendRecordWithBooknameView> queryWrapper = new QueryWrapper();
        queryWrapper.eq("isbn",isbn);
        queryWrapper.eq("name",bookname);
        queryWrapper.eq("reader_id",readerId);
        //分页查询
        Page<LendRecordWithBooknameView> bpage = new Page<>(current,size);
        lrm.selectPage(bpage,queryWrapper);
        return bpage;
    }

}
