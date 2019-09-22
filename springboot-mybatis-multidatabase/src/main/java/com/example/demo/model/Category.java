package com.example.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by jinglun on 2019-09-22
 */
@Data
public class Category {
    private Integer id;
    private Integer score;
    private String category;
    private Date createTime;
    private Date updateTime;
}
