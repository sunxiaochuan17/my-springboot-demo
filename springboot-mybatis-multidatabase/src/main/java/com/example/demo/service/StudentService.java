package com.example.demo.service;

import com.example.demo.mapper.db1.StudentMapper;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jinglun on 2019-09-22
 */
@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    public List<Student> listStudent() {
        return studentMapper.listStudent();
    }

    public Student getStudentById(Integer id) {
        return studentMapper.findStudentById(id);
    }
}
