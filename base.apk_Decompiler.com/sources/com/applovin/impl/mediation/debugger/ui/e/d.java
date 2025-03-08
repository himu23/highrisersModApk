package com.applovin.impl.mediation.debugger.ui.e;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.webkit.internal.AssetHelper;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.R;

public class d extends a {
    private String alf;
    private n sdk;
    private String title;

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public void initialize(String str, String str2, n nVar) {
        this.sdk = nVar;
        this.title = str;
        this.alf = str2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_text_view_activity);
        setTitle(this.title);
        ((TextView) findViewById(R.id.textView)).setText(this.alf);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        we();
        return true;
    }

    private void we() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", this.alf);
        intent.putExtra("android.intent.extra.TITLE", this.title);
        intent.putExtra("android.intent.extra.SUBJECT", this.title);
        startActivity(Intent.createChooser(intent, (CharSequence) null));
    }
}
