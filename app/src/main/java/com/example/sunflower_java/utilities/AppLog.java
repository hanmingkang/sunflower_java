package com.example.sunflower_java.utilities;

import android.util.Log;

import com.example.sunflower_java.BuildConfig;

/**
 * @description: 自定义封装Log
 * @author: kangsx
 * @date: 2020/9/23
 * @version: 1.1.0
 */
public class AppLog {
    public static void E(String message) {
        String[] infos = getAutoJumpLogInfos();
        //release模式下没有快捷点击跳转
        if (BuildConfig.DEBUG) {
            Log.e(infos[0], message + infos[1] + infos[2]);
        }else{
            Log.e(infos[0], message);
        }
    }

    public static void D(String message) {
        String[] infos = getAutoJumpLogInfos();
        //release模式下没有快捷点击跳转
        if (BuildConfig.DEBUG) {
            Log.d(infos[0], message + infos[1] + infos[2]);
        }else{
            Log.d(infos[0], message);
        }
    }

    public static void V(String message) {
        String[] infos = getAutoJumpLogInfos();
        //release模式下没有快捷点击跳转
        if (BuildConfig.DEBUG) {
            Log.v(infos[0], message + infos[1] + infos[2]);
        }else{
            Log.v(infos[0], message);
        }
    }

    public static void I(String message) {
        String[] infos = getAutoJumpLogInfos();
        //release模式下没有快捷点击跳转
        if (BuildConfig.DEBUG) {
            Log.i(infos[0], message + infos[1] + infos[2]);
        }else{
            Log.i(infos[0], message);
        }
    }

    public static void W(String message) {
        String[] infos = getAutoJumpLogInfos();
        //release模式下没有快捷点击跳转
        if (BuildConfig.DEBUG) {
            Log.w(infos[0], message + infos[1] + infos[2]);
        }else{
            Log.w(infos[0], message);
        }
    }

    /**
     * 获取打印信息所在方法名，行号等信息
     *
     * @return
     */
    public static String[] getAutoJumpLogInfos() {
        String[] infos = new String[]{"", "", ""};
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements.length < 5) {
            Log.e("MyLogger", "Stack is too shallow!!!");
            return infos;
        } else {
            infos[0] = elements[4].getClassName().substring(
                    elements[4].getClassName().lastIndexOf(".") + 1);
            infos[1] = "  [" + elements[4].getMethodName() + "() ";
            infos[2] = "(" + elements[4].getFileName() + ":"
                    + elements[4].getLineNumber() + ")]";
            return infos;
        }
    }
}

