package com.riwi.diagnostic.test.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Foreign key
    private List<Coupon> coupons;

    private List<Sales> sales;
}
