package com.dem.weixin.domain;

import java.util.ArrayList;
import java.util.List;

public class TbClass {
    private Long id;

    private String tbName;

    private Tearcher tearcher;

    private List<Student> students = new ArrayList<>();

    public Tearcher getTearcher() {
        return tearcher;
    }

    public void setTearcher(Tearcher tearcher) {
        this.tearcher = tearcher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

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
}