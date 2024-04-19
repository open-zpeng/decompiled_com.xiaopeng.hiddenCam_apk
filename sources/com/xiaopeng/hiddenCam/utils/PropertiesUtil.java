package com.xiaopeng.hiddenCam.utils;

import android.content.Context;
import android.content.res.AssetManager;
import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/* loaded from: classes.dex */
public class PropertiesUtil {
    public static void loadProperties(Context context, OssService ossService) {
        FileInputStream fileInputStream;
        InputStream open;
        AssetManager assets = context.getAssets();
        try {
            Properties properties = new Properties();
            File file = new File(FileSaver.Constant.pre_env);
            if (!file.exists()) {
                open = assets.open("env-pro.properties");
                properties.load(open);
                fileInputStream = null;
            } else {
                Properties properties2 = new Properties();
                fileInputStream = new FileInputStream(file);
                properties2.load(fileInputStream);
                if (properties2.getProperty("main_host") != null && properties2.getProperty("main_host").contains("xmart.xiaopeng.com")) {
                    open = assets.open("env-pro.properties");
                    properties.load(open);
                } else {
                    open = assets.open("env-dev.properties");
                    properties.load(open);
                }
            }
            ossService.f(properties.getProperty("ENDPOINT"));
            ossService.e(properties.getProperty("BUCKET_NAME"));
            ossService.c(properties.getProperty("AccessKeyId"));
            ossService.d(properties.getProperty("AccessKeySecret"));
            ossService.h(properties.getProperty("OSS_ROOT"));
            ossService.g(properties.getProperty("ENV"));
            properties.getProperty("USER_NAME");
            properties.getProperty("USER_PASSWORD");
            y3.a = properties.getProperty("VERSION");
            properties.getProperty("BASE_URL");
            LogUtils.d("start app: " + y3.a + " davidD55 release");
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            open.close();
        } catch (IOException e) {
            ossService.f("https://oss-cn-shanghai.aliyuncs.com");
            ossService.e("xmotors-data-upload-hdmap");
            ossService.c("LTAI4FvUEBndmKaZhfS8iEh3");
            ossService.d("f4V1wd2evI4y50tdKDkc4V7P5EOmmG");
            LogUtils.e(e.getMessage());
        }
    }
}
