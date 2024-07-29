package com.riwi.diagnostic.test.domain.entities;


import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 50, nullable = false)
    private String name;
    @Lob
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;

    // foreign key
    @ManyToMany(mappedBy = "products")
    private List<Sales> sales;

}
