package com.midasit.challenge.web.coupon.controller;

import com.midasit.challenge.web.coupon.domain.Coupon;
import com.midasit.challenge.web.coupon.service.CouponService;
import com.midasit.challenge.web.reservation.domain.Reservation;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    CouponService svc;

    @GetMapping
    public ResponseFormat list() {
        return svc.response(ReservationCMD.LIST_COUPON, null);
    }

    @GetMapping("/{id}")
    private ResponseFormat selecByMakeCouponId(@PathVariable int id){
        Coupon coupon = new Coupon();
        coupon.setCoupon_id(id);
        ResponseFormat responseFormat = svc.response(ReservationCMD.VIEW_COUPON, coupon);
        return responseFormat;
    }

    @PostMapping
    public ResponseFormat addCoupon(@RequestBody Coupon coupon) {
        ResponseFormat responseFormat = svc.response(ReservationCMD.ADD_COUPON, coupon);

        return responseFormat;
    }

    @PutMapping
    private ResponseFormat update(@RequestBody Coupon coupon) {
        ResponseFormat responseFormat = svc.response(ReservationCMD.UPDATE_COUPON, coupon);
        return responseFormat;
    }
}
