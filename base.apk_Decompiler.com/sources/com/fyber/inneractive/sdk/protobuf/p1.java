package com.fyber.inneractive.sdk.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class p1 {
    public static final Unsafe a;
    public static final Class<?> b = d.a;
    public static final boolean c;
    public static final boolean d;
    public static final d e;
    public static final boolean f;
    public static final boolean g;
    public static final long h = ((long) a((Class<?>) byte[].class));
    public static final long i;
    public static final boolean j;

    static {
        Unsafe unsafe;
        boolean z;
        boolean z2;
        d dVar = null;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new o1());
        } catch (Throwable unused) {
            unsafe = null;
        }
        a = unsafe;
        boolean c2 = c(Long.TYPE);
        c = c2;
        boolean c3 = c(Integer.TYPE);
        d = c3;
        if (unsafe != null) {
            if (!d.a()) {
                dVar = new c(unsafe);
            } else if (c2) {
                dVar = new b(unsafe);
            } else if (c3) {
                dVar = new a(unsafe);
            }
        }
        e = dVar;
        boolean z3 = false;
        if (dVar == null) {
            z = false;
        } else {
            z = dVar.b();
        }
        f = z;
        if (dVar == null) {
            z2 = false;
        } else {
            z2 = dVar.a();
        }
        g = z2;
        Class<boolean[]> cls = boolean[].class;
        a((Class<?>) cls);
        b(cls);
        Class<int[]> cls2 = int[].class;
        a((Class<?>) cls2);
        b(cls2);
        Class<long[]> cls3 = long[].class;
        a((Class<?>) cls3);
        b(cls3);
        Class<float[]> cls4 = float[].class;
        a((Class<?>) cls4);
        b(cls4);
        Class<double[]> cls5 = double[].class;
        a((Class<?>) cls5);
        b(cls5);
        a((Class<?>) Object[].class);
        b(Object[].class);
        Field a2 = a();
        i = (a2 == null || dVar == null) ? -1 : dVar.a.objectFieldOffset(a2);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z3 = true;
        }
        j = z3;
    }

    public static boolean c(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!d.a()) {
            return false;
        }
        try {
            Class<?> cls3 = b;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte d(Object obj, long j2) {
        return (byte) ((e(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static int a(Class<?> cls) {
        if (g) {
            return e.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int b(Class<?> cls) {
        if (g) {
            return e.a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static int e(Object obj, long j2) {
        return e.a.getInt(obj, j2);
    }

    public static long f(Object obj, long j2) {
        return e.a.getLong(obj, j2);
    }

    public static Object g(Object obj, long j2) {
        return e.a.getObject(obj, j2);
    }

    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        public void a(Object obj, long j, byte b) {
            if (p1.j) {
                p1.a(obj, j, b);
            } else {
                p1.b(obj, j, b);
            }
        }

        public byte b(Object obj, long j) {
            if (p1.j) {
                return p1.c(obj, j);
            }
            return p1.d(obj, j);
        }

        public boolean b() {
            return false;
        }

        public double c(Object obj, long j) {
            return Double.longBitsToDouble(this.a.getLong(obj, j));
        }

        public float d(Object obj, long j) {
            return Float.intBitsToFloat(this.a.getInt(obj, j));
        }

        public boolean a(Object obj, long j) {
            if (p1.j) {
                return p1.a(obj, j);
            }
            return p1.b(obj, j);
        }

        public void a(Object obj, long j, boolean z) {
            if (p1.j) {
                p1.a(obj, j, z ? (byte) 1 : 0);
            } else {
                p1.b(obj, j, z ? (byte) 1 : 0);
            }
        }

        public void a(Object obj, long j, float f) {
            this.a.putInt(obj, j, Float.floatToIntBits(f));
        }

        public void a(Object obj, long j, double d) {
            this.a.putLong(obj, j, Double.doubleToLongBits(d));
        }

        public byte a(long j) {
            throw new UnsupportedOperationException();
        }

        public void a(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        public void a(Object obj, long j, byte b) {
            if (p1.j) {
                p1.a(obj, j, b);
            } else {
                p1.b(obj, j, b);
            }
        }

        public byte b(Object obj, long j) {
            if (p1.j) {
                return p1.c(obj, j);
            }
            return p1.d(obj, j);
        }

        public boolean b() {
            return false;
        }

        public double c(Object obj, long j) {
            return Double.longBitsToDouble(this.a.getLong(obj, j));
        }

        public float d(Object obj, long j) {
            return Float.intBitsToFloat(this.a.getInt(obj, j));
        }

        public boolean a(Object obj, long j) {
            if (p1.j) {
                return p1.a(obj, j);
            }
            return p1.b(obj, j);
        }

        public void a(Object obj, long j, boolean z) {
            if (p1.j) {
                p1.a(obj, j, z ? (byte) 1 : 0);
            } else {
                p1.b(obj, j, z ? (byte) 1 : 0);
            }
        }

        public void a(Object obj, long j, float f) {
            this.a.putInt(obj, j, Float.floatToIntBits(f));
        }

        public void a(Object obj, long j, double d) {
            this.a.putLong(obj, j, Double.doubleToLongBits(d));
        }

        public byte a(long j) {
            throw new UnsupportedOperationException();
        }

        public void a(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }
    }

    public static void b(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (e(obj, j3) & (~(255 << i2))));
    }

    public static abstract class d {
        public Unsafe a;

        public d(Unsafe unsafe) {
            this.a = unsafe;
        }

        public abstract byte a(long j);

        public abstract void a(long j, byte[] bArr, long j2, long j3);

        public abstract void a(Object obj, long j, byte b);

        public abstract void a(Object obj, long j, double d);

        public abstract void a(Object obj, long j, float f);

        public abstract void a(Object obj, long j, boolean z);

        public abstract boolean a(Object obj, long j);

        public abstract byte b(Object obj, long j);

        public abstract boolean b();

        public abstract double c(Object obj, long j);

        public abstract float d(Object obj, long j);

        public boolean a() {
            Unsafe unsafe = this.a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
                cls.getMethod("arrayIndexScale", new Class[]{Class.class});
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", new Class[]{Object.class, cls2});
                cls.getMethod("putInt", new Class[]{Object.class, cls2, Integer.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, cls2});
                cls.getMethod("putLong", new Class[]{Object.class, cls2, cls2});
                cls.getMethod("getObject", new Class[]{Object.class, cls2});
                cls.getMethod("putObject", new Class[]{Object.class, cls2, Object.class});
                return true;
            } catch (Throwable th) {
                p1.a(th);
                return false;
            }
        }
    }

    public static void a(Object obj, long j2, int i2) {
        e.a.putInt(obj, j2, i2);
    }

    public static void a(Object obj, long j2, long j3) {
        e.a.putLong(obj, j2, j3);
    }

    public static void a(Object obj, long j2, boolean z) {
        e.a(obj, j2, z);
    }

    public static boolean b(Object obj, long j2) {
        return d(obj, j2) != 0;
    }

    public static void a(Object obj, long j2, float f2) {
        e.a(obj, j2, f2);
    }

    public static void a(Object obj, long j2, double d2) {
        e.a(obj, j2, d2);
    }

    public static void a(Object obj, long j2, Object obj2) {
        e.a.putObject(obj, j2, obj2);
    }

    public static byte a(byte[] bArr, long j2) {
        return e.b(bArr, h + j2);
    }

    public static void a(byte[] bArr, long j2, byte b2) {
        e.a((Object) bArr, h + j2, b2);
    }

    public static byte c(Object obj, long j2) {
        return (byte) ((e(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static long a(ByteBuffer byteBuffer) {
        d dVar = e;
        return dVar.a.getLong(byteBuffer, i);
    }

    public static Field a() {
        Field field;
        Field field2;
        if (d.a()) {
            try {
                field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            field = null;
        }
        if (field == null || field.getType() != Long.TYPE) {
            return null;
        }
        return field;
    }

    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean a() {
            if (!super.a()) {
                return false;
            }
            try {
                Class<?> cls = this.a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", new Class[]{Object.class, cls2});
                cls.getMethod("putByte", new Class[]{Object.class, cls2, Byte.TYPE});
                cls.getMethod("getBoolean", new Class[]{Object.class, cls2});
                cls.getMethod("putBoolean", new Class[]{Object.class, cls2, Boolean.TYPE});
                cls.getMethod("getFloat", new Class[]{Object.class, cls2});
                cls.getMethod("putFloat", new Class[]{Object.class, cls2, Float.TYPE});
                cls.getMethod("getDouble", new Class[]{Object.class, cls2});
                cls.getMethod("putDouble", new Class[]{Object.class, cls2, Double.TYPE});
                return true;
            } catch (Throwable th) {
                p1.a(th);
                return false;
            }
        }

        public boolean b() {
            Unsafe unsafe = this.a;
            if (unsafe != null) {
                try {
                    Class<?> cls = unsafe.getClass();
                    cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                    cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                    if (p1.a() != null) {
                        try {
                            Class<?> cls2 = this.a.getClass();
                            Class cls3 = Long.TYPE;
                            cls2.getMethod("getByte", new Class[]{cls3});
                            cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
                            cls2.getMethod("getInt", new Class[]{cls3});
                            cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
                            cls2.getMethod("getLong", new Class[]{cls3});
                            cls2.getMethod("putLong", new Class[]{cls3, cls3});
                            cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
                            cls2.getMethod("copyMemory", new Class[]{Object.class, cls3, Object.class, cls3, cls3});
                            return true;
                        } catch (Throwable th) {
                            p1.a(th);
                            return false;
                        }
                    }
                } catch (Throwable th2) {
                    p1.a(th2);
                }
            }
            return false;
        }

        public double c(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        public float d(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        public void a(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        public boolean a(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        public void a(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        public void a(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        public void a(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        public byte a(long j) {
            return this.a.getByte(j);
        }

        public byte b(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        public void a(long j, byte[] bArr, long j2, long j3) {
            this.a.copyMemory((Object) null, j, bArr, p1.h + j2, j3);
        }
    }

    public static void a(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int e2 = e(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (e2 & (~(255 << i2))));
    }

    public static boolean a(Object obj, long j2) {
        return c(obj, j2) != 0;
    }

    public static void a(Throwable th) {
        Logger logger = Logger.getLogger(p1.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
    }
}
