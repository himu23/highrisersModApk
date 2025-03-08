package com.applovin.exoplayer2.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class i<E> implements Iterable<E> {
    private final Map<E, Integer> abR = new HashMap();
    private Set<E> abS = Collections.emptySet();
    private List<E> abT = Collections.emptyList();
    private final Object rT = new Object();

    public void add(E e) {
        synchronized (this.rT) {
            ArrayList arrayList = new ArrayList(this.abT);
            arrayList.add(e);
            this.abT = Collections.unmodifiableList(arrayList);
            Integer num = this.abR.get(e);
            if (num == null) {
                HashSet hashSet = new HashSet(this.abS);
                hashSet.add(e);
                this.abS = Collections.unmodifiableSet(hashSet);
            }
            Map<E, Integer> map = this.abR;
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            map.put(e, Integer.valueOf(i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O(E r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.rT
            monitor-enter(r0)
            java.util.Map<E, java.lang.Integer> r1 = r4.abR     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x004c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x000f:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x004c }
            java.util.List<E> r3 = r4.abT     // Catch:{ all -> 0x004c }
            r2.<init>(r3)     // Catch:{ all -> 0x004c }
            r2.remove(r5)     // Catch:{ all -> 0x004c }
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)     // Catch:{ all -> 0x004c }
            r4.abT = r2     // Catch:{ all -> 0x004c }
            int r2 = r1.intValue()     // Catch:{ all -> 0x004c }
            r3 = 1
            if (r2 != r3) goto L_0x003c
            java.util.Map<E, java.lang.Integer> r1 = r4.abR     // Catch:{ all -> 0x004c }
            r1.remove(r5)     // Catch:{ all -> 0x004c }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x004c }
            java.util.Set<E> r2 = r4.abS     // Catch:{ all -> 0x004c }
            r1.<init>(r2)     // Catch:{ all -> 0x004c }
            r1.remove(r5)     // Catch:{ all -> 0x004c }
            java.util.Set r5 = java.util.Collections.unmodifiableSet(r1)     // Catch:{ all -> 0x004c }
            r4.abS = r5     // Catch:{ all -> 0x004c }
            goto L_0x004a
        L_0x003c:
            java.util.Map<E, java.lang.Integer> r2 = r4.abR     // Catch:{ all -> 0x004c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004c }
            int r1 = r1 - r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x004c }
            r2.put(r5, r1)     // Catch:{ all -> 0x004c }
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x004c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.l.i.O(java.lang.Object):void");
    }

    public Set<E> gN() {
        Set<E> set;
        synchronized (this.rT) {
            set = this.abS;
        }
        return set;
    }

    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.rT) {
            it = this.abT.iterator();
        }
        return it;
    }

    public int P(E e) {
        int intValue;
        synchronized (this.rT) {
            intValue = this.abR.containsKey(e) ? this.abR.get(e).intValue() : 0;
        }
        return intValue;
    }
}
