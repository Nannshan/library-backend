package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.LendRecord;
import com.example.library.entity.LendRecordWithnicknameUsernameView;

import com.example.library.mapper.LendRecordMapper;

import com.example.library.mapper.lendrecordnewmapper;
import com.example.library.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin

public class LendRecordController {
    @Autowired
    private lendrecordnewmapper lendRecordMapper;

    @DeleteMapping("/lendandrecorddelete")//ok
    public Result deleteItems(Integer id) {
        try{
            lendRecordMapper.deleteLR(id);
            return Result.ok().data("info", "删除成功");
        }catch (Exception e){
            System.out.println(e);
        }
        return Result.error().data("info", "错误");
        //
        //return ResponseEntity.ok("删除成功");


    }

    @PostMapping("/lendandrecordupdate")//ok
    public void update(int id, Integer readerId, String isbn, String lendTime, String returnTime, Integer status) {


        lendRecordMapper.update(id, readerId, isbn, lendTime, returnTime, status);


    }

    @PostMapping("/lendandrecordadd")//ok
    public void add(int reader_id, String isbn) {
        LocalDateTime lend_time = LocalDateTime.now();
        LocalDateTime return_time = lend_time.plusMonths(1);


        lendRecordMapper.add(reader_id, isbn, lend_time, return_time);


    }

    @GetMapping("/showlendrecord")
    public Result find(String isbn, String bookname, String readerId, @RequestParam(defaultValue = "1") int current, @RequestParam(defaultValue = "10") int size) {
        //查询条件序列
        try {
            QueryWrapper<LendRecordWithnicknameUsernameView> queryWrapper = new QueryWrapper();
            queryWrapper.like("isbn", isbn);
            queryWrapper.like("name", bookname);
            queryWrapper.like("reader_id", readerId);
            //分页查询
            Page<LendRecordWithnicknameUsernameView> bpage = new Page<>(current, size);
            lendRecordMapper.selectPage(bpage, queryWrapper);
            return Result.ok().data("LendRecordWithnicknameUsernameView", bpage);
            //return bpage;
        } catch (Exception e) {
            System.out.println(e);
            return Result.error().data("info", "参数错误");
        }

    }
}
