package com.example.library.mapper.managermapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.entity.LendRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LendRecordMapper extends BaseMapper<LendRecord> {
//    @Select("delete from lend_record where isbn=#{id} ")
//    public void deleteLR (int id);

    @Select("select * from lend_record where reader_id =#{readerId} and isbn=#{isbn} and bookname=#{bookname} ")
    public List<LendRecord> find(int readerId,int isbn,String bookname);
}
