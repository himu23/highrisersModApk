package com.fyber.inneractive.sdk.player.controller;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.util.t0;

public class v {
    public final Context a;
    public final c b;
    public final Dialog c;
    public final com.fyber.inneractive.sdk.config.global.features.b d;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            v.this.c.dismiss();
            r rVar = (r) v.this.b;
            rVar.b.f(rVar.a);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            v.this.c.dismiss();
            v.this.b.getClass();
        }
    }

    public interface c {
    }

    public v(Context context, com.fyber.inneractive.sdk.config.global.features.b bVar, c cVar) {
        this.a = context;
        this.d = bVar;
        this.b = cVar;
        this.c = new Dialog(context);
        a();
    }

    public final void a() {
        this.c.requestWindowFeature(1);
        this.c.setContentView(R.layout.skip_rewarded_dialog);
        Button button = (Button) this.c.findViewById(R.id.keep_watching_button);
        Button button2 = (Button) this.c.findViewById(R.id.close_button);
        TextView textView = (TextView) this.c.findViewById(R.id.skip_dialog_title_textview);
        TextView textView2 = (TextView) this.c.findViewById(R.id.skip_dialog_sub_title_textview);
        String string = this.a.getString(R.string.skip_rewarded_dialog_keep_watching);
        String string2 = this.a.getString(R.string.skip_rewarded_dialog_close_button);
        String string3 = this.a.getString(R.string.skip_rewarded_dialog_title);
        String string4 = this.a.getString(R.string.skip_rewarded_dialog_sub_title);
        com.fyber.inneractive.sdk.config.global.features.b bVar = this.d;
        if (bVar != null) {
            String str = "KEEP WATCHING";
            String a2 = bVar.a("skip_reward_dialog_keep_watching_button", str);
            if (a2.trim().length() > 0) {
                str = a2.trim();
            }
            if (!TextUtils.isEmpty(str)) {
                string = str;
            }
            String str2 = "CLOSE";
            String a3 = this.d.a("skip_reward_dialog_close_button", str2);
            if (a3.trim().length() > 0) {
                str2 = a3.trim();
            }
            if (!TextUtils.isEmpty(str2)) {
                string2 = str2;
            }
            String str3 = "Close Video?";
            String a4 = this.d.a("skip_reward_dialog_title", str3);
            if (a4.trim().length() > 0) {
                str3 = a4.trim();
            }
            if (!TextUtils.isEmpty(str3)) {
                string3 = str3;
            }
            String str4 = "Reward will not be received before video completion.";
            String a5 = this.d.a("skip_reward_dialog_sub_title", str4);
            if (a5.trim().length() > 0) {
                str4 = a5.trim();
            }
            if (!TextUtils.isEmpty(str4)) {
                string4 = str4;
            }
        }
        button.setText(t0.a(string, 13));
        button2.setText(t0.a(string2, 13));
        textView.setText(t0.a(string3, 20));
        textView2.setText(t0.a(string4, 100));
        button2.setOnClickListener(new a());
        button.setOnClickListener(new b());
    }
}
