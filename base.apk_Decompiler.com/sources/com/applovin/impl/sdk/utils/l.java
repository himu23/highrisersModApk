package com.applovin.impl.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.net.URL;

public class l {
    public static void a(ImageView imageView, String str, n nVar) {
        if (!TextUtils.isEmpty(str) && imageView != null) {
            nVar.BN();
            if (x.Fn()) {
                x BN = nVar.BN();
                BN.f("ImageViewUtils", "Fetching image: " + str + "...");
            }
            nVar.BO().KJ().execute(new l$$ExternalSyntheticLambda4(str, nVar, imageView));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String str, n nVar, ImageView imageView) {
        InputStream inputStream = null;
        try {
            inputStream = new URL(str).openStream();
            AppLovinSdkUtils.runOnUiThread(new l$$ExternalSyntheticLambda0(nVar, BitmapFactory.decodeStream(inputStream), imageView));
        } catch (Throwable th) {
            u.a((Closeable) inputStream, nVar);
            throw th;
        }
        u.a((Closeable) inputStream, nVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(n nVar, Bitmap bitmap, ImageView imageView) {
        nVar.BN();
        if (x.Fn()) {
            nVar.BN().f("ImageViewUtils", "Image fetched");
        }
        imageView.setImageDrawable(new BitmapDrawable(n.getApplicationContext().getResources(), bitmap));
    }

    public static void a(ImageView imageView, Uri uri) {
        if (uri != null && imageView != null) {
            if (imageView.getHeight() <= 0 || imageView.getWidth() <= 0) {
                imageView.post(new l$$ExternalSyntheticLambda1(imageView, uri));
            } else {
                b(imageView, uri);
            }
        }
    }

    public static void b(ImageView imageView, Uri uri) {
        if (uri != null && imageView != null) {
            if (n.aAC == null) {
                x.H("ImageViewUtils", "SDK has not been initialized");
            } else {
                n.aAC.BO().KJ().execute(new l$$ExternalSyntheticLambda3(uri, imageView));
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Uri uri, ImageView imageView) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(uri.getPath(), options);
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        if (height <= 0 || width <= 0) {
            Point Y = h.Y(imageView.getContext());
            height = Math.min(Y.x, Y.y);
            width = height;
        }
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 > height || i3 > width) {
            while (true) {
                int i4 = i * 2;
                if (i2 / i4 < height && i3 / i4 < width) {
                    break;
                }
                i = i4;
            }
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        n.aAC.BN();
        if (x.Fn()) {
            x BN = n.aAC.BN();
            BN.f("ImageViewUtils", "Loading image: " + uri.getLastPathSegment() + "...");
        }
        AppLovinSdkUtils.runOnUiThread(new l$$ExternalSyntheticLambda2(imageView, BitmapFactory.decodeFile(uri.getPath(), options)));
    }
}
