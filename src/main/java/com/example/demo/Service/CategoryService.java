package com.example.demo.Service;

import com.example.demo.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    @Autowired
    public List<Category> getAllIndex();
}
