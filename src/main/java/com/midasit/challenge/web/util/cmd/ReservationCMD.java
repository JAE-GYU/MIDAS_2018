package com.midasit.challenge.web.util.cmd;

public enum ReservationCMD {
    WAIT("WAIT", 1),
    CHECK("CHECK", 2),
    PROGRESS("PROGRESS", 3),
    DONE("DONE", 4),
    ADD_RESERVATION("ADD_RESERVATION", 101),
    VIEW_RESERVATION("VIEW_RESERVATION", 102),
    UPDATE_RESERVATION("UPDATE_RESERVATION", 103),
    DELETE_RESERVATION("DELETE_RESERVATION", 104),
    INSERT_BOARD("INSERT_BOARD", 105),
    LIST_BOARD("LIST_BOARD", 106),
    GET_GROUP_ID("GET_GROUP_ID", 107),
    DELETE_BOARD("DELETE_BOARD", 108),
    VIEW_COUPON("VIEW_COUPON", 109),
    ADD_COUPON("ADD_COUPON", 110);

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
