package com.example.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.junit.runners.Parameterized;

@TableName("recommand")
public class Recommend {
    @TableId(type = IdType.AUTO)
    private int rid;
    private int uid;
    private String recname;
    private String reauthor;
    private String republisher;
    private String email;
    private String reason;

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setRecname(String recname) {
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

    public int getRid() {
        return rid;
    }

    public int getUid() {
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

    @Override
    public String toString() {
        return "Recommand{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", recname='" + recname + '\'' +
                ", reauthor='" + reauthor + '\'' +
                ", republisher='" + republisher + '\'' +
                ", email='" + email + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
