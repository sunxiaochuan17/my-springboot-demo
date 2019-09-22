package com.example.demo.mapper.db1;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * Created by jinglun on 2019-09-22
 */
public interface StudentMapper {

    List<Student> listStudent();

    Student findStudentById(@Param("id") Integer id);
}
