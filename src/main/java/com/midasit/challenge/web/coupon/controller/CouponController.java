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
        return svc.response(ReservationCMD.VIEW_COUPON, null);
    }

    @PostMapping
    public ResponseFormat addCoupon(@RequestBody Coupon coupon) {
        ResponseFormat responseFormat = svc.response(ReservationCMD.ADD_COUPON, coupon);

        return responseFormat;
    }

    @PutMapping
    private ResponseFormat update(@RequestBody Coupon reservation) {
        ResponseFormat responseFormat = svc.response(ReservationCMD.UPDATE_RESERVATION, reservation);
        return responseFormat;
    }

    @DeleteMapping("/{id}")
    public ResponseFormat delete(@PathVariable int id) {
        return new ResponseFormat();
    }

    private Boolean isSession(HttpSession session) {
        return session.getAttribute("user") != null;
    }
}
