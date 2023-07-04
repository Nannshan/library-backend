package com.example.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.entity.Book;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    @Insert("insert into book(isbn,name,price,author,publisher,create_time,brorrownum,describe,restnum,total,place) " +
            "values(#{isbn},#{name},#{price},#{author},#{publisher},#{create_time},#{brorrowbum},#{describe},#{restnum},#{total},#{place})")
    public int add(String isbn,String name,float price,String author,String publisher, String crete_time ,int brorrownum,String describe,int restnum,int total,String place);
    @Delete("DELETE FROM book WHERE id = #{id}")
    int deleteById(int id);

    @Update("UPDATE book SET name = #{name}, price = #{price}, author = #{author}, publisher = #{publisher}, create_time = #{createTime}," +
            "borrow_num = #{borrowNum}, description = #{description}, rest_num = #{restNum}, total = #{total}, place = #{place} " +
            "WHERE id = #{id}")
    public int updateBook(String isbn, String name, float price, String author, String publisher, String createTime,
                          int borrowNum, String description, int restNum, int total, String place);

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book selectById(int id);
}
