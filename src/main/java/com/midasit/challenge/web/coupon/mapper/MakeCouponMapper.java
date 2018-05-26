package com.midasit.challenge.web.coupon.mapper;

import com.midasit.challenge.web.coupon.domain.Coupon;
import com.midasit.challenge.web.coupon.domain.MakeCoupon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MakeCouponMapper {
    public List<MakeCoupon> list();
    public MakeCoupon view(MakeCoupon makeCoupon);
    public List<MakeCoupon> select_by_user_id(MakeCoupon makeCoupon);
    public MakeCoupon select_by_coupon_id(MakeCoupon makeCoupon);
    public int insert(MakeCoupon makeCoupon);
    public int update(MakeCoupon makeCoupon);
    public int delete(MakeCoupon makeCoupon);
    public int update_state(MakeCoupon makeCoupon);
}
