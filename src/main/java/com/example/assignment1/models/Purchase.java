package com.example.assignment1.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "quantity")
    private int quantity;
}
