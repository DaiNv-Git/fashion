package com.example.demo.Controller.user;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;
   @Autowired
   CategoryService categoryService;
    @RequestMapping("/")
    public  String  getIndex(Model model){
        List<Product> product = productService.getBestByIndex();
        List<Product> p_New = productService.getNewByIndex();
        List<Product> p_Hot = productService.getHotByIndex();
        model.addAttribute("productBest",product);
        model.addAttribute("p_New",p_New);
        model.addAttribute("hot",p_Hot);
        return "index";
    }
    @GetMapping("/deleteP")
    public String deleteById(@PathVariable("id") long id) {
        productService.deleteById(id);
        return "redirect:index";
    }
    @GetMapping("product/{id}")
    public String findProductbyId(@PathVariable("id") Long id , Model model){
        Product pDetail = productService.findEmployeeById(id);
        model.addAttribute("detail",pDetail);
        return "shop-details";
    }
    @GetMapping("detail")
    public String detail(Model model){

        return "shop-details";
    }
    @GetMapping("/shop")
    public String getShop(Model model,@Param("keyword") String keyword){
        List<Category> cate = categoryService.getAllIndex();
        List<Product> all = productService.findAllProduct(keyword);
    //List<Product> filterPrice = productService.findByPrice(gia);
            model.addAttribute("all",all);
    //model.addAttribute("all",filterPrice);
         model.addAttribute("cate",cate);
        return "shop";
    }
    @GetMapping("{name}")
    public String getProductByCategory(Model model,@PathVariable("name") String name){
        List<Category> cate = categoryService.getAllIndex();
        List<Product> bycate = productService.getProductByCategory(name);
        model.addAttribute("all",bycate);
        model.addAttribute("cate",cate);
        return "shop";
    }
//    @GetMapping("/api/{name}")
//    public List<Product> getProductByCate( @PathVariable("name") String name){
//        return productService.getProductByCategory(name);
//    }
    @GetMapping("/fiterP")

    public String getProductByPrice(Model model,@Param("from") double from ) {
        double to = 0;
        if(from ==0 ) to=10;
        else if(from==10) to=15;
        else if(from==15) to=20;
        else if(from==20) to=25;
        else if(from==25) to=30;
        else if(from==26) to=100000000;
        List<Category> cate = categoryService.getAllIndex();
        model.addAttribute("cate",cate);
        List<Product> price = productService.findByPrice(from, to);
        model.addAttribute("all", price);
        return "shop";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("/403")
    public String error403() {
        return"403";
    }

}
