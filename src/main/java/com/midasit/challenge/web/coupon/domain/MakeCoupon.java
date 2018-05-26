package com.midasit.challenge.web.coupon.domain;

import com.midasit.challenge.web.util.cmd.ReservationCMD;

import java.sql.Timestamp;

public class MakeCoupon {
    private int makecoupon_id;
    private int user_id;
    private int coupon_id;
    private String state = ReservationCMD.MAKE_COUPON_HAVE.toString();

    public int getMakecoupon_id() {
        return makecoupon_id;
    }

    public void setMakecoupon_id(int makecoupon_id) {
        this.makecoupon_id = makecoupon_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
