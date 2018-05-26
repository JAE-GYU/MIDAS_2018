package com.midasit.challenge.web.coupon.service;

import com.midasit.challenge.web.coupon.domain.Coupon;
import com.midasit.challenge.web.coupon.mapper.CouponMapper;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponMapper couponMapper;

    @Override
    public ResponseFormat response(ReservationCMD cmd, Object data) {
        ResponseFormat r = new ResponseFormat(cmd.description());
        try {
            int affected;
            switch (cmd) {
                case LIST_COUPON:
                    r.setList(couponMapper.list());
                    break;
                case VIEW_COUPON:
                    r.setList(couponMapper.view((Coupon) data));
                    break;
                case ADD_COUPON:
                    affected = couponMapper.insert((Coupon) data);
                    r.setList(affected == 0 ? null : affected);
                    r.setLast_idx(((Coupon) data).getCoupon_id());
                    break;
                case UPDATE_COUPON:
                    affected = couponMapper.update((Coupon) data);
                    r.setList(affected == 0 ? null : affected);
                    r.setLast_idx(((Coupon) data).getCoupon_id());
                    break;

            }
            if (r.getList() == null)
                r.fail(cmd.code(), cmd.fail());
            else
                r.setCode(cmd.code());
        } catch(Exception e) {
            r.fail(cmd.code(), e.getMessage());
        }

        return r;
    }

}
