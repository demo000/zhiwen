package com.dem.weixin.domain;

import java.util.Date;

public class Student {
    private Long id;

    private String tbName;

    private Short sex;

    private Date birthdate;

    private Long classId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName == null ? null : tbName.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}