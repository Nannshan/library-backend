package com.example.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;

@TableName("LendRecordWithBooknameView")
public class LendRecordWithBooknameView {
        @TableId(type = IdType.ID_WORKER_STR)
        private Integer id;
        @TableField("reader_id")
        private Integer readerId;
        private String isbn;
        @TableField("lend_time")
        private LocalDate lendTime;
        @TableField("return_time")
        private LocalDate returnTime;
        private Integer status;
        private Integer prolong;
        @TableField("name")
        private String bookname;

    @Override
    public String toString() {
        return "LendRecordWithBooknameView{" +
                "id=" + id +
                ", readerId=" + readerId +
                ", isbn='" + isbn + '\'' +
                ", lendTime=" + lendTime +
                ", returnTime=" + returnTime +
                ", status='" + status + '\'' +
                ", prolong=" + prolong +
                ", bookname='" + bookname + '\'' +
                '}';
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public LocalDate getReturnTime() {
            return returnTime;
        }

        public void setReturnTime(LocalDate returnTime) {
            this.returnTime = returnTime;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getProlong() {
            return prolong;
        }

        public void setProlong(Integer prolong) {
            this.prolong = prolong;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public LocalDate getLendTime() {
            return lendTime;
        }

        public void setLendTime(LocalDate lendTime) {
            this.lendTime = lendTime;
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
