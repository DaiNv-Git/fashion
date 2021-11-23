package com.example.demo.Responsitory;

import com.example.demo.Model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<Users,Long> {
    //xác thực người dùng
    @Query("select u from Users u where u.userName =:username")
    public Users getUsersByUserName(@Param("username")String username);
}
