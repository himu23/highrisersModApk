package com.applovin.exoplayer2.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Splitter {
    /* access modifiers changed from: private */
    public final int limit;
    /* access modifiers changed from: private */
    public final boolean omitEmptyStrings;
    private final b strategy;
    /* access modifiers changed from: private */
    public final CharMatcher trimmer;

    private interface b {
        Iterator<String> b(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(b bVar) {
        this(bVar, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    private Splitter(b bVar, boolean z, CharMatcher charMatcher, int i) {
        this.strategy = bVar;
        this.omitEmptyStrings = z;
        this.trimmer = charMatcher;
        this.limit = i;
    }

    public static Splitter on(char c) {
        return on(CharMatcher.is(c));
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new b() {
            /* renamed from: a */
            public a b(Splitter splitter, CharSequence charSequence) {
                return new a(splitter, charSequence) {
                    /* access modifiers changed from: package-private */
                    public int aQ(int i) {
                        return i + 1;
                    }

                    /* access modifiers changed from: package-private */
                    public int aP(int i) {
                        return CharMatcher.this.indexIn(this.oT, i);
                    }
                };
            }
        });
    }

    public static Splitter on(final String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new b() {
            /* renamed from: a */
            public a b(Splitter splitter, CharSequence charSequence) {
                return new a(splitter, charSequence) {
                    public int aP(int i) {
                        int length = str.length();
                        int length2 = this.oT.length() - length;
                        while (i <= length2) {
                            int i2 = 0;
                            while (i2 < length) {
                                if (this.oT.charAt(i2 + i) != str.charAt(i2)) {
                                    i++;
                                } else {
                                    i2++;
                                }
                            }
                            return i;
                        }
                        return -1;
                    }

                    public int aQ(int i) {
                        return i + str.length();
                    }
                };
            }
        });
    }

    public static Splitter fixedLength(final int i) {
        Preconditions.checkArgument(i > 0, "The length may not be less than 1");
        return new Splitter(new b() {
            /* renamed from: a */
            public a b(Splitter splitter, CharSequence charSequence) {
                return new a(splitter, charSequence) {
                    public int aQ(int i) {
                        return i;
                    }

                    public int aP(int i) {
                        int i2 = i + i;
                        if (i2 < this.oT.length()) {
                            return i2;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Splitter limit(int i) {
        Preconditions.checkArgument(i > 0, "must be greater than zero: %s", i);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    private Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.b(this, charSequence);
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> splittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (splittingIterator.hasNext()) {
            arrayList.add(splittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static abstract class a extends b<String> {
        int limit;
        final CharSequence oT;
        int oU = 0;
        final boolean omitEmptyStrings;
        final CharMatcher trimmer;

        /* access modifiers changed from: package-private */
        public abstract int aP(int i);

        /* access modifiers changed from: package-private */
        public abstract int aQ(int i);

        protected a(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.oT = charSequence;
        }

        /* access modifiers changed from: protected */
        /* renamed from: fa */
        public String eT() {
            int i;
            int i2 = this.oU;
            while (true) {
                int i3 = this.oU;
                if (i3 == -1) {
                    return (String) eU();
                }
                int aP = aP(i3);
                if (aP == -1) {
                    aP = this.oT.length();
                    this.oU = -1;
                } else {
                    this.oU = aQ(aP);
                }
                int i4 = this.oU;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.oU = i5;
                    if (i5 > this.oT.length()) {
                        this.oU = -1;
                    }
                } else {
                    while (i2 < aP && this.trimmer.matches(this.oT.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.trimmer.matches(this.oT.charAt(i - 1))) {
                        aP = i - 1;
                    }
                    if (!this.omitEmptyStrings || i2 != i) {
                        int i6 = this.limit;
                    } else {
                        i2 = this.oU;
                    }
                }
            }
            int i62 = this.limit;
            if (i62 == 1) {
                i = this.oT.length();
                this.oU = -1;
                while (i > i2 && this.trimmer.matches(this.oT.charAt(i - 1))) {
                    i--;
                }
            } else {
                this.limit = i62 - 1;
            }
            return this.oT.subSequence(i2, i).toString();
        }
    }
}
