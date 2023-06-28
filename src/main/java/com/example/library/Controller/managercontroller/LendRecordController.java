package com.example.library.Controller.managercontroller;

import com.example.library.entity.LendRecord;
import com.example.library.mapper.managermapper.LendRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class LendRecordController {
    @Autowired
    private LendRecordMapper lendRecordMapper;
    @PostMapping("/lendandrecordquery")
    public String query(int readerId,int isbn,String bookname){
        List<LendRecord> list= lendRecordMapper.find( readerId, isbn, bookname);
        System.out.println(list);
        return "查询用户";

    }
    @DeleteMapping("/lendandrecordquerydelete")
    public ResponseEntity<String> deleteItems(@RequestParam("ids") List<Integer> ids) {
        // 对传入的 id 进行批量删除
        // itemService.deleteItemsByIds(ids);
        int id;
        for (int i = 0; i < ids.size(); i++) {
//            id=ids.get(i);
//           lendRecordMapper.deleteLR(id);
            Map<String,Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("isbn",ids.get(i));
            lendRecordMapper.deleteByMap(stringObjectMap);
        }
        return ResponseEntity.ok("删除成功");


    }
}
