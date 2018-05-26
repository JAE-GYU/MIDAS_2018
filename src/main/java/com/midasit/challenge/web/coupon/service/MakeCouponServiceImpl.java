package com.midasit.challenge.web.coupon.service;

import com.midasit.challenge.web.coupon.domain.Coupon;
import com.midasit.challenge.web.coupon.domain.MakeCoupon;
import com.midasit.challenge.web.coupon.mapper.MakeCouponMapper;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeCouponServiceImpl implements MakeCouponService {
    @Autowired
    MakeCouponMapper makeCouponMapper;

    @Override
    public ResponseFormat response(ReservationCMD cmd, Object data) {
        ResponseFormat r = new ResponseFormat(cmd.description());
        try {
            int affected;
            switch (cmd) {
                case LIST_MAKE_COUPON:
                    r.setList(makeCouponMapper.list());
                    break;
                case ADD_MAKE_COUPON:
                    affected = makeCouponMapper.insert((MakeCoupon) data);
                    r.setList(affected == 0 ? null : affected);
                    r.setLast_idx(((MakeCoupon) data).getMakecoupon_id());
                    break;
                case UPDATE_MAKE_COUPON:
                    affected = makeCouponMapper.update((MakeCoupon) data);
                    r.setList(affected == 0 ? null : affected);
                    r.setLast_idx(((MakeCoupon) data).getMakecoupon_id());
                    break;
                case VIEW_BY_COUPON_MAKE_COUPON:
                    MakeCoupon makeCoupon = new MakeCoupon();
                    makeCoupon.setUser_id((int)data);
                    r.setList(makeCouponMapper.select_by_user_id(makeCoupon));
                    break;
                case VIEW_MAKE_COUPON:
                    MakeCoupon make = new MakeCoupon();
                    make.setMakecoupon_id((int)data);
                    r.setList(makeCouponMapper.select_by_coupon_id(make));
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
