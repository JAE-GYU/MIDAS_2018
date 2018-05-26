package com.midasit.challenge.web.coupon.service;

import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;

public interface MakeCouponService<T> {
    public ResponseFormat response(ReservationCMD cmd, T data);
}
