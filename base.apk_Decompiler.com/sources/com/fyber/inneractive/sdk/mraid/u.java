package com.fyber.inneractive.sdk.mraid;

public abstract class u {
    public abstract String a();

    public String toString() {
        String a = a();
        if (a != null) {
            return a.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "");
        }
        return "";
    }
}
