package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class a extends Fragment {
    private static final String b = "com.ironsource.lifecycle.IronsourceLifecycleFragment";
    private C0013a a;

    /* renamed from: com.ironsource.lifecycle.a$a  reason: collision with other inner class name */
    interface C0013a {
        void a(Activity activity);

        void b(Activity activity);

        void onResume(Activity activity);
    }

    static a a(Activity activity) {
        return (a) activity.getFragmentManager().findFragmentByTag(b);
    }

    private void a(C0013a aVar) {
        if (aVar != null) {
            aVar.b(getActivity());
        }
    }

    static void b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager != null && fragmentManager.findFragmentByTag(b) == null) {
            fragmentManager.beginTransaction().add(new a(), b).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void b(C0013a aVar) {
        if (aVar != null) {
            aVar.onResume(getActivity());
        }
    }

    private void c(C0013a aVar) {
        if (aVar != null) {
            aVar.a(getActivity());
        }
    }

    /* access modifiers changed from: package-private */
    public void d(C0013a aVar) {
        this.a = aVar;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.a);
    }

    public void onDestroy() {
        super.onDestroy();
        this.a = null;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        b(this.a);
    }

    public void onStart() {
        super.onStart();
        c(this.a);
    }

    public void onStop() {
        super.onStop();
    }
}
