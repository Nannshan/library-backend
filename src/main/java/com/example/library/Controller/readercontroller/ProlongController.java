package com.example.library.Controller.readercontroller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.library.entity.LendRecord;
import com.example.library.mapper.LendRecordMapper;
import com.example.library.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/reader")
public class ProlongController {
    @Autowired
    private LendRecordMapper lrm;
    //根据id查询该对象
    public LendRecord findProbyId(int id){
        LendRecord a = lrm.selectById(id);
        //借阅状态更新
/*        UpdateWrapper<LendRecord> uw = new UpdateWrapper<>();
        LocalDate now = LocalDate.now();
        if(a.getReturnTime().isBefore(now)){
            a.setStatus("2");
            uw.eq("id", a.getId())
                    .set("status", 2);
            lrm.update(null,uw);
        }*/
        System.out.println(a.toString());
       return a;
    }
    //根据id修改prolong
    @PostMapping("/changeProbyId")
    public Result changeprobyId(int id) {
        try {
            LendRecord ba = findProbyId(id);
            UpdateWrapper<LendRecord> uw = new UpdateWrapper<>();
            if (ba.getProlong() > 0) {//可以续借
                LocalDate d = ba.getReturnTime();
                d = d.plus(7, ChronoUnit.DAYS);
                uw.eq("id", ba.getId())
                        .set("prolong", 0)
                        .set("return_time", d);
                lrm.update(null, uw);
                return Result.ok();
            } else {
                return Result.error();
            }
        } catch (Exception e) {

        }return Result.error();
    }
}
