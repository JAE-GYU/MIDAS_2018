package com.midasit.challenge.web.reservation.domain;

import java.sql.Timestamp;

public class Reservation {
    private int reservation_id;
    private Timestamp created_date;
    private int user_id;
    private int menu_id;
    private int group_id;
    private String state = "WAIT";
    private String comment;
    private int coupon_id;
    private int makecoupon_id = 0;

    public int getMakecoupon_id() { return makecoupon_id; }

    public void setMakecoupon_id(int makecoupon_id) { this.makecoupon_id = makecoupon_id; }

    public Timestamp getCreated_date() { return created_date; }

    public void setCreated_date(Timestamp created_date) { this.created_date = created_date; }

    public int getCoupon_id() { return coupon_id; }

    public void setCoupon_id(int coupon_id) { this.coupon_id = coupon_id; }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
