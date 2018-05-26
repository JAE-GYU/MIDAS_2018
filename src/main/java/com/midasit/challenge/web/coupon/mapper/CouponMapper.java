package com.midasit.challenge.web.coupon.mapper;

import com.midasit.challenge.web.coupon.domain.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CouponMapper {
    public List<Coupon> list();
    public Coupon view(Coupon coupon);
    public int insert(Coupon coupon);
    public int update(Coupon coupon);
    public int delete(Coupon coupon);
    public int select_by_group_id(Coupon coupon);
}
