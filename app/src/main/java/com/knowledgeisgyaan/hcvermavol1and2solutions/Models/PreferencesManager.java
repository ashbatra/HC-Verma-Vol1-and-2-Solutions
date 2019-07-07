package com.knowledgeisgyaan.hcvermavol1and2solutions.Models;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;

import javax.microedition.khronos.egl.EGLDisplay;

public class PreferencesManager {

    Context context;

    public PreferencesManager(Context context) {
        this.context = context;
    }

    public void saveLoginDetails(String name,String email,String contact){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("contact",contact);
        editor.commit();

    }

    public void saveLoginDetails(String phonenumber) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("contact",phonenumber);
        editor.apply();
        editor.commit();
    }

    public void clear() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public String getName(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        return sharedPreferences.getString("name", "");
    }

    public String getMail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences",Context.MODE_PRIVATE);
        return sharedPreferences.getString("email","");
    }

    public String getNum() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        return sharedPreferences.getString("contact","");
    }

    public boolean isUserLoggerOut(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        boolean isNumEmpty = sharedPreferences.getString("contact","").isEmpty();
        return isNumEmpty;
    }
}
