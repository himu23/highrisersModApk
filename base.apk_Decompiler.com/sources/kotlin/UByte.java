package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

@JvmInline
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bI\u0010GJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u000fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0012J\u001b\u0010J\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0018J\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u000fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0012J\u001b\u0010O\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u001fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020\u0003H\b¢\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\b¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0016\u0010l\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010\u0005J\u0016\u0010n\u001a\u00020\u0010H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0016\u0010p\u001a\u00020\u0013H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010cJ\u0016\u0010r\u001a\u00020\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010gJ\u001b\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UByte.kt */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m156boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m162constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m168equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m212unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m169equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m174hashCodeimpl(byte b) {
        return b;
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m200toByteimpl(byte b) {
        return b;
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m201toDoubleimpl(byte b) {
        return (double) (b & MAX_VALUE);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m202toFloatimpl(byte b) {
        return (float) (b & MAX_VALUE);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m203toIntimpl(byte b) {
        return b & MAX_VALUE;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m204toLongimpl(byte b) {
        return ((long) b) & 255;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m205toShortimpl(byte b) {
        return (short) (((short) b) & 255);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m207toUBytew2LRezQ(byte b) {
        return b;
    }

    public boolean equals(Object obj) {
        return m168equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m174hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m212unboximpl() {
        return this.data;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare((int) m212unboximpl() & MAX_VALUE, (int) ((UByte) obj).m212unboximpl() & MAX_VALUE);
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UByte.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m157compareTo7apg3OU(byte b) {
        return Intrinsics.compare((int) m212unboximpl() & MAX_VALUE, (int) b & MAX_VALUE);
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static int m158compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare((int) b & MAX_VALUE, (int) b2 & MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m161compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare((int) b & MAX_VALUE, (int) s & UShort.MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m160compareToWZ4Q5Ns(byte b, int i) {
        return Integer.compare(UInt.m239constructorimpl(b & MAX_VALUE) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m159compareToVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m(ULong.m318constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m186plus7apg3OU(byte b, byte b2) {
        return UInt.m239constructorimpl(UInt.m239constructorimpl(b & MAX_VALUE) + UInt.m239constructorimpl(b2 & MAX_VALUE));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m189plusxj2QHRw(byte b, short s) {
        return UInt.m239constructorimpl(UInt.m239constructorimpl(b & MAX_VALUE) + UInt.m239constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m188plusWZ4Q5Ns(byte b, int i) {
        return UInt.m239constructorimpl(UInt.m239constructorimpl(b & MAX_VALUE) + i);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m187plusVKZWuLQ(byte b, long j) {
        return ULong.m318constructorimpl(ULong.m318constructorimpl(((long) b) & 255) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m177minus7apg3OU(byte b, byte b2) {
        return UInt.m239constructorimpl(UInt.m239constructorimpl(b & MAX_VALUE) - UInt.m239constructorimpl(b2 & MAX_VALUE));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m180minusxj2QHRw(byte b, short s) {
        return UInt.m239constructorimpl(UInt.m239constructorimpl(b & MAX_VALUE) - UInt.m239constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m179minusWZ4Q5Ns(byte b, int i) {
        return UInt.m239constructorimpl(UInt.m239constructorimpl(b & MAX_VALUE) - i);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m178minusVKZWuLQ(byte b, long j) {
        return ULong.m318constructorimpl(ULong.m318constructorimpl(((long) b) & 255) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m196times7apg3OU(byte b, byte b2) {
        return UInt.m239constructorimpl(UInt.m239constructorimpl(b & MAX_VALUE) * UInt.m239constructorimpl(b2 & MAX_VALUE));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m199timesxj2QHRw(byte b, short s) {
        return UInt.m239constructorimpl(UInt.m239constructorimpl(b & MAX_VALUE) * UInt.m239constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m198timesWZ4Q5Ns(byte b, int i) {
        return UInt.m239constructorimpl(UInt.m239constructorimpl(b & MAX_VALUE) * i);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m197timesVKZWuLQ(byte b, long j) {
        return ULong.m318constructorimpl(ULong.m318constructorimpl(((long) b) & 255) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m164div7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(b2 & MAX_VALUE));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m167divxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m166divWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m239constructorimpl(b & MAX_VALUE), i);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m165divVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m318constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m192rem7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(b2 & MAX_VALUE));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m195remxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m194remWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m239constructorimpl(b & MAX_VALUE), i);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m193remVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m(ULong.m318constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m170floorDiv7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(b2 & MAX_VALUE));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m173floorDivxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m172floorDivWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m239constructorimpl(b & MAX_VALUE), i);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m171floorDivVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m318constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m181mod7apg3OU(byte b, byte b2) {
        return m162constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(b2 & MAX_VALUE)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m184modxj2QHRw(byte b, short s) {
        return UShort.m425constructorimpl((short) UByte$$ExternalSyntheticBackport0.m(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m183modWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m239constructorimpl(b & MAX_VALUE), i);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m182modVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m(ULong.m318constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    private static final byte m175incw2LRezQ(byte b) {
        return m162constructorimpl((byte) (b + 1));
    }

    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    private static final byte m163decw2LRezQ(byte b) {
        return m162constructorimpl((byte) (b - 1));
    }

    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    private static final UIntRange m190rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(b2 & MAX_VALUE), (DefaultConstructorMarker) null);
    }

    /* renamed from: rangeUntil-7apg3OU  reason: not valid java name */
    private static final UIntRange m191rangeUntil7apg3OU(byte b, byte b2) {
        return URangesKt.m1420untilJ1ME1BU(UInt.m239constructorimpl(b & MAX_VALUE), UInt.m239constructorimpl(b2 & MAX_VALUE));
    }

    /* renamed from: and-7apg3OU  reason: not valid java name */
    private static final byte m155and7apg3OU(byte b, byte b2) {
        return m162constructorimpl((byte) (b & b2));
    }

    /* renamed from: or-7apg3OU  reason: not valid java name */
    private static final byte m185or7apg3OU(byte b, byte b2) {
        return m162constructorimpl((byte) (b | b2));
    }

    /* renamed from: xor-7apg3OU  reason: not valid java name */
    private static final byte m211xor7apg3OU(byte b, byte b2) {
        return m162constructorimpl((byte) (b ^ b2));
    }

    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    private static final byte m176invw2LRezQ(byte b) {
        return m162constructorimpl((byte) (~b));
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m210toUShortMh2AYeg(byte b) {
        return UShort.m425constructorimpl((short) (((short) b) & 255));
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m208toUIntpVg5ArA(byte b) {
        return UInt.m239constructorimpl(b & MAX_VALUE);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m209toULongsVKNKU(byte b) {
        return ULong.m318constructorimpl(((long) b) & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m206toStringimpl(byte b) {
        return String.valueOf(b & MAX_VALUE);
    }

    public String toString() {
        return m206toStringimpl(this.data);
    }
}
