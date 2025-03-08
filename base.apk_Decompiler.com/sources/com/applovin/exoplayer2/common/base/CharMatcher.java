package com.applovin.exoplayer2.common.base;

import androidx.core.internal.view.SupportMenu;
import java.util.Arrays;
import java.util.BitSet;

public abstract class CharMatcher implements Predicate<Character> {
    public abstract boolean matches(char c2);

    public static CharMatcher any() {
        return b.nK;
    }

    public static CharMatcher none() {
        return w.oe;
    }

    public static CharMatcher whitespace() {
        return aa.oj;
    }

    public static CharMatcher breakingWhitespace() {
        return e.nN;
    }

    public static CharMatcher ascii() {
        return d.nM;
    }

    @Deprecated
    public static CharMatcher digit() {
        return f.nO;
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return n.nW;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return p.nY;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return q.nZ;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return s.ob;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return r.oa;
    }

    public static CharMatcher javaIsoControl() {
        return o.nX;
    }

    @Deprecated
    public static CharMatcher invisible() {
        return j.nS;
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return z.oh;
    }

    public static CharMatcher is(char c2) {
        return new k(c2);
    }

    public static CharMatcher isNot(char c2) {
        return new m(c2);
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return none();
        }
        if (length == 1) {
            return is(charSequence.charAt(0));
        }
        if (length != 2) {
            return new c(charSequence);
        }
        return isEither(charSequence.charAt(0), charSequence.charAt(1));
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    public static CharMatcher inRange(char c2, char c3) {
        return new i(c2, c3);
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        return predicate instanceof CharMatcher ? (CharMatcher) predicate : new h(predicate);
    }

    protected CharMatcher() {
    }

    public CharMatcher negate() {
        return new u(this);
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new a(this, charMatcher);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new x(this, charMatcher);
    }

