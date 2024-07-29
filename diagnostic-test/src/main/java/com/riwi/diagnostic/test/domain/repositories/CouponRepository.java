package com.riwi.diagnostic.test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.diagnostic.test.domain.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, String> {

}
