package com.example.library.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@TableName("lend_record")
public class LendRecord {
    private Integer readerId;
    //@TableId(type = IdType.ID_WORKER_STR)
    private String isbn;
    private String bookname;
    @JsonFormat(locale="zh",timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date lendTime;
    @JsonFormat(locale="zh",timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date returnTime;
    private String status;
    private Integer borrownum;

    @Override
    public String toString() {
        return "LendRecord{" +
                "isbn='" + isbn + '\'' +
                ", readerId=" + readerId +
                ", bookname='" + bookname + '\'' +
                ", lendTime=" + lendTime +
                ", returnTime=" + returnTime +
                ", status='" + status + '\'' +
                ", borrownum=" + borrownum +
                '}';
    }

    public Integer getBorrownum() {
        return borrownum;
    }

    public void setBorrownum(Integer borrownum) {
        this.borrownum = borrownum;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}