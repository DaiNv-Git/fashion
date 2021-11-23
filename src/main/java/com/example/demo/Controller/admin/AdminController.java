package com.example.demo.Controller.admin;

import com.example.demo.Model.Product;
import com.example.demo.Responsitory.ProductRepository;
import com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")

public class AdminController {
    @Autowired
    ProductRepository product;
    @GetMapping("index")
    public String getIndexAdmin(){
        return "Admin/index";
    }
  @GetMapping("/product")
    public String getAllProduct(Model model){
        List<Product> products = product.findAll();
        model.addAttribute("product",products);
        return "Admin/product-list";
  }
}
