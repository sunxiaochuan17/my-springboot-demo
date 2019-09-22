package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Student;
import com.example.demo.service.CategoryService;
import com.example.demo.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by jinglun on 2019-09-22
 */
@RestController
@RequestMapping("/api/test/")
public class TestController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("根据id查询学生信息")
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable("id") Integer id) {
        Student student = studentService.getStudentById(id);
        return student == null ? "no data." : student.toString();
    }

    @ApiOperation("查询学生列表")
    @GetMapping("/student/list")
    public String students() {
        List<Student> students = studentService.listStudent();
        return CollectionUtils.isEmpty(students) ? "no data." : students.toString();
    }


    @ApiOperation("根据id查询类型信息")
    @GetMapping("/category/{id}")
    public String getCategory(@PathVariable("id") Integer id) {
        Category category = categoryService.getCategoryById(id);
        return category == null ? "no data." : category.toString();
    }

    @ApiOperation("查询类型列表")
    @GetMapping("/category/list")
    public String categories() {
        List<Category> categories = categoryService.listCategory();
        return CollectionUtils.isEmpty(categories) ? "no data." : categories.toString();
    }
}
