package com.ironsource;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.l4;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class n4 {
    private final Context a;
    private final q3 b;
    private final m4 c;
    /* access modifiers changed from: private */
    public final z8 d;

    class a implements y9 {
        final /* synthetic */ y9 a;

        /* renamed from: com.ironsource.n4$a$a  reason: collision with other inner class name */
        class C0018a extends JSONObject {
            C0018a() throws JSONException {
                put("lastReferencedTime", System.currentTimeMillis());
            }
        }

        a(y9 y9Var) {
            this.a = y9Var;
        }

        public void a(n6 n6Var) {
            this.a.a(n6Var);
            try {
                n4.this.d.a(n6Var.getName(), new C0018a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void a(n6 n6Var, f6 f6Var) {
            this.a.a(n6Var, f6Var);
        }
    }

    public n4(Context context, q3 q3Var, m4 m4Var, z8 z8Var) {
        this.a = context;
        this.b = q3Var;
        this.c = m4Var;
        this.d = z8Var;
    }

    public void a(n6 n6Var) throws Exception {
        if (n6Var.exists()) {
            if (n6Var.delete()) {
                this.d.a(n6Var.getName());
                return;
            }
            throw new Exception("Failed to delete file");
        }
    }

    public void a(n6 n6Var, String str, int i, int i2, y9 y9Var) throws Exception {
        if (TextUtils.isEmpty(str)) {
            throw new Exception(l4.a.a);
        } else if (m3.d(this.b.a()) <= 0) {
            throw new Exception(n2.A);
        } else if (!SDKUtils.isExternalStorageAvailable()) {
            throw new Exception(n2.B);
        } else if (k2.g(this.a)) {
            this.c.a(n6Var.getPath(), new a(y9Var));
            if (n6Var.exists()) {
                Message message = new Message();
                message.obj = n6Var;
                message.what = 1015;
                this.c.sendMessage(message);
                return;
            }
            this.b.b(n6Var, str, i, i2, this.c);
        } else {
            throw new Exception(n2.C);
        }
    }

    public void a(n6 n6Var, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            throw new Exception("Missing attributes to update");
        } else if (!n6Var.exists()) {
            throw new Exception("File does not exist");
        } else if (!this.d.b(n6Var.getName(), jSONObject)) {
            throw new Exception("Failed to update attribute");
        }
    }

    public void b(n6 n6Var) throws Exception {
        if (n6Var.exists()) {
            ArrayList<n6> filesInFolderRecursive = IronSourceStorageUtils.getFilesInFolderRecursive(n6Var);
            if (!IronSourceStorageUtils.deleteFolderContentRecursive(n6Var) || !n6Var.delete()) {
                throw new Exception("Failed to delete folder");
            }
            this.d.a(filesInFolderRecursive);
        }
    }

    public JSONObject c(n6 n6Var) throws Exception {
        if (n6Var.exists()) {
            return IronSourceStorageUtils.buildFilesMapOfDirectory(n6Var, this.d.b());
        }
        throw new Exception("Folder does not exist");
    }

    public long d(n6 n6Var) throws Exception {
        if (n6Var.exists()) {
            return IronSourceStorageUtils.getTotalSizeOfDir(n6Var);
        }
        throw new Exception("Folder does not exist");
    }
}
