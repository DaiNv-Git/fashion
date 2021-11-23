package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Responsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
        public void deleteById(long id);
        public List<Product> findAllProduct(String keyword);
        public Product updateProduct(Product product);
        public Product findEmployeeById(long id);
        public List<Product> getBestByIndex();
        public List<Product> getNewByIndex();
        public List<Product> getHotByIndex();
        public List<Product>findByPrice(double from,double to);
        public List<Product> getProductByCategory(String name);
        public List<Product> findAll();
}
