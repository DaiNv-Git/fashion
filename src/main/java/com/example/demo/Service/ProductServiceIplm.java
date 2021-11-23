package com.example.demo.Service;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Responsitory.CategoryRepository;
import com.example.demo.Responsitory.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceIplm implements ProductService{
    @Autowired
    ProductRepository productResp;
    @Autowired
    CategoryRepository cateResp;
    @Override
    public void deleteById(long id) {
        productResp.deleteById(id);
    }
    @Override
    public List<Product> findAllProduct(String keyword) {
            if(keyword !=null){
                return productResp.findAll(keyword);
            }
        return productResp.findAll();
    }
    @Override
    public Product updateProduct(Product product) {
        return productResp.save(product);
    }
    @Override
    public Product findEmployeeById(long id) {
        return productResp.findById(id).get();
    }
    @Override
    public List<Product> getBestByIndex() {
        return productResp.getBestByIndex();
    }
    @Override
    public List<Product> getNewByIndex() {
        return productResp.getNewByIndex();
    }

    @Override
    public List<Product> getHotByIndex() {
        return productResp.getHotByIndex();
    }

    @Override
    public List<Product> findByPrice(double from,double to) {
        if(from == 0 && to ==0  ){
            return productResp.findAll();
        }
        return productResp.findByPrice(from,to);
    }
    @Override
    public List<Product> getProductByCategory(String name) {
        try{
            List<Product> listP = productResp.getByCategory(cateResp.findByName(name).getCategory_Id());
            return listP;
        }catch (NullPointerException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    public List<Product> findAllP(){
        List<Product> list = new ArrayList<>();
        for(Product product : list){
            System.out.println(product);
        }
            return list;
    }
}
