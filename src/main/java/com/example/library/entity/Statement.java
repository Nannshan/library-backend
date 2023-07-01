package com.example.library.entity;

public class Statement {
    private int usernum;
    private int borrowednum;
    private int booknum;

    public int getUsernum() {
        return usernum;
    }

    public void setUsernum(int usernum) {
        this.usernum = usernum;
    }

    public int getBorrowednum() {
        return borrowednum;
    }

    public void setBorrowednum(int borrowednum) {
        this.borrowednum = borrowednum;
    }

    public int getBooknum() {
        return booknum;
    }

    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "usernum=" + usernum +
                ", borrowednum=" + borrowednum +
                ", booknum=" + booknum +
                '}';
    }
}
