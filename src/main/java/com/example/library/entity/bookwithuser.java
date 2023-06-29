package com.example.library.entity;


import java.time.LocalDate;

public class bookwithuser {
    private Integer id;
    private Integer uid;
    private Integer  prolong;
    private String isbn;
    private String book_name;
    private String nick_name;
    private LocalDate lendtime;
    private LocalDate deadtime;

    @Override
    public String toString() {
        return "bookwithuser{" +
                "id=" + id +
                ", uid=" + uid +
                ", prolong=" + prolong +
                ", isbn='" + isbn + '\'' +
                ", book_name='" + book_name + '\'' +
                ", nick_name='" + nick_name + '\'' +
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

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
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
