package com.example.demo.Service;

import com.example.demo.Model.Users;
import com.example.demo.Responsitory.UserRepository;
import com.example.demo.Security.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceIplm implements UserDetailsService {
    @Autowired
    private UserRepository Rpossecurity;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = Rpossecurity.getUsersByUserName(userName);
        if(user ==null){
            throw  new UsernameNotFoundException("could not User");
        }
        return new MyUser(user);
    }
}
