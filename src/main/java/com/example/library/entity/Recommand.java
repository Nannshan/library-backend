package com.example.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("recommand")
public class Recommand {
    @TableId(type = IdType.ID_WORKER_STR)
    private int rid;
    private int uid;
    private String recname;
    private String reauthor;
    private String republisher;
    private String email;
    private String reason;

    public void setR_id(int rid) {
        this.rid = rid;
    }

    public void setU_id(int uid) {
        this.uid = uid;
    }

    public void setRecname(String rename) {
        this.recname = recname;
    }

    public void setReauthor(String reauthor) {
        this.reauthor = reauthor;
    }

    public void setRepublisher(String republisher) {
        this.republisher = republisher;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getR_id() {
        return rid;
    }

    public int getU_id() {
        return uid;
    }

    public String getRecname() {
        return recname;
    }

    public String getReauthor() {
        return reauthor;
    }

    public String getRepublisher() {
        return republisher;
    }

    public String getEmail() {
        return email;
    }

    public String getReason() {
        return reason;
    }

    public Recommand(int rid, int uid, String recname, String reauthor, String republisher, String email, String reason) {
        this.uid = uid;
        this.rid = rid;
        this.recname = recname;
        this.reauthor = reauthor;
        this.republisher = republisher;
        this.email = email;
        this.reason = reason;
    }
}
