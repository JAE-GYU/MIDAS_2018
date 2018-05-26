package com.midasit.challenge.web.coupon.controller;

import com.midasit.challenge.web.coupon.domain.Coupon;
import com.midasit.challenge.web.coupon.domain.MakeCoupon;
import com.midasit.challenge.web.coupon.service.CouponService;
import com.midasit.challenge.web.coupon.service.MakeCouponService;
import com.midasit.challenge.web.reservation.domain.Reservation;
import com.midasit.challenge.web.user.model.User;
import com.midasit.challenge.web.util.cmd.CMD;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/makecoupon")
public class MakeCouponController {
    @Autowired
    MakeCouponService svc;

    @GetMapping
    public ResponseFormat list() {
        return svc.response(ReservationCMD.LIST_MAKE_COUPON, null);
    }

    @GetMapping("/id/{id}")
    private ResponseFormat selectByUserId(@PathVariable int id){
        ResponseFormat responseFormat = svc.response(ReservationCMD.VIEW_BY_COUPON_MAKE_COUPON, id);
        return responseFormat;
    }

    @GetMapping("/coupon/{id}")
    private ResponseFormat selecByMakeCouponId(@PathVariable int id){
        ResponseFormat responseFormat = svc.response(ReservationCMD.VIEW_MAKE_COUPON, id);
        return responseFormat;
    }

    @PostMapping
    public ResponseFormat addCoupon(@RequestBody MakeCoupon coupon) {
        ResponseFormat responseFormat = svc.response(ReservationCMD.ADD_MAKE_COUPON, coupon);

        return responseFormat;
    }

    @PutMapping
    private ResponseFormat update(@RequestBody MakeCoupon coupon) {
        ResponseFormat responseFormat = svc.response(ReservationCMD.UPDATE_MAKE_COUPON, coupon);
        return responseFormat;
    }
}