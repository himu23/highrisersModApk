package com.applovin.impl.sdk;

import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.h;
import java.util.concurrent.TimeUnit;

public class w {
    private final LocationManager aFi = ((LocationManager) n.getApplicationContext().getSystemService("location"));
    private double aFj;
    private double aFk;
    private long aFl;
    private final n sdk;

    public double Fl() {
        return this.aFj;
    }

    public double Fm() {
        return this.aFk;
    }

    w(n nVar) {
        this.sdk = nVar;
    }

    public boolean Fh() {
        return h.d("android.permission.ACCESS_COARSE_LOCATION", n.getApplicationContext());
    }

    public boolean Fi() {
        if (h.Lb()) {
            return this.aFi.isLocationEnabled();
        }
        if (!h.KW() || Settings.Secure.getInt(n.getApplicationContext().getContentResolver(), "location_mode", 0) != 0) {
            return true;
        }
        return false;
    }

    public boolean Fj() {
        if (!this.sdk.getSettings().isLocationCollectionEnabled() || !((Boolean) this.sdk.a(b.aPk)).booleanValue() || !Fh()) {
            return false;
        }
        if (Fk() || this.aFl != 0) {
            return true;
        }
        return false;
    }

    private boolean Fk() {
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.sdk.a(b.aPl)).longValue());
        if (this.aFl != 0 && System.currentTimeMillis() - this.aFl < millis) {
            return false;
        }
        Location B = B("gps", "android.permission.ACCESS_FINE_LOCATION");
        if (B == null) {
            B = B("network", "android.permission.ACCESS_COARSE_LOCATION");
        }
        if (B == null) {
            return false;
        }
        this.aFj = B.getLatitude();
        this.aFk = B.getLongitude();
        this.aFl = System.currentTimeMillis();
        return true;
    }

    private Location B(String str, String str2) {
        if (!h.d(str2, n.getApplicationContext())) {
            return null;
        }
        try {
            return this.aFi.getLastKnownLocation(str);
        } catch (SecurityException e) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.c("LocationManager", "Failed to retrieve location from " + str + ": access denied.", e);
            }
            return null;
        } catch (IllegalArgumentException e2) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN2 = this.sdk.BN();
                BN2.c("LocationManager", "Failed to retrieve location from " + str + ": device does not support this location provider.", e2);
            }
            return null;
        } catch (NullPointerException e3) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN3 = this.sdk.BN();
                BN3.c("LocationManager", "Failed to retrieve location from " + str + ": location provider is not available.", e3);
            }
            return null;
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN4 = this.sdk.BN();
                BN4.c("LocationManager", "Failed to retrieve location from " + str + ".", th);
            }
            return null;
        }
    }
}
