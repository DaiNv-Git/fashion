package com.example.demo.Responsitory;

import com.example.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value="SELECT * FROM Product WHERE status='Best'  ORDER BY RAND() limit 4 ",nativeQuery=true)
     List<Product> getBestByIndex();
    @Query(value="SELECT * FROM Product WHERE status='New'  ORDER BY RAND() limit 4 ",nativeQuery=true)
    List<Product> getNewByIndex();
    @Query(value="SELECT * FROM Product WHERE status='Hot'  ORDER BY RAND() limit 4 ",nativeQuery=true)
    List<Product> getHotByIndex();
    @Query("SELECT p from Product p where "+"concat(p.name,p.description)"+"like %?1%")
    public List<Product> findAll(String keyword);
    @Query("SELECT p FROM Product  p where p.price >= ?1 and p.price <= ?2 ")
    public List<Product> findByPrice(double from,double to);
    @Query("SELECT c from Category c inner join Product p " +
                        "on c.category_Id=p.category.category_Id where c.name = ?1")
              public List<Product> getProductByCategory(String name);
    @Query("Select p from Product  p where p.category.category_Id =:categoryId ")
    List<Product> getByCategory(Long categoryId);
    public List<Product> findAll();
}
