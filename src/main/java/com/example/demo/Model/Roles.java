package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_Id;
    private String name;
    public Roles(int role_Id, String name) {
        super();
        this.role_Id = role_Id;
        this.name = name;
    }
    public Roles() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getRole_Id() {
        return role_Id;
    }
    public void setRole_Id(int role_Id) {
        this.role_Id = role_Id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }





}
