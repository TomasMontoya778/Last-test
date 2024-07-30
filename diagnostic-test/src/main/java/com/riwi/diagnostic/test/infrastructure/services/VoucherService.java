package com.riwi.diagnostic.test.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.diagnostic.test.api.dto.requests.CouponRequest;
import com.riwi.diagnostic.test.api.dto.requests.Update.CouponUpdateRequest;
import com.riwi.diagnostic.test.api.dto.response.CouponResponse;
import com.riwi.diagnostic.test.domain.entities.Voucher;
import com.riwi.diagnostic.test.domain.repositories.CouponRepository;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.ICouponService;
import com.riwi.diagnostic.test.infrastructure.helpers.mappers.VoucherMapper;
import com.riwi.diagnostic.test.utils.exceptions.IdNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoucherService implements ICouponService {

    @Autowired
    private final VoucherMapper voucherMapper;

    @Autowired
    private final CouponRepository couponRepository;



    @Override
    public CouponResponse create(CouponRequest request) {
        Voucher voucher = voucherMapper.toEntity(request);
        Voucher savedVoucher = couponRepository.save(voucher);
        
        return voucherMapper.toResponse(savedVoucher);
    }

    @Override
    public CouponResponse update(String id, CouponUpdateRequest request) {
        if (request == null) {
			throw new IllegalArgumentException("Request cannot be null");
		}

        Voucher coupon = this.find(id);
		if (coupon == null) {
			throw new EntityNotFoundException("Voucher not found for id: " + id);
		}
        if (!coupon.getIsActive()) {
            throw new IllegalStateException("Cannot update an inactive voucher");
        }

        Voucher couponUpdate = this.voucherMapper.toEntityUpdate(request);
        couponUpdate.setDescription(id);

        Voucher couponSaved = this.couponRepository.save(couponUpdate);
        return this.voucherMapper.toResponse(couponSaved);
    }

    @Override
    public Optional<CouponResponse> getById(String id) {
        return Optional.ofNullable(this.voucherMapper.toResponse(this.find(id)));
    }

    @Override
    public Page<CouponResponse> getAll(Pageable pageable) {
        return this.couponRepository.findAll(pageable).map(this.voucherMapper::toResponse);
    }

    private Voucher find(String id){
		return this.couponRepository.findById(id).orElseThrow(()->new IdNotFoundException("Voucher not found"));
	}

    @Override
    public void delete(String id) {
        Voucher voucherDisable = this.find(id);
        if (voucherDisable != null) {
            voucherDisable.setIsActive(false);
            this.couponRepository.save(voucherDisable);
        }
    }

    
}
