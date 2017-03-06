package com.dem.weixin.mapper;

import com.dem.weixin.domain.Student;
import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    Student selectByPrimaryKey(Long id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);

    public List<Student> getStudentByClassId(Long id);
}