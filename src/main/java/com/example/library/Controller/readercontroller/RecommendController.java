package com.example.library.Controller.readercontroller;

import com.example.library.mapper.RecommandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reader")
public class RecommendController {
    @Autowired
    private RecommandMapper recommand_mapper;

    //增加采购推荐
    @PostMapping("/addRecommand")
    public int addRecommand(Integer uid,String recname,String reauthor,String republisher,String email ,String reason){
        System.out.println(email);
        int i = recommand_mapper.add(uid,recname,reauthor,republisher,email,reason);
        return i;

    }

}
