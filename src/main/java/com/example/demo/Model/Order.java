package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String userName;
    private String phone;
    private String address;
    private Date orderDate;
    private Date shipDate;
    private String orderStatus;
    @OneToMany(mappedBy = "orderId")
    private List<OrderDetail> orderDetails;
}
