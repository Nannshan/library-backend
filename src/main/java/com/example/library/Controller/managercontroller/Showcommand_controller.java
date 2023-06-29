package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.Recommand;
import com.example.library.mapper.recommandmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Showcommand_controller {
    @Autowired
    private recommandmapper showcommand_mapper;

    //使用分页查询获取荐购数据
    @PostMapping("/showrecommand")
    public Page<Recommand> findall(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10")int rows){
        Page<Recommand> commandpage =new Page<>(page,rows);
        showcommand_mapper.selectPage(commandpage,null);
//        System.out.println(commandpage.getRecords());
//        System.out.println(commandpage.getTotal());
        return commandpage;
    }
}
