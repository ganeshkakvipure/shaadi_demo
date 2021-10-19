package com.app.shaadi.common;


import android.content.Context;
import android.content.SharedPreferences;



public class SharedPrefUtil {
    public static String PREF_NAME = "POD";
    private static String KEY_REGISTRATION = "reg";
    private static String KEY_USER_PHONE_NUMBER_KEY = "user_phone_number";
    private static String KEY_OTP = "otp";
    private static String KEY_IS_OTP = "isOtp";



    public static boolean isRegistration(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean(KEY_REGISTRATION, false);
    }

    public static void setRegistration(Context context, boolean isReg) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        preferences.edit().putBoolean(KEY_REGISTRATION, isReg).apply();
    }

    public static String getPhoneNumber(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getString(KEY_USER_PHONE_NUMBER_KEY, "");
    }

    public static void setPhoneNumber(Context context,String phoneNumber) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        preferences.edit().putString(KEY_USER_PHONE_NUMBER_KEY, phoneNumber).apply();
    }

    public static String getOTP(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getString(KEY_OTP, "");
    }

    public static void setOTP(Context context,String otp) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        preferences.edit().putString(KEY_OTP, otp).apply();
    }
    public static boolean isOTPDone(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean(KEY_IS_OTP, false);
    }

    public static void setOTPDone(Context context, boolean flag) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        preferences.edit().putBoolean(KEY_IS_OTP, flag).apply();
    }

}
