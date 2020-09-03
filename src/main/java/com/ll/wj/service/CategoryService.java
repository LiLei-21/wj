package com.ll.wj.service;

import com.ll.wj.dao.CategoryDao;
import com.ll.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10162496
 */
@Service
public class  CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return categoryDao.findAll(sort);
    }

    public Category get(int id){
        Category category = categoryDao.findById(id).orElse(null);
        return category;
    }
}
