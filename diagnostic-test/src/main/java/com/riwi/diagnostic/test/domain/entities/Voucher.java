package com.riwi.diagnostic.test.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voucher")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean isActive;
    @Column(nullable = false)
    @Lob
    private String description;
    @Column(nullable = false)
    private Double percentage;
    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime expirationDate;

    // Foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salesId", referencedColumnName = "id")
    private Sales sales;

}
