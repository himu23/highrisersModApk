package com.fyber.inneractive.sdk.external;

public class ImpressionData {
    public Pricing a = new Pricing();
    public Video b;
    public String c;
    public Long d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public static class Pricing {
        public double a;
        public String b;

        public String getCurrency() {
            return this.b;
        }

        public double getValue() {
            return this.a;
        }

        public void setValue(double d) {
            this.a = d;
        }

        public String toString() {
            return "Pricing{value=" + this.a + ", currency='" + this.b + "'}";
        }
    }

    public static class Video {
        public boolean a;
        public long b;

        public Video(boolean z, long j) {
            this.a = z;
            this.b = j;
        }

        public long getDuration() {
            return this.b;
        }

        public boolean isSkippable() {
            return this.a;
        }

        public String toString() {
            return "Video{skippable=" + this.a + ", duration=" + this.b + '}';
        }
    }

    public String getAdvertiserDomain() {
        return this.i;
    }

    public String getCampaignId() {
        return this.h;
    }

    public String getCountry() {
        return this.e;
    }

    public String getCreativeId() {
        return this.g;
    }

    public Long getDemandId() {
        return this.d;
    }

    public String getDemandSource() {
        return this.c;
    }

    public String getImpressionId() {
        return this.f;
    }

    public Pricing getPricing() {
        return this.a;
    }

    public Video getVideo() {
        return this.b;
    }

    public void setAdvertiserDomain(String str) {
        this.i = str;
    }

    public void setCampaignId(String str) {
        this.h = str;
    }

    public void setCountry(String str) {
        this.e = str;
    }

    public void setCpmValue(String str) {
        double d2;
        try {
            d2 = Double.parseDouble(str);
        } catch (Exception unused) {
            d2 = 0.0d;
        }
        this.a.a = d2;
    }

    public void setCreativeId(String str) {
        this.g = str;
    }

    public void setDemandId(Long l) {
        this.d = l;
    }

    public void setDemandSource(String str) {
        this.c = str;
    }

    public void setImpressionId(String str) {
        this.f = str;
    }

    public void setPricing(Pricing pricing) {
        this.a = pricing;
    }

    public void setVideo(Video video) {
        this.b = video;
    }

    public String toString() {
        return "ImpressionData{pricing=" + this.a + ", video=" + this.b + ", demandSource='" + this.c + "', country='" + this.e + "', impressionId='" + this.f + "', creativeId='" + this.g + "', campaignId='" + this.h + "', advertiserDomain='" + this.i + "'}";
    }

    public void setCurrency(String str) {
        this.a.b = str;
    }

    public void setDuration(long j) {
        this.b.b = j;
    }
}
