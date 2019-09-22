package com.example.demo.mapper.db2;

import com.example.demo.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jinglun on 2019-09-22
 */
public interface CategoryMapper {

    List<Category> listCategory();

    Category findCategoryById(@Param("id") Integer id);
}
