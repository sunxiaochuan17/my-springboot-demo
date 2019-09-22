package com.example.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by jinglun on 2019-09-22
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Date createTime;
    private Date updateTime;
}
