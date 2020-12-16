package com.example.warcardgame.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.warcardgame.objects.WinnerPlayer;
import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;

public class MySP {
    public static final String KEY_WINNER = "KEY_WINNER";
    /**
     * Define the max size of the high score table
     */
    private final int MAX_HIGH_SCORE_LENGTH = 10;

    private ArrayList<WinnerPlayer> list;
    private SharedPreferences prefs;

    public MySP(Context context){
        prefs = context.getSharedPreferences("MY_SP",Context.MODE_PRIVATE);
    }
    /**
     * This function add winner player to top 10 list and write the data to storage (Shared Preference)
     * @param winnerPlayer winner player object
     * @param comparator object to compare top 10 list
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void add(WinnerPlayer winnerPlayer, Comparator<WinnerPlayer> comparator) {
        list = readDataFromStorage();
        if (!list.contains(winnerPlayer)) {
            if (list.size() < MAX_HIGH_SCORE_LENGTH) {
                list.add(winnerPlayer);
                list.sort(comparator);
                writeDataToStorage(list);
            } else if (winnerPlayer.getScore() > list.get(list.size() - 1).getScore()) {
                list.set(list.size() - 1, winnerPlayer);
                list.sort(comparator);
                writeDataToStorage(list);
            }
        } else {
            int idx = list.indexOf(winnerPlayer);
            WinnerPlayer currentUser = list.get(idx);
            if (currentUser.getScore() < winnerPlayer.getScore()) {
                list.set(idx, winnerPlayer);
                list.sort(comparator);
                writeDataToStorage(list);
            }
        }
    }
    /**
     * This function write data to storage
     * @param list ArrayList of WinnerPlayer objects
     */
    private void writeDataToStorage(ArrayList<WinnerPlayer> list) {
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString("task_list", json);
        editor.apply();
    }
    /**
     * This function read data from storage
     * @return ArrayList of WinnerPlayer objects
     */
    public ArrayList<WinnerPlayer> readDataFromStorage() {
        Gson gson = new Gson();
        String json = prefs.getString("task_list", null);
        Type type = new TypeToken<ArrayList<WinnerPlayer>>() {
        }.getType();
        if ((list = gson.fromJson(json, type)) == null)
            list = new ArrayList<>();
        return list;
    }
    /**
     * This function clear all memory from shared preference
     */
    public void clearSharedPreferences() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
    /**
     * This function add String to shared preference
     * @param key The name of the preference to modify.
     * @param value The new value for the preference
     */
    public void putString(String key,String value) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }
    /**
     * This function read String from shared preference
     * @param key The name of the preference to retrieve.
     * @param def Value to return if this preference does not exist.
     * @return preference value if it exists, or defValue.
     */
    public String getString(String key,String def){
        return prefs.getString(key, def);
    }
    /**
     * This function add Integer to shared preference
     * @param key The name of the preference to modify.
     * @param value The new value for the preference
     */
    public void putInt(String key, Integer value){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key,value);
        editor.apply();
    }
    /**
     * This function read Integer from shared preference
     * @param key The name of the preference to retrieve.
     * @param def Value to return if this preference does not exist.
     * @return preference value if it exists, or defValue.
     */
    public Integer getInt(String key,Integer def){
        return prefs.getInt(key, def);
    }
    /**
     * This function add Float to shared preference
     * @param key The name of the preference to modify.
     * @param value The new value for the preference
     */
    public void putFloat(String key, Float value){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(key,value);
        editor.apply();
    }
    /**
     * This function read Float from shared preference
     * @param key The name of the preference to retrieve.
     * @param def Value to return if this preference does not exist.
     * @return preference value if it exists, or defValue.
     */
    public Float getFloat(String key,Float def){
        return prefs.getFloat(key, def);
    }
    /**
     * This function remove the name from the shared preference
     * @param key The name of the preference to remove.
     */
    public void removeKey(String key){
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key).apply();
    }
}

