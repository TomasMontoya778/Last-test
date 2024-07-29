package com.riwi.diagnostic.test.domain.repositories;

import com.riwi.diagnostic.test.domain.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, String> {

}
