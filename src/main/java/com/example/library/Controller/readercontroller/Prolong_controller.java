package com.example.library.Controller.readercontroller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.library.entity.bookwithuser;
import com.example.library.mapper.bookwithusermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class Prolong_controller {
    @Autowired
    private bookwithusermapper pl;
    //根据id查询该对象
    @PostMapping("/findprobyid")
    public bookwithuser findprobyid(int id){
       bookwithuser a = pl.selectById(id);
        System.out.println(a.toString());
       return a;
    }
    //根据id修改prolong
    @PostMapping("/changebyid")
    public int changeprobyid(int id){
        int i;//1表示成功,0表示失败
        bookwithuser ba = findprobyid(id);
        UpdateWrapper<bookwithuser> uw = new UpdateWrapper<>();
        if(ba.getProlong()>0){//可以续借
            LocalDate d =ba.getDeadtime();
            d=d.plus(7, ChronoUnit.DAYS);
            uw.eq("id",ba.getId())
                    .set("prolong",0)
                    .set("deadtime",d);
            pl.update(null,uw);
            return 1;
        }
        else{
            return 0;
        }


    }
}
