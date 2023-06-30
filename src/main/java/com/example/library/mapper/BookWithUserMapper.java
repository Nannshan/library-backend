package com.example.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.entity.BookWithUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookWithUserMapper extends BaseMapper<BookWithUser> {
}
