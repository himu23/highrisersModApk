package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinUserService;

public class UserServiceImpl implements AppLovinUserService {
    private final n sdk;

    public String toString() {
        return "UserService{}";
    }

    UserServiceImpl(n nVar) {
        this.sdk = nVar;
    }

    public void preloadConsentDialog() {
        this.sdk.BY().preloadConsentDialog();
    }

    public void showConsentDialog(Activity activity, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        this.sdk.BY().a(activity, onConsentDialogDismissListener);
    }
}
