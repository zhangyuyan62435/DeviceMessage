package com.test.device.deviceutil.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

/**
 * Created by zyy on 2018/9/6.
 */

public class DeviceMessageUtil {
    /**
     * 获取分辨率
     *
     * @param context
     * @return
     */
    public static String getResolution(Activity context) {
        //若不在activity类中调用则参考如下注释代码
        //DisplayMetrics dm2 = Context.getResources().getDisplayMetrics();
        //System.out.println("heigth2 : " + dm2.heightPixels);
        //System.out.println("width2 : " + dm2.widthPixels);
        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        return "分辨率为" + width + "*" + height;
    }

    /**
     * 获取设备厂商
     *
     * @return
     */
    public static String getBrand() {
        return Build.BRAND;
    }

    /**
     * 获取设备名称
     *
     * @return
     */
    public static String getDeviceName() {
        return Build.MODEL;
    }

    /**
     * 获取设备imei、imsi码
     *
     * @param context
     * @param name imei 或者imsi
     * @return
     */
    public static String getEI_SI(String name, Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") String imei = tm.getDeviceId();
        @SuppressLint("MissingPermission") String imsi = tm.getSubscriberId();
        if (name.equals("imei")) {
            return imei;
        } else if (name.equals("imsi")) {
            return imsi;
        } else {
            return "imei=" + imei + "\n" + "imsi=" + imsi;
        }
    }

    /**
     * 获取卡1手机号
     * @param context
     * @return
     */
    public static String getCard1Number(Context context){
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") String phoneN = tm.getLine1Number();
        return phoneN;
    }

    /**
     * 获取android_id
     * @param context
     * @return
     */
    public static String getAndroidId(Context context) {
        String androidId = ""
                + android.provider.Settings.Secure.getString(
                context.getContentResolver(),
                android.provider.Settings.Secure.ANDROID_ID);
        return androidId;

    }
}
