package com.example.library.Controller.readercontroller;

import com.example.library.mapper.recommandmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Recommand_controller {
    @Autowired
    private recommandmapper recommand_mapper;

    //增加采购推荐
    @PostMapping("/addrecommand")
    public int add(Integer uid,String recname,String reauthor,String republisher,String email ,String reason){
        System.out.println(email);
        int i = recommand_mapper.add(uid,recname,reauthor,republisher,email,reason);
        return i;

    }

}