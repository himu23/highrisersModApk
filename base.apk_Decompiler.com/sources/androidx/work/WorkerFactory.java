package androidx.work;

import android.content.Context;

public abstract class WorkerFactory {
    private static final String TAG = Logger.tagWithPrefix("WorkerFactory");

    public abstract ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker createWorkerWithDefaultFallback(Context context, String str, WorkerParameters workerParameters) {
        Class<? extends U> cls;
        ListenableWorker createWorker = createWorker(context, str, workerParameters);
        if (createWorker == null) {
            try {
                cls = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                Logger logger = Logger.get();
                String str2 = TAG;
                logger.error(str2, "Invalid class: " + str, th);
                cls = null;
            }
            if (cls != null) {
                try {
                    createWorker = (ListenableWorker) cls.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
                } catch (Throwable th2) {
                    Logger logger2 = Logger.get();
                    String str3 = TAG;
                    logger2.error(str3, "Could not instantiate " + str, th2);
                }
            }
        }
        if (createWorker == null || !createWorker.isUsed()) {
            return createWorker;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", new Object[]{getClass().getName(), str}));
    }

    public static WorkerFactory getDefaultWorkerFactory() {
        return new WorkerFactory() {
            public ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }
        };
    }
}
