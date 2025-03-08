package com.savegame;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class SavesRestoring extends Activity {
    private static int PdsjdolaSd = 22;
    private static int daDakdsIID = 0;

    private static String CvCKEINl() {
        daDakdsIID++;
        return Character.toString('o');
    }

    private static String CwuQkJF() {
        daDakdsIID++;
        return Character.toString('M');
    }

    private static String EOFesKFnmlD() {
        daDakdsIID++;
        return Character.toString('y');
    }

    private static String EvQOGTy() {
        daDakdsIID++;
        return Character.toString(' ');
    }

    private static String HCvTPtxetRRYB() {
        daDakdsIID++;
        return Character.toString('i');
    }

    private static String HVNKMDAxRPi() {
        daDakdsIID++;
        return Character.toString('o');
    }

    private static String HjLcDALnFGP() {
        daDakdsIID++;
        return Character.toString('d');
    }

    private static String KRPttgXwPONse() {
        daDakdsIID++;
        return Character.toString('e');
    }

    private static String SKrxIUyb() {
        daDakdsIID++;
        return Character.toString('a');
    }

    private static String TYCIWOhdsOx() {
        daDakdsIID++;
        return Character.toString('d');
    }

    private static String UEHbUymBKOgt() {
        daDakdsIID++;
        return Character.toString('b');
    }

    private static String VKYIBGwfFisoE() {
        daDakdsIID++;
        return Character.toString('a');
    }

    private static String YDOeOfKXfIlGB() {
        daDakdsIID++;
        return Character.toString('i');
    }

    private static String bBvEiUwQn() {
        daDakdsIID++;
        return Character.toString(' ');
    }

    private static String cCcGgxeFFtS() {
        daDakdsIID++;
        return Character.toString('e');
    }

    private static String diyowvg() {
        daDakdsIID++;
        return Character.toString('f');
    }

    private static String hPirwWS() {
        daDakdsIID++;
        return Character.toString('S');
    }

    private static String ksGmyaYL() {
        daDakdsIID++;
        return Character.toString('v');
    }

    private static String oMCPPAoQJn() {
        daDakdsIID++;
        return Character.toString('T');
    }

    private static String oqOvarrYp() {
        daDakdsIID++;
        return Character.toString('m');
    }

    private static String sfJARlagmvAG() {
        daDakdsIID++;
        return Character.toString('e');
    }

    private static String wDOwTXORxYcb() {
        daDakdsIID++;
        return Character.toString('G');
    }

    private static void wPdauIdcaW(Context c) {
        Toast makeText = Toast.makeText(c, String.valueOf(CwuQkJF()) + CvCKEINl() + TYCIWOhdsOx() + YDOeOfKXfIlGB() + diyowvg() + HCvTPtxetRRYB() + cCcGgxeFFtS() + HjLcDALnFGP() + bBvEiUwQn() + UEHbUymBKOgt() + EOFesKFnmlD() + EvQOGTy() + hPirwWS() + SKrxIUyb() + ksGmyaYL() + sfJARlagmvAG() + oMCPPAoQJn() + HVNKMDAxRPi() + wDOwTXORxYcb() + VKYIBGwfFisoE() + oqOvarrYp() + KRPttgXwPONse(), 1);
    }

    private static void wPdauIdcaW(Context c, int wodDSsau) {
        Toast makeText = Toast.makeText(c, String.valueOf(CwuQkJF()) + CvCKEINl() + TYCIWOhdsOx() + YDOeOfKXfIlGB() + diyowvg() + HCvTPtxetRRYB() + cCcGgxeFFtS() + HjLcDALnFGP() + bBvEiUwQn() + UEHbUymBKOgt() + EOFesKFnmlD() + EvQOGTy() + hPirwWS() + SKrxIUyb() + ksGmyaYL() + sfJARlagmvAG() + oMCPPAoQJn() + HVNKMDAxRPi() + wDOwTXORxYcb() + VKYIBGwfFisoE() + oqOvarrYp() + KRPttgXwPONse(), 1);
    }

    public SavesRestoring() {
    }

    public static void DoSmth(Context context) {
        StringBuilder sb;
        StringBuilder sb2;
        Context c = context;
        try {
            wPdauIdcaW(c);
            SmartDataRestoreForYou(c, c.getAssets(), c.getPackageName());
        } catch (Exception e) {
            Exception ex = e;
            new StringBuilder();
            String sb3 = sb.append(c.getPackageName()).append(":savemessages").toString();
            new StringBuilder();
            int e2 = Log.e(sb3, sb2.append("Message: ").append(ex.getMessage()).toString());
            ex.printStackTrace();
        }
    }

    private static void unZipIt(InputStream file, String str) throws Exception {
        ZipInputStream zipInputStream;
        File file2;
        Throwable th;
        File file3;
        StringBuilder sb;
        File newFile;
        StringBuilder sb2;
        FileOutputStream fileOutputStream;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        String outputFolder = str;
        new ZipInputStream(file);
        ZipInputStream zipFile = zipInputStream;
        if (daDakdsIID != PdsjdolaSd) {
            Throwable th5 = th4;
            new Exception("System error...");
            throw th5;
        }
        byte[] buffer = new byte[1024];
        new File(outputFolder);
        boolean mkdirs = file2.mkdirs();
        ZipEntry ze = zipFile.getNextEntry();
        if (daDakdsIID != PdsjdolaSd) {
            Throwable th6 = th3;
            new Exception("System error! please don't cheat...");
            throw th6;
        }
        while (ze != null) {
            if (ze.isDirectory()) {
                ze = zipFile.getNextEntry();
            } else {
                int index = ze.getName().lastIndexOf(47);
                if (index < 0) {
                    index = 0;
                }
                new StringBuilder();
                new File(sb.append(outputFolder).append("/").append(ze.getName().substring(0, index)).toString());
                boolean mkdirs2 = file3.mkdirs();
                new StringBuilder();
                new File(sb2.append(outputFolder).append("/").append(ze.getName()).toString());
                new FileOutputStream(newFile, false);
                FileOutputStream fos = fileOutputStream;
                if (daDakdsIID != PdsjdolaSd) {
                    fos.close();
                    Throwable th7 = th2;
                    new Exception("You are clever...");
                    throw th7;
                }
                while (true) {
                    int len = zipFile.read(buffer);
                    if (len <= 0) {
                        break;
                    }
                    fos.write(buffer, 0, len);
                }
                fos.close();
                ze = zipFile.getNextEntry();
            }
        }
        if (daDakdsIID != PdsjdolaSd) {
            Throwable th8 = th;
            new Exception("And again...");
            throw th8;
        }
        zipFile.closeEntry();
        zipFile.close();
    }

    public static boolean ExistsInArray(String[] strArr, String str) {
        String[] arr = strArr;
        String value = str;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains(value)) {
                return true;
            }
        }
        return false;
    }

    private static void SmartDataRestoreForYou(Context context, AssetManager assetManager, String str) throws Exception {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        File file;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        Context c = context;
        AssetManager localAssetManager = assetManager;
        String packageName = str;
        if (!c.getSharedPreferences("savegame", 0).getBoolean("notfirst", false)) {
            boolean commit = c.getSharedPreferences("savegame", 0).edit().putBoolean("notfirst", true).commit();
            new StringBuilder();
            String packageName2 = sb.append(packageName).append(":savemessages").toString();
            int i = Log.i(packageName2, "SmDR: Starting...");
            boolean commit2 = c.getSharedPreferences("savegame", 0).edit().putBoolean("notfirst", true).commit();
            String[] listFiles = localAssetManager.list("");
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                new StringBuilder();
                int i3 = Log.i(packageName2, sb8.append("ListFiles[").append(i2).append("] = ").append(listFiles[i2]).toString());
            }
            if (ExistsInArray(listFiles, "data.save")) {
                Toast makeText = Toast.makeText(c, "Restoring save...", 0);
                try {
                    int i4 = Log.i(packageName2, "data.save : Restoring...");
                    InputStream open = localAssetManager.open("data.save");
                    new StringBuilder();
                    unZipIt(open, sb7.append("/data/data/").append(c.getPackageName()).toString());
                    int i5 = Log.i(packageName2, "data.save: Successfully restored");
                } catch (Exception e) {
                    new StringBuilder();
                    int e2 = Log.e(packageName2, sb6.append("data.save: Message: ").append(e.getMessage()).toString());
                    Toast makeText2 = Toast.makeText(c, "Can't restore save", 1);
                }
            }
            if (ExistsInArray(listFiles, "extobb.save")) {
                Toast makeText3 = Toast.makeText(c, "Restoring cache...", 0);
                try {
                    int i6 = Log.i(packageName2, "extobb.save: Restoring...");
                    new StringBuilder();
                    unZipIt(localAssetManager.open("extobb.save"), sb5.append(c.getObbDir().getAbsolutePath()).append("/").toString());
                    int i7 = Log.i(packageName2, "extobb.save: Successfully restored");
                } catch (Exception e3) {
                    new StringBuilder();
                    int e4 = Log.e(packageName2, sb4.append("extobb.save: Message: ").append(e3.getMessage()).toString());
                    Toast makeText4 = Toast.makeText(c, "Can't restore external cache", 1);
                }
            }
            if (ExistsInArray(listFiles, "extdata.save")) {
                Toast makeText5 = Toast.makeText(c, "Restoring external data...", 0);
                try {
                    int i8 = Log.i(packageName2, "extdata.save: Restoring...");
                    new StringBuilder();
                    String path = sb3.append(Environment.getExternalStorageDirectory()).append("/Android/data/").append(c.getPackageName()).append("/").toString();
                    new File(path);
                    boolean mkdirs = file.mkdirs();
                    unZipIt(localAssetManager.open("extdata.save"), path);
                    int i9 = Log.i(packageName2, "extdata.save: Successfully restored");
                } catch (Exception e5) {
                    new StringBuilder();
                    int e6 = Log.e(packageName2, sb2.append("extdata.save: Message: ").append(e5.getMessage()).toString());
                    Toast makeText6 = Toast.makeText(c, "Can't restore external data", 1);
                }
            }
            int i10 = Log.i(packageName2, "Restoring completed");
            Toast makeText7 = Toast.makeText(c, "Restoring completed", 1);
        }
    }
}
