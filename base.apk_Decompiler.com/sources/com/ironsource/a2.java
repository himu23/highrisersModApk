package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.environment.workerthread.WorkerManager;
import com.ironsource.environment.workerthread.WorkerResult;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class a2 {

    class a implements WorkerManager.WorkEndedListener<b2> {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        public void onWorkCompleted(List<WorkerResult<b2>> list, long j) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (WorkerResult next : list) {
                if (next instanceof WorkerResult.Completed) {
                    arrayList2.add((b2) ((WorkerResult.Completed) next).data);
                } else if (next instanceof WorkerResult.Canceled) {
                    arrayList.add(((x1) ((WorkerResult.Canceled) next).callable).c());
                } else if (next instanceof WorkerResult.Failed) {
                    WorkerResult.Failed failed = (WorkerResult.Failed) next;
                    x1 x1Var = (x1) failed.callable;
                    arrayList2.add(new b2(x1Var.d(), x1Var.c(), (Map<String, Object>) null, 0, failed.exception.getMessage()));
                }
            }
            a2.this.a(arrayList2, arrayList, j);
            this.a.a(arrayList2, j, arrayList);
        }

        public void onWorkFailed(String str) {
            String str2 = "failed to collect bidding data, error= " + str;
            IronLog.INTERNAL.verbose(str2);
            this.a.onFailure(str2);
        }
    }

    public interface b {
        void a(List<b2> list, long j, List<String> list2);

        void onFailure(String str);
    }

    /* access modifiers changed from: private */
    public void a(List<b2> list, List<String> list2, long j) {
        IronLog ironLog;
        String str;
        StringBuilder sb;
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.verbose("tokens received=" + list.size() + ", reached timeout=" + list2.size() + ", total duration=" + j + " millis");
        for (b2 next : list) {
            if (next.a() != null) {
                ironLog = IronLog.INTERNAL;
                sb = new StringBuilder();
                sb.append(next.c());
                sb.append(" - success (");
                sb.append(next.e());
                str = " millis)";
            } else {
                ironLog = IronLog.INTERNAL;
                sb = new StringBuilder();
                sb.append(next.c());
                sb.append(" - failed (");
                sb.append(next.e());
                sb.append(" millis) error: ");
                str = next.b();
            }
            sb.append(str);
            ironLog.verbose(sb.toString());
        }
        for (String str2 : list2) {
            IronLog ironLog3 = IronLog.INTERNAL;
            ironLog3.verbose(str2 + " reached timeout");
        }
    }

    public void a(List<x1> list, b bVar, long j, TimeUnit timeUnit) {
        try {
            if (list.isEmpty()) {
                IronLog.INTERNAL.verbose("BiddingDataCallable list is empty");
                return;
            }
            WorkerManager workerManager = new WorkerManager(IronSourceThreadManager.INSTANCE.getThreadPoolExecutor());
            for (x1 addCallable : list) {
                workerManager.addCallable(addCallable);
            }
            IronLog.INTERNAL.verbose("instances=" + list.size() + ", timeout=" + j + " millis");
            workerManager.startWork(new a(bVar), j, timeUnit);
        } catch (Throwable th) {
            String str = "Exception - failed to collect bidding data, error= " + th.getMessage();
            IronLog.INTERNAL.error(str);
            bVar.onFailure(str);
        }
    }
}
