package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Img;
    private String Images;
    private Timestamp createdDate;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}
