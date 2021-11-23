package com.example.demo.Service;
import com.example.demo.Model.Category;
import com.example.demo.Responsitory.CategoryRepository;
import com.example.demo.Responsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryIplm implements CategoryService {
    @Autowired
    CategoryRepository categoryRps;
    @Override
    public List<Category> getAllIndex() {
        return categoryRps.findAll();
    }
}
