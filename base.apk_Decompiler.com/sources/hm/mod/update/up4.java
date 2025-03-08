package hm.mod.update;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class up4 implements View.OnClickListener {
    private final String mAuthor;
    private Context mContext;
    private final String mIcon;
    private final String mPackageName;
    private final String mTitle;
    private final String mUrl;

    public up4(Context context, String str, String str2, String str3, String str4, String str5) {
        this.mContext = context;
        this.mIcon = str2;
        this.mPackageName = str3;
        this.mTitle = str;
        this.mAuthor = str4;
        this.mUrl = str5;
    }

    public void onClick(View view) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("modupdate://starthm/detail?title=" + this.mTitle + "&icon=" + this.mIcon + "&packageName=" + this.mPackageName + "&author=" + this.mAuthor));
            this.mContext.startActivity(intent);
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(this.mUrl));
            this.mContext.startActivity(intent2);
        }
    }
}
