package com.unity3d.services.core.api;

import android.media.MediaMetadataRetriever;
import android.util.Base64;
import android.util.SparseArray;
import com.ironsource.w5;
import com.unity3d.services.core.cache.CacheDirectory;
import com.unity3d.services.core.cache.CacheDirectoryType;
import com.unity3d.services.core.cache.CacheError;
import com.unity3d.services.core.cache.CacheThread;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.WebRequestError;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Cache {
    @WebViewExposed
    public static void download(String str, String str2, JSONArray jSONArray, Boolean bool, WebViewCallback webViewCallback) {
        if (CacheThread.isActive()) {
            webViewCallback.error(CacheError.FILE_ALREADY_CACHING, new Object[0]);
        } else if (!Device.isActiveNetworkConnected()) {
            webViewCallback.error(CacheError.NO_INTERNET, new Object[0]);
        } else {
            try {
                CacheThread.download(str, fileIdToFilename(str2), Request.getHeadersMap(jSONArray), bool.booleanValue(), SharedInstances.INSTANCE.getWebViewEventSender());
                webViewCallback.invoke(new Object[0]);
            } catch (Exception e) {
                DeviceLog.exception("Error mapping headers for the request", e);
                webViewCallback.error(WebRequestError.MAPPING_HEADERS_FAILED, str, str2);
            }
        }
    }

    @WebViewExposed
    public static void stop(WebViewCallback webViewCallback) {
        if (!CacheThread.isActive()) {
            webViewCallback.error(CacheError.NOT_CACHING, new Object[0]);
            return;
        }
        CacheThread.cancel();
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void isCaching(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Boolean.valueOf(CacheThread.isActive()));
    }

    @WebViewExposed
    public static void getFileContent(String str, String str2, WebViewCallback webViewCallback) {
        String str3;
        String fileIdToFilename = fileIdToFilename(str);
        File file = new File(fileIdToFilename);
        if (!file.exists()) {
            webViewCallback.error(CacheError.FILE_NOT_FOUND, str, fileIdToFilename);
            return;
        }
        try {
            byte[] readFileBytes = Utilities.readFileBytes(file);
            if (str2 == null) {
                webViewCallback.error(CacheError.UNSUPPORTED_ENCODING, str, fileIdToFilename, str2);
                return;
            }
            if (str2.equals("UTF-8")) {
                str3 = Charset.forName("UTF-8").decode(ByteBuffer.wrap(readFileBytes)).toString();
            } else if (str2.equals("Base64")) {
                str3 = Base64.encodeToString(readFileBytes, 2);
            } else {
                webViewCallback.error(CacheError.UNSUPPORTED_ENCODING, str, fileIdToFilename, str2);
                return;
            }
            webViewCallback.invoke(str3);
        } catch (IOException e) {
            CacheError cacheError = CacheError.FILE_IO_ERROR;
            webViewCallback.error(cacheError, str, fileIdToFilename, e.getMessage() + ", " + e.getClass().getName());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0083, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0084, code lost:
        com.unity3d.services.core.log.DeviceLog.exception("Error closing FileOutputStream", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:30:0x005d, B:35:0x0070] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x005d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0070 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c A[SYNTHETIC, Splitter:B:33:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007f A[SYNTHETIC, Splitter:B:38:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008a A[SYNTHETIC, Splitter:B:43:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0070=Splitter:B:35:0x0070, B:30:0x005d=Splitter:B:30:0x005d} */
    @com.unity3d.services.core.webview.bridge.WebViewExposed
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setFileContent(java.lang.String r9, java.lang.String r10, java.lang.String r11, com.unity3d.services.core.webview.bridge.WebViewCallback r12) {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "Error closing FileOutputStream"
            java.lang.String r2 = fileIdToFilename(r9)
            r3 = 1
            r4 = 3
            r5 = 2
            r6 = 0
            byte[] r7 = r11.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0093 }
            if (r10 == 0) goto L_0x003a
            int r8 = r10.length()
            if (r8 <= 0) goto L_0x003a
            java.lang.String r8 = "Base64"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x0025
            byte[] r7 = android.util.Base64.decode(r11, r5)
            goto L_0x003a
        L_0x0025:
            boolean r11 = r10.equals(r0)
            if (r11 == 0) goto L_0x002c
            goto L_0x003a
        L_0x002c:
            com.unity3d.services.core.cache.CacheError r11 = com.unity3d.services.core.cache.CacheError.UNSUPPORTED_ENCODING
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r6] = r9
            r0[r3] = r2
            r0[r5] = r10
            r12.error(r11, r0)
            return
        L_0x003a:
            r11 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x005d }
            r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x005d }
            r0.write(r7)     // Catch:{ FileNotFoundException -> 0x0059, IOException -> 0x0057, all -> 0x0054 }
            r0.flush()     // Catch:{ FileNotFoundException -> 0x0059, IOException -> 0x0057, all -> 0x0054 }
            r0.close()     // Catch:{ Exception -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r9 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r1, r9)
        L_0x004e:
            java.lang.Object[] r9 = new java.lang.Object[r6]
            r12.invoke(r9)
            goto L_0x0087
        L_0x0054:
            r9 = move-exception
            r11 = r0
            goto L_0x0088
        L_0x0057:
            r11 = r0
            goto L_0x005d
        L_0x0059:
            r11 = r0
            goto L_0x0070
        L_0x005b:
            r9 = move-exception
            goto L_0x0088
        L_0x005d:
            com.unity3d.services.core.cache.CacheError r0 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR     // Catch:{ all -> 0x005b }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x005b }
            r4[r6] = r9     // Catch:{ all -> 0x005b }
            r4[r3] = r2     // Catch:{ all -> 0x005b }
            r4[r5] = r10     // Catch:{ all -> 0x005b }
            r12.error(r0, r4)     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x0087
            r11.close()     // Catch:{ Exception -> 0x0083 }
            goto L_0x0087
        L_0x0070:
            com.unity3d.services.core.cache.CacheError r0 = com.unity3d.services.core.cache.CacheError.FILE_NOT_FOUND     // Catch:{ all -> 0x005b }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x005b }
            r4[r6] = r9     // Catch:{ all -> 0x005b }
            r4[r3] = r2     // Catch:{ all -> 0x005b }
            r4[r5] = r10     // Catch:{ all -> 0x005b }
            r12.error(r0, r4)     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x0087
            r11.close()     // Catch:{ Exception -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r9 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r1, r9)
        L_0x0087:
            return
        L_0x0088:
            if (r11 == 0) goto L_0x0092
            r11.close()     // Catch:{ Exception -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r10 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r1, r10)
        L_0x0092:
            throw r9
        L_0x0093:
            com.unity3d.services.core.cache.CacheError r11 = com.unity3d.services.core.cache.CacheError.UNSUPPORTED_ENCODING
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r6] = r9
            r0[r3] = r2
            r0[r5] = r10
            r12.error(r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.api.Cache.setFileContent(java.lang.String, java.lang.String, java.lang.String, com.unity3d.services.core.webview.bridge.WebViewCallback):void");
    }

    @WebViewExposed
    public static void getFiles(WebViewCallback webViewCallback) {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        if (cacheDirectory != null) {
            DeviceLog.debug("Unity Ads cache: checking app directory for Unity Ads cached files");
            File[] listFiles = cacheDirectory.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith(SdkProperties.getCacheFilePrefix());
                }
            });
            if (listFiles == null || listFiles.length == 0) {
                webViewCallback.invoke(new JSONArray());
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (File file : listFiles) {
                    String substring = file.getName().substring(SdkProperties.getCacheFilePrefix().length());
                    DeviceLog.debug("Unity Ads cache: found " + substring + ", " + file.length() + " bytes");
                    jSONArray.put(getFileJson(substring));
                }
                webViewCallback.invoke(jSONArray);
            } catch (JSONException e) {
                DeviceLog.exception("Error creating JSON", e);
                webViewCallback.error(CacheError.JSON_ERROR, new Object[0]);
            }
        }
    }

    @WebViewExposed
    public static void getFileInfo(String str, WebViewCallback webViewCallback) {
        try {
            webViewCallback.invoke(getFileJson(str));
        } catch (JSONException e) {
            DeviceLog.exception("Error creating JSON", e);
            webViewCallback.error(CacheError.JSON_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getFilePath(String str, WebViewCallback webViewCallback) {
        if (new File(fileIdToFilename(str)).exists()) {
            webViewCallback.invoke(fileIdToFilename(str));
            return;
        }
        webViewCallback.error(CacheError.FILE_NOT_FOUND, new Object[0]);
    }

    @WebViewExposed
    public static void deleteFile(String str, WebViewCallback webViewCallback) {
        if (new File(fileIdToFilename(str)).delete()) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(CacheError.FILE_IO_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getHash(String str, WebViewCallback webViewCallback) {
        webViewCallback.invoke(Utilities.Sha256(str));
    }

    @WebViewExposed
    public static void setTimeouts(Integer num, Integer num2, WebViewCallback webViewCallback) {
        CacheThread.setConnectTimeout(num.intValue());
        CacheThread.setReadTimeout(num2.intValue());
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getTimeouts(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Integer.valueOf(CacheThread.getConnectTimeout()), Integer.valueOf(CacheThread.getReadTimeout()));
    }

    @WebViewExposed
    public static void setProgressInterval(Integer num, WebViewCallback webViewCallback) {
        CacheThread.setProgressInterval(num.intValue());
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getProgressInterval(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Integer.valueOf(CacheThread.getProgressInterval()));
    }

    @WebViewExposed
    public static void getFreeSpace(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Long.valueOf(Device.getFreeSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void getTotalSpace(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Long.valueOf(Device.getTotalSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void getMetaData(String str, JSONArray jSONArray, WebViewCallback webViewCallback) {
        try {
            SparseArray<String> metaData = getMetaData(fileIdToFilename(str), jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < metaData.size(); i++) {
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.put(metaData.keyAt(i));
                jSONArray3.put(metaData.valueAt(i));
                jSONArray2.put(jSONArray3);
            }
            webViewCallback.invoke(jSONArray2);
        } catch (JSONException e) {
            webViewCallback.error(CacheError.JSON_ERROR, e.getMessage());
        } catch (RuntimeException e2) {
            webViewCallback.error(CacheError.INVALID_ARGUMENT, e2.getMessage());
        } catch (IOException e3) {
            webViewCallback.error(CacheError.FILE_IO_ERROR, e3.getMessage());
        }
    }

    @WebViewExposed
    public static void getCacheDirectoryType(WebViewCallback webViewCallback) {
        CacheDirectory cacheDirectoryObject = SdkProperties.getCacheDirectoryObject();
        if (cacheDirectoryObject == null || cacheDirectoryObject.getCacheDirectory(ClientProperties.getApplicationContext()) == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
        } else if (!cacheDirectoryObject.getCacheDirectory(ClientProperties.getApplicationContext()).exists()) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_DOESNT_EXIST, new Object[0]);
        } else {
            CacheDirectoryType type = cacheDirectoryObject.getType();
            if (type == null) {
                webViewCallback.error(CacheError.CACHE_DIRECTORY_TYPE_NULL, new Object[0]);
                return;
            }
            webViewCallback.invoke(type.name());
        }
    }

    @WebViewExposed
    public static void getCacheDirectoryExists(WebViewCallback webViewCallback) {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        if (cacheDirectory == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
            return;
        }
        webViewCallback.invoke(Boolean.valueOf(cacheDirectory.exists()));
    }

    @WebViewExposed
    public static void recreateCacheDirectory(WebViewCallback webViewCallback) {
        if (SdkProperties.getCacheDirectory().exists()) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_EXISTS, new Object[0]);
            return;
        }
        SdkProperties.setCacheDirectory((CacheDirectory) null);
        if (SdkProperties.getCacheDirectory() == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
        } else {
            webViewCallback.invoke(new Object[0]);
        }
    }

    private static SparseArray<String> getMetaData(String str, JSONArray jSONArray) throws JSONException, IOException, RuntimeException {
        File file = new File(str);
        SparseArray<String> sparseArray = new SparseArray<>();
        if (file.exists()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
            for (int i = 0; i < jSONArray.length(); i++) {
                int i2 = jSONArray.getInt(i);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(i2);
                if (extractMetadata != null) {
                    sparseArray.put(i2, extractMetadata);
                }
            }
            return sparseArray;
        }
        throw new IOException("File: " + file.getAbsolutePath() + " doesn't exist");
    }

    private static String fileIdToFilename(String str) {
        if (SdkProperties.getCacheDirectory() == null) {
            return "";
        }
        return SdkProperties.getCacheDirectory() + "/" + SdkProperties.getCacheFilePrefix() + str;
    }

    private static JSONObject getFileJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(w5.x, str);
        File file = new File(fileIdToFilename(str));
        if (file.exists()) {
            jSONObject.put("found", true);
            jSONObject.put("size", file.length());
            jSONObject.put("mtime", file.lastModified());
        } else {
            jSONObject.put("found", false);
        }
        return jSONObject;
    }
}