    /* access modifiers changed from: package-private */
    public void setBits(BitSet bitSet) {
        for (int i2 = SupportMenu.USER_MASK; i2 >= 0; i2--) {
            if (matches((char) i2)) {
                bitSet.set(i2);
            }
        }
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesAllOf(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        return indexIn(charSequence) == -1;
    }

    public int indexIn(CharSequence charSequence) {
        return indexIn(charSequence, 0);
    }

    public int indexIn(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i2, length);
        while (i2 < length) {
            if (matches(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public int countIn(CharSequence charSequence) {
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (matches(charSequence.charAt(i3))) {
                i2++;
            }
        }
        return i2;
    }

    public String removeFrom(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        int i2 = 1;
        while (true) {
            indexIn++;
            while (indexIn != charArray.length) {
                if (matches(charArray[indexIn])) {
                    i2++;
                } else {
                    charArray[indexIn - i2] = charArray[indexIn];
                    indexIn++;
                }
            }
            return new String(charArray, 0, indexIn - i2);
        }
    }

    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    public String replaceFrom(CharSequence charSequence, char c2) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        charArray[indexIn] = c2;
        while (true) {
            indexIn++;
            if (indexIn >= charArray.length) {
                return new String(charArray);
            }
            if (matches(charArray[indexIn])) {
                charArray[indexIn] = c2;
            }
        }
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        int i2 = 0;
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        String charSequence3 = charSequence.toString();
        int indexIn = indexIn(charSequence3);
        if (indexIn == -1) {
            return charSequence3;
        }
        int length2 = charSequence3.length();
        StringBuilder sb = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append(charSequence3, i2, indexIn);
            sb.append(charSequence2);
            i2 = indexIn + 1;
            indexIn = indexIn(charSequence3, i2);
        } while (indexIn != -1);
        sb.append(charSequence3, i2, length2);
        return sb.toString();
    }

    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && matches(charSequence.charAt(i2))) {
            i2++;
        }
        int i3 = length - 1;
        while (i3 > i2 && matches(charSequence.charAt(i3))) {
            i3--;
        }
        return charSequence.subSequence(i2, i3 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!matches(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, length).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public String collapseFrom(CharSequence charSequence, char c2) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (matches(charAt)) {
                if (charAt != c2 || (i2 != length - 1 && matches(charSequence.charAt(i2 + 1)))) {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i2);
                    sb.append(c2);
                    return finishCollapseFrom(charSequence, i2 + 1, length, c2, sb, true);
                }
                i2++;
            }
            i2++;
        }
        return charSequence.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c2) {
        int length = charSequence.length();
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < length && matches(charSequence.charAt(i3))) {
            i3++;
        }
        int i4 = i2;
        while (i4 > i3 && matches(charSequence.charAt(i4))) {
            i4--;
        }
        if (i3 == 0 && i4 == i2) {
            return collapseFrom(charSequence, c2);
        }
        int i5 = i4 + 1;
        return finishCollapseFrom(charSequence, i3, i5, c2, new StringBuilder(i5 - i3), false);
    }

    private String finishCollapseFrom(CharSequence charSequence, int i2, int i3, char c2, StringBuilder sb, boolean z2) {
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            if (!matches(charAt)) {
                sb.append(charAt);
                z2 = false;
            } else if (!z2) {
                sb.append(c2);
                z2 = true;
            }
            i2++;
        }
        return sb.toString();
    }

    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
    }

    public String toString() {
        return super.toString();
    }

    /* access modifiers changed from: private */
    public static String showCharacter(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    static abstract class g extends CharMatcher {
        g() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public CharMatcher negate() {
            return new v(this);
        }
    }

    static abstract class t extends g {
        private final String oc;

        public final String toString() {
            return this.oc;
        }

        t(String str) {
            this.oc = (String) Preconditions.checkNotNull(str);
        }
    }

    static class v extends u {
        v(CharMatcher charMatcher) {
            super(charMatcher);
        }
    }

    private static final class b extends t {
        static final b nK = new b();

        public boolean matches(char c) {
            return true;
        }

        private b() {
            super("CharMatcher.any()");
        }

        public int indexIn(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        public int indexIn(CharSequence charSequence, int i) {
            int length = charSequence.length();
            Preconditions.checkPositionIndex(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }

        public int lastIndexIn(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        public boolean matchesAllOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        public boolean matchesNoneOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public String removeFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        public String replaceFrom(CharSequence charSequence, char c) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c);
            return new String(cArr);
        }

        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i = 0; i < charSequence.length(); i++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }

        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.length() == 0 ? "" : String.valueOf(c);
        }

        public String trimFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        public int countIn(CharSequence charSequence) {
            return charSequence.length();
        }

        public CharMatcher and(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        public CharMatcher or(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        public CharMatcher negate() {
            return none();
        }
    }

    private static final class w extends t {
        static final w oe = new w();

        public boolean matches(char c) {
            return false;
        }

        private w() {
            super("CharMatcher.none()");
        }

        public int indexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        public int indexIn(CharSequence charSequence, int i) {
            Preconditions.checkPositionIndex(i, charSequence.length());
            return -1;
        }

        public int lastIndexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        public boolean matchesAllOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean matchesNoneOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        public String removeFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String replaceFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            Preconditions.checkNotNull(charSequence2);
            return charSequence.toString();
        }

        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        public String trimFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String trimLeadingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String trimTrailingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public int countIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return 0;
        }

        public CharMatcher and(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        public CharMatcher or(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        public CharMatcher negate() {
            return any();
        }
    }

    static final class aa extends t {
        static final int oi = Integer.numberOfLeadingZeros(31);
        static final aa oj = new aa();

        aa() {
            super("CharMatcher.whitespace()");
        }

        public boolean matches(char c) {
            return " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt((48906 * c) >>> oi) == c;
        }

        /* access modifiers changed from: package-private */
        public void setBits(BitSet bitSet) {
            for (int i = 0; i < 32; i++) {
                bitSet.set(" 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt(i));
            }
        }
    }

    private static final class e extends CharMatcher {
        static final CharMatcher nN = new e();

        public boolean matches(char c) {
            if (!(c == ' ' || c == 133 || c == 5760)) {
                if (c == 8199) {
                    return false;
                }
                if (!(c == 8287 || c == 12288 || c == 8232 || c == 8233)) {
                    switch (c) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            return c >= 8192 && c <= 8202;
                    }
                }
            }
            return true;
        }

        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }

        private e() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }
    }

    private static final class d extends t {
        static final d nM = new d();

        public boolean matches(char c) {
            return c <= 127;
        }

        d() {
            super("CharMatcher.ascii()");
        }
    }

    private static class y extends CharMatcher {
        private final String oc;
        private final char[] of;
        private final char[] og;

        public String toString() {
            return this.oc;
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        y(String str, char[] cArr, char[] cArr2) {
            this.oc = str;
            this.of = cArr;
            this.og = cArr2;
            Preconditions.checkArgument(cArr.length == cArr2.length);
            int i = 0;
            while (i < cArr.length) {
                Preconditions.checkArgument(cArr[i] <= cArr2[i]);
                int i2 = i + 1;
                if (i2 < cArr.length) {
                    Preconditions.checkArgument(cArr2[i] < cArr[i2]);
                }
                i = i2;
            }
        }

        public boolean matches(char c) {
            int binarySearch = Arrays.binarySearch(this.of, c);
            if (binarySearch >= 0) {
                return true;
            }
            int i = (~binarySearch) - 1;
            if (i < 0 || c > this.og[i]) {
                return false;
            }
            return true;
        }
    }

    private static final class f extends y {
        static final f nO = new f();

        private static char[] eW() {
            return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
        }

        private static char[] eX() {
            char[] cArr = new char[37];
            for (int i = 0; i < 37; i++) {
                cArr[i] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i) + 9);
            }
            return cArr;
        }

        private f() {
            super("CharMatcher.digit()", eW(), eX());
        }
    }

    private static final class n extends CharMatcher {
        static final n nW = new n();

        public String toString() {
            return "CharMatcher.javaDigit()";
        }

        private n() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isDigit(c);
        }
    }

    private static final class p extends CharMatcher {
        static final p nY = new p();

        public String toString() {
            return "CharMatcher.javaLetter()";
        }

        private p() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isLetter(c);
        }
    }

    private static final class q extends CharMatcher {
        static final q nZ = new q();

        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }

        private q() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    private static final class s extends CharMatcher {
        static final s ob = new s();

        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }

        private s() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isUpperCase(c);
        }
    }

    private static final class r extends CharMatcher {
        static final r oa = new r();

        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }

        private r() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isLowerCase(c);
        }
    }

    private static final class o extends t {
        static final o nX = new o();

        public boolean matches(char c) {
            return c <= 31 || (c >= 127 && c <= 159);
        }

        private o() {
            super("CharMatcher.javaIsoControl()");
        }
    }

    private static final class j extends y {
        static final j nS = new j();

        private j() {
            super("CharMatcher.invisible()", "\u0000­؀؜۝܏࣢ ᠎   ⁦　?﻿￹".toCharArray(), "  ­؅؜۝܏࣢ ᠎‏ ⁤⁯　﻿￻".toCharArray());
        }
    }

    private static final class z extends y {
        static final z oh = new z();

        private z() {
            super("CharMatcher.singleWidth()", "\u0000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
        }
    }

    private static class u extends CharMatcher {
        final CharMatcher od;

        public CharMatcher negate() {
            return this.od;
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        u(CharMatcher charMatcher) {
            this.od = (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        public boolean matches(char c) {
            return !this.od.matches(c);
        }

        public boolean matchesAllOf(CharSequence charSequence) {
            return this.od.matchesNoneOf(charSequence);
        }

        public boolean matchesNoneOf(CharSequence charSequence) {
            return this.od.matchesAllOf(charSequence);
        }

        public int countIn(CharSequence charSequence) {
            return charSequence.length() - this.od.countIn(charSequence);
        }

        /* access modifiers changed from: package-private */
        public void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.od.setBits(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        public String toString() {
            return this.od + ".negate()";
        }
    }

    private static final class a extends CharMatcher {
        final CharMatcher nI;
        final CharMatcher nJ;

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        a(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.nI = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.nJ = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        public boolean matches(char c) {
            return this.nI.matches(c) && this.nJ.matches(c);
        }

        /* access modifiers changed from: package-private */
        public void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.nI.setBits(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.nJ.setBits(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        public String toString() {
            return "CharMatcher.and(" + this.nI + ", " + this.nJ + ")";
        }
    }

    private static final class x extends CharMatcher {
        final CharMatcher nI;
        final CharMatcher nJ;

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        x(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.nI = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.nJ = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        /* access modifiers changed from: package-private */
        public void setBits(BitSet bitSet) {
            this.nI.setBits(bitSet);
            this.nJ.setBits(bitSet);
        }

        public boolean matches(char c) {
            return this.nI.matches(c) || this.nJ.matches(c);
        }

        public String toString() {
            return "CharMatcher.or(" + this.nI + ", " + this.nJ + ")";
        }
    }

    private static final class k extends g {
        private final char nT;

        public boolean matches(char c) {
            return c == this.nT;
        }

        k(char c) {
            this.nT = c;
        }

        public String replaceFrom(CharSequence charSequence, char c) {
            return charSequence.toString().replace(this.nT, c);
        }

        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.nT) ? this : none();
        }

        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.nT) ? charMatcher : super.or(charMatcher);
        }

        public CharMatcher negate() {
            return isNot(this.nT);
        }

        /* access modifiers changed from: package-private */
        public void setBits(BitSet bitSet) {
            bitSet.set(this.nT);
        }

        public String toString() {
            return "CharMatcher.is('" + CharMatcher.showCharacter(this.nT) + "')";
        }
    }

    private static final class m extends g {
        private final char nT;

        public boolean matches(char c) {
            return c != this.nT;
        }

        m(char c) {
            this.nT = c;
        }

        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.nT) ? super.and(charMatcher) : charMatcher;
        }

        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.nT) ? any() : this;
        }

        /* access modifiers changed from: package-private */
        public void setBits(BitSet bitSet) {
            bitSet.set(0, this.nT);
            bitSet.set(this.nT + 1, 65536);
        }

        public CharMatcher negate() {
            return is(this.nT);
        }

        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.showCharacter(this.nT) + "')";
        }
    }

    private static l isEither(char c2, char c3) {
        return new l(c2, c3);
    }

    private static final class l extends g {
        private final char nU;
        private final char nV;

        public boolean matches(char c) {
            return c == this.nU || c == this.nV;
        }

        l(char c, char c2) {
            this.nU = c;
            this.nV = c2;
        }

        /* access modifiers changed from: package-private */
        public void setBits(BitSet bitSet) {
            bitSet.set(this.nU);
            bitSet.set(this.nV);
        }

        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(this.nU) + CharMatcher.showCharacter(this.nV) + "\")";
        }
    }

    private static final class c extends CharMatcher {
        private final char[] nL;

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public c(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.nL = charArray;
            Arrays.sort(charArray);
        }

        public boolean matches(char c) {
            return Arrays.binarySearch(this.nL, c) >= 0;
        }

        /* access modifiers changed from: package-private */
        public void setBits(BitSet bitSet) {
            for (char c : this.nL) {
                bitSet.set(c);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char access$000 : this.nL) {
                sb.append(CharMatcher.showCharacter(access$000));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    private static final class i extends g {
        private final char nQ;
        private final char nR;

        public boolean matches(char c) {
            return this.nQ <= c && c <= this.nR;
        }

        i(char c, char c2) {
            Preconditions.checkArgument(c2 >= c);
            this.nQ = c;
            this.nR = c2;
        }

        /* access modifiers changed from: package-private */
        public void setBits(BitSet bitSet) {
            bitSet.set(this.nQ, this.nR + 1);
        }

        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.showCharacter(this.nQ) + "', '" + CharMatcher.showCharacter(this.nR) + "')";
        }
    }

    private static final class h extends CharMatcher {
        private final Predicate<? super Character> nP;

        h(Predicate<? super Character> predicate) {
            this.nP = (Predicate) Preconditions.checkNotNull(predicate);
        }

        public boolean matches(char c) {
            return this.nP.apply(Character.valueOf(c));
        }

        public boolean apply(Character ch) {
            return this.nP.apply(Preconditions.checkNotNull(ch));
        }

        public String toString() {
            return "CharMatcher.forPredicate(" + this.nP + ")";
        }
    }
}
