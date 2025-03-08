package com.applovin.impl.privacy.b;

public class a {
    public static String l(Integer num) {
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue == 2) {
            return "SFBX CMP";
        }
        if (intValue == 3) {
            return "Liveramp CMP";
        }
        if (intValue == 5) {
            return "UserCentrics CMP";
        }
        if (intValue == 6) {
            return "Sourcepoint Dialogue CMP";
        }
        if (intValue == 7) {
            return "Didomi CMP";
        }
        if (intValue == 302) {
            return "Gravito CMP";
        }
        if (intValue == 303) {
            return "Impala CMP";
        }
        switch (intValue) {
            case 10:
                return "InMobi Choice CMP";
            case 14:
                return "Yahoo EMEA CMP";
            case 21:
                return "Traffective CMP";
            case 28:
                return "Onetrust / Cookiepro CMP";
            case 31:
                return "Consentmanager CMP";
            case 35:
                return "BurdaForward GmbH CMP";
            case 68:
                return "Uniconsent CMP";
            case 76:
                return "Sibbo CMP";
            case 84:
                return "Alma CMP";
            case 90:
                return "Commanders Act CMP";
            case 104:
                return "AdOcean CMP";
            case 123:
                return "Iubenda CMP";
            case 125:
                return "Ebay CMP";
            case 134:
                return "Cookiebot CMP";
            case 167:
                return "1&1 Mail & Media GmbH CMP";
            case 171:
                return "Viber Media CMP";
            case 231:
                return "Interia CMP";
            case 237:
                return "ALPRED SL CMP";
            case 273:
                return "One Consent CMP";
            case 300:
                return "Google consent management solutions";
            case 306:
                return "mobile.de CMP";
            case 309:
                return "Kleinanzeigen CMP";
            case 318:
                return "Seven.One Entertainment Group GmbH CMP";
            case 327:
                return "FunCorp CMP";
            case 329:
                return "wetter.com GmbH CMP";
            case 345:
                return "Axel Springer Deutschland GmbH CMP";
            case 350:
                return "Easybrain CMP";
            case 397:
                return "Autoscout24 CMP";
            default:
                return null;
        }
    }
}
