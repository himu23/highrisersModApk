package com.fyber.inneractive.sdk.mraid;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.n;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.i;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;

public class d extends a {
    public d(Map<String, String> map, i iVar, p0 p0Var) {
        super(map, iVar, p0Var);
    }

    public void a() {
        i iVar = this.c;
        Map<String, String> map = this.b;
        Context l = iVar.l();
        if (n.a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event"))) {
            try {
                Map<String, Object> a = iVar.a(map);
                Intent type = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
                HashMap hashMap = (HashMap) a;
                for (String str : hashMap.keySet()) {
                    Object obj = hashMap.get(str);
                    if (obj instanceof Long) {
                        type.putExtra(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        type.putExtra(str, ((Integer) obj).intValue());
                    } else {
                        type.putExtra(str, (String) obj);
                    }
                }
                type.setFlags(DriveFile.MODE_READ_ONLY);
                l.startActivity(type);
                L l2 = iVar.g;
                if (l2 != null) {
                    ((i.h) l2).c();
                }
            } catch (ActivityNotFoundException unused) {
                IAlog.a("There is no calendar app installed!", new Object[0]);
                iVar.a(g.CREATE_CALENDAR_EVENT, "Action is unsupported on this device - no calendar app installed");
            } catch (IllegalArgumentException e) {
                IAlog.a("invalid parameters for create calendar ", e.getMessage());
                iVar.a(g.CREATE_CALENDAR_EVENT, e.getMessage());
            } catch (Exception unused2) {
                IAlog.a("Failed to create calendar event.", new Object[0]);
                iVar.a(g.CREATE_CALENDAR_EVENT, "could not create calendar event");
            }
        } else {
            IAlog.a("createCalendarEvent supported for devices post-ICS", new Object[0]);
            iVar.a(g.CREATE_CALENDAR_EVENT, "Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
        }
    }

    public String c() {
        return null;
    }
}
