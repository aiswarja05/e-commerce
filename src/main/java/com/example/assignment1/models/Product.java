package com.example.assignment1.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  @Size(max = 100)
  @Column(name="name")
  private String name;

  @Column(name="description")
  private String description;

  @NotBlank
  @Column(name="price")
  private double price;

  @NotBlank
  @Column(name="stock")
  private int stock;

}
