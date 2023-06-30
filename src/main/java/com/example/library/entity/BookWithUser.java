package com.example.library.entity;


import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
@TableName("bookwithuser")
public class BookWithUser {
    private Integer id;
    private Integer uid;
    private Integer  prolong;
    private String isbn;
    private String bookname;
    private String nickname;
    private LocalDate lendtime;
    private LocalDate deadtime;

    @Override
    public String toString() {
        return "bookwithuser{" +
                "id=" + id +
                ", uid=" + uid +
                ", prolong=" + prolong +
                ", isbn='" + isbn + '\'' +
                ", bookname='" + bookname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", lendtime=" + lendtime +
                ", deadtime=" + deadtime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getProlong() {
        return prolong;
    }

    public void setProlong(Integer prolong) {
        this.prolong = prolong;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getLendtime() {
        return lendtime;
    }

    public void setLendtime(LocalDate lendtime) {
        this.lendtime = lendtime;
    }

    public LocalDate getDeadtime() {
        return deadtime;
    }

    public void setDeadtime(LocalDate deadtime) {
        this.deadtime = deadtime;
    }


}
