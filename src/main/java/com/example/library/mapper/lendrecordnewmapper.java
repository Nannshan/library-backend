package com.example.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.entity.LendRecord;
import com.example.library.entity.LendRecordWithnicknameUsernameView;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface lendrecordnewmapper extends BaseMapper<LendRecordWithnicknameUsernameView> {
    @Select("delete from lend_record where id=#{id} ")
    public void deleteLR (int id);

    //@Select("select * from lend_record where reader_id =#{readerId} and isbn=#{isbn} ")

    @Update("UPDATE lend_record SET  reader_id=#{reader_id} ,isbn=#{isbn}, lend_time=#{lend_time},return_time=#{return_time},status=#{status} WHERE  id= #{id}")
    public void update(int id, int reader_id, String isbn, String lend_time, String return_time, Integer status);
    @Insert("INSERT INTO lend_record  (reader_id, isbn,lend_time,return_time,status,prolong)VALUES (#{reader_id}, #{isbn},#{lend_time},#{return_time},1,0)")
    public void add(int reader_id, String isbn, LocalDateTime lend_time,LocalDateTime return_time);

}
