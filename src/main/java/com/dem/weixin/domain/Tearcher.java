package com.dem.weixin.domain;

public class Tearcher {
    private Long id;

    private String tbName;

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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}