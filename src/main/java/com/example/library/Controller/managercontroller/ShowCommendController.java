package com.example.library.Controller.managercontroller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.library.entity.Recommend;
import com.example.library.mapper.RecommandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/manager")
public class ShowCommendController {
    @Autowired
    private RecommandMapper recommandmapper;

    //使用分页查询获取荐购数据
    @PostMapping("/showRecommend")
    public Page<Recommend> findAll(@RequestParam(defaultValue = "1")int current, @RequestParam(defaultValue = "10")int size){
        Page<Recommend> commandpage =new Page<>(current,size);

        recommandmapper.selectPage(commandpage,null);
        System.out.println(commandpage.getRecords());
        return commandpage;
        }
    @DeleteMapping("/deleteRecommend")
    public ResponseEntity<String> deleteItems(int rid) {
        // 对传入的 id 进行删除
        int i = recommandmapper.deleteById(rid);
        return ResponseEntity.ok("删除成功");


    }
}
