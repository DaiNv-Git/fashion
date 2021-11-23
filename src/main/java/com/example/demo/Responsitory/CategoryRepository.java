package com.example.demo.Responsitory;

import com.example.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    Category findByName(String name);
}
