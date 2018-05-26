package com.midasit.challenge.web.util.cmd;

public enum CATEGORY {
	COFFEE, TEA, JUICE, DESSERT;
	
	public int code() {
        return ordinal() + 101;
    }
}
