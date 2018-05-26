package com.midasit.challenge.web.util.cmd;

public enum ReservationCMD {
    WAIT("WAIT", 1),
    CHECK("CHECK", 2),
    PROGRESS("PROGRESS", 3),
    DONE("DONE", 4),
    MAKE_COUPON_HAVE("HAVE", 10),
    MAKE_COUPON_USE("USE", 11),
    MAKE_COUPON_EXPIRE("EXPIRE", 12),
    ADD_RESERVATION("ADD_RESERVATION", 101),
    VIEW_RESERVATION("VIEW_RESERVATION", 102),
    UPDATE_RESERVATION("UPDATE_RESERVATION", 103),
    DELETE_RESERVATION("DELETE_RESERVATION", 104),
    INSERT_BOARD("INSERT_BOARD", 105),
    LIST_BOARD("LIST_BOARD", 106),
    GET_GROUP_ID("GET_GROUP_ID", 107),
    DELETE_BOARD("DELETE_BOARD", 108),
    VIEW_COUPON("VIEW_COUPON", 109),
    ADD_COUPON("ADD_COUPON", 110),
    UPDATE_COUPON("UPDATE_COUPON", 111),
    LIST_MAKE_COUPON("LIST_MAKE_COUPON", 112),
    ADD_MAKE_COUPON("ADD_MAKE_COUPON", 113),
    UPDATE_MAKE_COUPON("UPDATE_MAKE_COUPON", 114),
    VIEW_BY_COUPON_MAKE_COUPON("VIEW_BY_COUPON_MAKE_COUPON", 115),
    VIEW_MAKE_COUPON("VIEW_MAKE_COUPON", 116),
    LIST_COUPON("LIST_COUPON", 117);

    private final String description;
    private final int code;

    ReservationCMD(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public String description() {
        return description;
    }

    public int code() {
        return code;
    }

    public String fail() {
        return "Failed to " + this.description();
    }
}
