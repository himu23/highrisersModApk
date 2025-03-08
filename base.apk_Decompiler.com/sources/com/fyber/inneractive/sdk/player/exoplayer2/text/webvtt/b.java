package com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt;

import java.util.regex.Pattern;

public final class b {
    public static final Pattern a = Pattern.compile("^NOTE(( |\t).*)?$");
    public static final Pattern b = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    public static long a(String str) throws NumberFormatException {
        String[] split = str.split("\\.", 2);
        long j = 0;
        for (String parseLong : split[0].split(":")) {
            j = (j * 60) + Long.parseLong(parseLong);
        }
        return ((j * 1000) + Long.parseLong(split[1])) * 1000;
    }
}
