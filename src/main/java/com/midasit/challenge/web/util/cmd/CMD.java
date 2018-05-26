package com.midasit.challenge.web.util.cmd;

public enum CMD {
    INSERT, VIEW, DELETE, UPDATE, LIST, LOGIN;

    public int code() {
        return ordinal() + 101;
    }

    public static String description(CMD cmd) {
        StringBuilder str = new StringBuilder("Failed to ");
        switch (cmd) {
            case INSERT: str.append("INSERT");break;
            case VIEW: str.append("VIEW");break;
            case DELETE: str.append("DELETE");break;
            case UPDATE: str.append("UPDATE");break;
            case LIST: str.append("LIST");break;
            case LOGIN: str.append("LOGIN");break;
        }
        return str.toString();
    }
}
