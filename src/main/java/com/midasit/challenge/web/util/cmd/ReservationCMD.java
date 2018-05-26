package com.midasit.challenge.web.util.cmd;

public enum ReservationCMD {
    ADD_RESERVATION("ADD_RESERVATION", 101),
    LOGIN_USER("LOGIN_USER", 102),
    LIST_BOARD("LIST_BOARD", 103),
    VIEW_BOARD("VIEW_BOARD", 104),
    INSERT_BOARD("INSERT_BOARD", 105),
    UPDATE_BOARD("UPDATE_BOARD", 106),
    DELETE_BOARD("DELETE_BOARD", 107);

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
