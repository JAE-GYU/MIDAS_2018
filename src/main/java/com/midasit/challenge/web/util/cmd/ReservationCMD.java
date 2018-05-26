package com.midasit.challenge.web.util.cmd;

public enum ReservationCMD {
    ADD_RESERVATION("ADD_RESERVATION", 101),
    VIEW_RESERVATION("VIEW_RESERVATION", 102),
    LIST_BOARD("LIST_BOARD", 103),
    VIEW_BOARD("VIEW_BOARD", 104),
    INSERT_BOARD("INSERT_BOARD", 105),
    UPDATE_BOARD("UPDATE_BOARD", 106),
    GET_GROUP_ID("GET_GROUP_ID", 107),
    DELETE_BOARD("DELETE_BOARD", 108);

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
