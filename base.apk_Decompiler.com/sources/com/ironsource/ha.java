package com.ironsource;

public enum ha {
    PER_DAY("d"),
    PER_HOUR("h");
    
    public String a;

    private ha(String str) {
        this.a = str;
    }

    public String toString() {
        return this.a;
    }
}
