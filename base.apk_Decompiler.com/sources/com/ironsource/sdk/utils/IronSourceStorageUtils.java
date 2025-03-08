package com.ironsource.sdk.utils;

import android.content.Context;
import android.os.Build;
import com.ironsource.m2;
import com.ironsource.m3;
import com.ironsource.n6;
import com.ironsource.ob;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceStorageUtils {
    private static final String a = "supersonicads";
    private static ob b;
    private static boolean c;

    private static void a(Context context) {
        ob obVar = b;
        if (obVar != null && obVar.b()) {
            deleteCacheDirectories(context);
        }
        ob obVar2 = b;
        if (obVar2 != null && obVar2.c()) {
            deleteFilesDirectories(context);
        }
    }

    private static void a(File file) {
        if (file != null) {
            deleteFolder(b(file).getPath());
        }
    }

    private static boolean a() {
        ob obVar = b;
        return (obVar != null && obVar.a()) || Build.VERSION.SDK_INT > 28;
    }

    private static File b(Context context) {
        ob obVar = b;
        return (obVar == null || !obVar.d()) ? m3.p(context) : m3.o(context);
    }

    private static File b(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(a);
        sb.append(str);
        return new File(sb.toString());
    }

    public static String buildAbsolutePathToDirInCache(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + File.separator + str2;
    }

    public static JSONObject buildFilesMap(String str, String str2) {
        String name;
        File file = new File(str, str2);
        JSONObject jSONObject = new JSONObject();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                try {
                    Object c2 = c(file2);
                    if (c2 instanceof JSONArray) {
                        name = "files";
                    } else if (c2 instanceof JSONObject) {
                        name = file2.getName();
                    }
                    jSONObject.put(name, c(file2));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject buildFilesMapOfDirectory(n6 n6Var, JSONObject jSONObject) throws Exception {
        JSONObject jSONObject2;
        String str;
        if (n6Var == null || !n6Var.isDirectory()) {
            return new JSONObject();
        }
        File[] listFiles = n6Var.listFiles();
        if (listFiles == null) {
            return new JSONObject();
        }
        JSONObject jSONObject3 = new JSONObject();
        for (File path : listFiles) {
            n6 n6Var2 = new n6(path.getPath());
            if (n6Var2.isFile()) {
                str = n6Var2.getName();
                jSONObject2 = n6Var2.a();
                if (jSONObject.has(str)) {
                    jSONObject2 = SDKUtils.mergeJSONObjects(jSONObject2, jSONObject.getJSONObject(str));
                }
            } else if (n6Var2.isDirectory()) {
                str = n6Var2.getName();
                jSONObject2 = buildFilesMapOfDirectory(n6Var2, jSONObject);
            }
            jSONObject3.put(str, jSONObject2);
        }
        return jSONObject3;
    }

    private static File c(Context context) {
        ob obVar = b;
        return (obVar == null || !obVar.d()) ? m3.u(context) : m3.t(context);
    }

    private static Object c(File file) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (file.isFile()) {
                jSONArray.put(file.getName());
                return jSONArray;
            }
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    jSONObject.put(file2.getName(), c(file2));
                } else {
                    jSONArray.put(file2.getName());
                    jSONObject.put("files", jSONArray);
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCacheDirectories(Context context) {
        a(m3.o(context));
        a(m3.t(context));
    }

    public static synchronized boolean deleteFile(n6 n6Var) {
        synchronized (IronSourceStorageUtils.class) {
            if (!n6Var.exists()) {
                return false;
            }
            boolean delete = n6Var.delete();
            return delete;
        }
    }

    public static void deleteFilesDirectories(Context context) {
        a(m3.p(context));
        a(m3.u(context));
    }

    public static synchronized boolean deleteFolder(String str) {
        boolean z;
        synchronized (IronSourceStorageUtils.class) {
            File file = new File(str);
            z = deleteFolderContentRecursive(file) && file.delete();
        }
        return z;
    }

    public static boolean deleteFolderContentRecursive(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= deleteFolderContentRecursive(file2);
                }
                if (!file2.delete()) {
                    z = false;
                }
            }
        }
        return z;
    }

    public static void ensurePathSafety(File file, String str) throws Exception {
        ob obVar = b;
        if (obVar == null || !obVar.e()) {
            String canonicalPath = new File(str).getCanonicalPath();
            String canonicalPath2 = file.getCanonicalPath();
            if (!canonicalPath2.startsWith(canonicalPath)) {
                throw new Exception(m2.c.w + canonicalPath2);
            }
        }
    }

    public static String getCachedFilesMap(String str, String str2) {
        JSONObject buildFilesMap = buildFilesMap(str, str2);
        try {
            buildFilesMap.put("path", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return buildFilesMap.toString();
    }

    public static String getDiskCacheDirPath(Context context) {
        File b2;
        if (!a() || !SDKUtils.isExternalStorageAvailable() || (b2 = b(context)) == null || !b2.canWrite()) {
            return c(context).getPath();
        }
        c = true;
        return b2.getPath();
    }

    public static ArrayList<n6> getFilesInFolderRecursive(n6 n6Var) {
        if (n6Var == null || !n6Var.isDirectory()) {
            return new ArrayList<>();
        }
        ArrayList<n6> arrayList = new ArrayList<>();
        File[] listFiles = n6Var.listFiles();
        if (listFiles != null) {
            for (File path : listFiles) {
                n6 n6Var2 = new n6(path.getPath());
                if (n6Var2.isDirectory()) {
                    arrayList.addAll(getFilesInFolderRecursive(n6Var2));
                }
                if (n6Var2.isFile()) {
                    arrayList.add(n6Var2);
                }
            }
        }
        return arrayList;
    }

    public static String getNetworkStorageDir(Context context) {
        File b2 = b(new File(getDiskCacheDirPath(context)));
        if (!b2.exists()) {
            b2.mkdir();
        }
        return b2.getPath();
    }

    public static long getTotalSizeOfDir(n6 n6Var) {
        long totalSizeOfDir;
        long j = 0;
        if (n6Var != null && n6Var.isDirectory()) {
            File[] listFiles = n6Var.listFiles();
            if (listFiles == null) {
                return 0;
            }
            for (File path : listFiles) {
                n6 n6Var2 = new n6(path.getPath());
                if (n6Var2.isFile()) {
                    totalSizeOfDir = n6Var2.length();
                } else if (n6Var2.isDirectory()) {
                    totalSizeOfDir = getTotalSizeOfDir(n6Var2);
                }
                j += totalSizeOfDir;
            }
        }
        return j;
    }

    public static void initializeCacheDirectory(Context context, ob obVar) {
        b = obVar;
        a(context);
    }

    public static boolean isPathExist(String str, String str2) {
        return new File(str, str2).exists();
    }

    public static boolean isUxt() {
        return c;
    }

    public static String makeDir(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file.getPath();
        }
        return null;
    }

    public static String readFile(n6 n6Var) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(n6Var));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append(10);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public static boolean renameFile(String str, String str2) throws Exception {
        return new File(str).renameTo(new File(str2));
    }

    public static int saveFile(byte[] bArr, String str) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[102400];
            int i = 0;
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    return i;
                }
                fileOutputStream.write(bArr2, 0, read);
                i += read;
            }
        } finally {
            fileOutputStream.close();
            byteArrayInputStream.close();
        }
    }
}
