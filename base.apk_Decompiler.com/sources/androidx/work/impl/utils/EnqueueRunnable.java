package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.List;

public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation = new OperationImpl();
    private final WorkContinuationImpl mWorkContinuation;

    public Operation getOperation() {
        return this.mOperation;
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.mOperation.setState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.mWorkContinuation}));
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z = false;
        if (parents != null) {
            boolean z2 = false;
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z2 |= processContinuation(next);
                } else {
                    Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", next.getIds())}), new Throwable[0]);
                }
            }
            z = z2;
        }
        return enqueueContinuation(workContinuationImpl) | z;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01e6 A[LOOP:7: B:118:0x01e0->B:120:0x01e6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x020f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r18, java.util.List<? extends androidx.work.WorkRequest> r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = r22
            long r4 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r6 = r18.getWorkDatabase()
            r7 = 1
            if (r1 == 0) goto L_0x0018
            int r9 = r1.length
            if (r9 <= 0) goto L_0x0018
            r9 = 1
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            if (r9 == 0) goto L_0x005d
            int r10 = r1.length
            r11 = 0
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0020:
            if (r11 >= r10) goto L_0x0060
            r15 = r1[r11]
            androidx.work.impl.model.WorkSpecDao r8 = r6.workSpecDao()
            androidx.work.impl.model.WorkSpec r8 = r8.getWorkSpec(r15)
            if (r8 != 0) goto L_0x0045
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r3 = 0
            r2[r3] = r15
            java.lang.String r4 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String r2 = java.lang.String.format(r4, r2)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r3]
            r0.error(r1, r2, r4)
            return r3
        L_0x0045:
            androidx.work.WorkInfo$State r8 = r8.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r8 != r15) goto L_0x004d
            r15 = 1
            goto L_0x004e
        L_0x004d:
            r15 = 0
        L_0x004e:
            r12 = r12 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r8 != r15) goto L_0x0055
            r14 = 1
            goto L_0x005a
        L_0x0055:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r8 != r15) goto L_0x005a
            r13 = 1
        L_0x005a:
            int r11 = r11 + 1
            goto L_0x0020
        L_0x005d:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0060:
            boolean r8 = android.text.TextUtils.isEmpty(r21)
            r8 = r8 ^ r7
            if (r8 == 0) goto L_0x014f
            if (r9 != 0) goto L_0x014f
            androidx.work.impl.model.WorkSpecDao r10 = r6.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r2)
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x014f
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND
            if (r3 == r11) goto L_0x00ca
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r11) goto L_0x0080
            goto L_0x00ca
        L_0x0080:
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.KEEP
            if (r3 != r11) goto L_0x00a5
            java.util.Iterator r3 = r10.iterator()
        L_0x0088:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x00a5
            java.lang.Object r11 = r3.next()
            androidx.work.impl.model.WorkSpec$IdAndState r11 = (androidx.work.impl.model.WorkSpec.IdAndState) r11
            androidx.work.WorkInfo$State r15 = r11.state
            androidx.work.WorkInfo$State r7 = androidx.work.WorkInfo.State.ENQUEUED
            if (r15 == r7) goto L_0x00a3
            androidx.work.WorkInfo$State r7 = r11.state
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.RUNNING
            if (r7 != r11) goto L_0x00a1
            goto L_0x00a3
        L_0x00a1:
            r7 = 1
            goto L_0x0088
        L_0x00a3:
            r7 = 0
            return r7
        L_0x00a5:
            r7 = 0
            androidx.work.impl.utils.CancelWorkRunnable r3 = androidx.work.impl.utils.CancelWorkRunnable.forName(r2, r0, r7)
            r3.run()
            androidx.work.impl.model.WorkSpecDao r3 = r6.workSpecDao()
            java.util.Iterator r10 = r10.iterator()
        L_0x00b5:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00c7
            java.lang.Object r11 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r11 = (androidx.work.impl.model.WorkSpec.IdAndState) r11
            java.lang.String r11 = r11.id
            r3.delete(r11)
            goto L_0x00b5
        L_0x00c7:
            r3 = 1
            goto L_0x0150
        L_0x00ca:
            r7 = 0
            androidx.work.impl.model.DependencyDao r9 = r6.dependencyDao()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00d8:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x0114
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r7 = r15.id
            boolean r7 = r9.hasDependents(r7)
            if (r7 != 0) goto L_0x010e
            androidx.work.WorkInfo$State r7 = r15.state
            r16 = r9
            androidx.work.WorkInfo$State r9 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r9) goto L_0x00f6
            r7 = 1
            goto L_0x00f7
        L_0x00f6:
            r7 = 0
        L_0x00f7:
            r7 = r7 & r12
            androidx.work.WorkInfo$State r9 = r15.state
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.FAILED
            if (r9 != r12) goto L_0x0100
            r14 = 1
            goto L_0x0107
        L_0x0100:
            androidx.work.WorkInfo$State r9 = r15.state
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.CANCELLED
            if (r9 != r12) goto L_0x0107
            r13 = 1
        L_0x0107:
            java.lang.String r9 = r15.id
            r11.add(r9)
            r12 = r7
            goto L_0x0110
        L_0x010e:
            r16 = r9
        L_0x0110:
            r9 = r16
            r7 = 0
            goto L_0x00d8
        L_0x0114:
            androidx.work.ExistingWorkPolicy r7 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r7) goto L_0x0141
            if (r13 != 0) goto L_0x011c
            if (r14 == 0) goto L_0x0141
        L_0x011c:
            androidx.work.impl.model.WorkSpecDao r3 = r6.workSpecDao()
            java.util.List r7 = r3.getWorkSpecIdAndStatesForName(r2)
            java.util.Iterator r7 = r7.iterator()
        L_0x0128:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x013a
            java.lang.Object r9 = r7.next()
            androidx.work.impl.model.WorkSpec$IdAndState r9 = (androidx.work.impl.model.WorkSpec.IdAndState) r9
            java.lang.String r9 = r9.id
            r3.delete(r9)
            goto L_0x0128
        L_0x013a:
            java.util.List r11 = java.util.Collections.emptyList()
            r3 = 0
            r13 = 0
            goto L_0x0142
        L_0x0141:
            r3 = r14
        L_0x0142:
            java.lang.Object[] r1 = r11.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r7 = r1.length
            if (r7 <= 0) goto L_0x014d
            r9 = 1
            goto L_0x014e
        L_0x014d:
            r9 = 0
        L_0x014e:
            r14 = r3
        L_0x014f:
            r3 = 0
        L_0x0150:
            java.util.Iterator r7 = r19.iterator()
        L_0x0154:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x0215
            java.lang.Object r10 = r7.next()
            androidx.work.WorkRequest r10 = (androidx.work.WorkRequest) r10
            androidx.work.impl.model.WorkSpec r11 = r10.getWorkSpec()
            if (r9 == 0) goto L_0x017b
            if (r12 != 0) goto L_0x017b
            if (r14 == 0) goto L_0x016f
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            r11.state = r15
            goto L_0x0183
        L_0x016f:
            if (r13 == 0) goto L_0x0176
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            r11.state = r15
            goto L_0x0183
        L_0x0176:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.BLOCKED
            r11.state = r15
            goto L_0x0183
        L_0x017b:
            boolean r15 = r11.isPeriodic()
            if (r15 != 0) goto L_0x0186
            r11.periodStartTime = r4
        L_0x0183:
            r16 = r4
            goto L_0x018c
        L_0x0186:
            r16 = r4
            r4 = 0
            r11.periodStartTime = r4
        L_0x018c:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x019c
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 25
            if (r4 > r5) goto L_0x019c
            tryDelegateConstrainedWorkSpec(r11)
            goto L_0x01ad
        L_0x019c:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 22
            if (r4 > r5) goto L_0x01ad
            java.lang.String r4 = "androidx.work.impl.background.gcm.GcmScheduler"
            boolean r4 = usesScheduler(r0, r4)
            if (r4 == 0) goto L_0x01ad
            tryDelegateConstrainedWorkSpec(r11)
        L_0x01ad:
            androidx.work.WorkInfo$State r4 = r11.state
            androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.ENQUEUED
            if (r4 != r5) goto L_0x01b4
            r3 = 1
        L_0x01b4:
            androidx.work.impl.model.WorkSpecDao r4 = r6.workSpecDao()
            r4.insertWorkSpec(r11)
            if (r9 == 0) goto L_0x01d8
            int r4 = r1.length
            r5 = 0
        L_0x01bf:
            if (r5 >= r4) goto L_0x01d8
            r11 = r1[r5]
            androidx.work.impl.model.Dependency r15 = new androidx.work.impl.model.Dependency
            java.lang.String r0 = r10.getStringId()
            r15.<init>(r0, r11)
            androidx.work.impl.model.DependencyDao r0 = r6.dependencyDao()
            r0.insertDependency(r15)
            int r5 = r5 + 1
            r0 = r18
            goto L_0x01bf
        L_0x01d8:
            java.util.Set r0 = r10.getTags()
            java.util.Iterator r0 = r0.iterator()
        L_0x01e0:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01fd
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            androidx.work.impl.model.WorkTagDao r5 = r6.workTagDao()
            androidx.work.impl.model.WorkTag r11 = new androidx.work.impl.model.WorkTag
            java.lang.String r15 = r10.getStringId()
            r11.<init>(r4, r15)
            r5.insert(r11)
            goto L_0x01e0
        L_0x01fd:
            if (r8 == 0) goto L_0x020f
            androidx.work.impl.model.WorkNameDao r0 = r6.workNameDao()
            androidx.work.impl.model.WorkName r4 = new androidx.work.impl.model.WorkName
            java.lang.String r5 = r10.getStringId()
            r4.<init>(r2, r5)
            r0.insert(r4)
        L_0x020f:
            r0 = r18
            r4 = r16
            goto L_0x0154
        L_0x0215:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            Data.Builder builder = new Data.Builder();
            builder.putAll(workSpec.input).putString(ConstraintTrackingWorker.ARGUMENT_CLASS_NAME, str);
            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
            workSpec.input = builder.build();
        }
    }

    private static boolean usesScheduler(WorkManagerImpl workManagerImpl, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (Scheduler scheduler : workManagerImpl.getSchedulers()) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }
}
