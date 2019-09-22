package com.example.demo.service;

import com.example.demo.mapper.db2.CategoryMapper;
import com.example.demo.model.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jinglun on 2019-09-22
 */
@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    public List<Category> listCategory() {
        return categoryMapper.listCategory();
    }

    public Category getCategoryById(Integer id) {
        return categoryMapper.findCategoryById(id);
    }
}
