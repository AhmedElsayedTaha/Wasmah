package com.example.wasmah.Utilies;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AppUtilies {
    public static void SaveFavorites(List<String> countryNamesList, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences("mysh", Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String gsonString = gson.toJson(countryNamesList);
        editor.putString("names",gsonString);
        editor.apply();
    }

    public static List<String> getFavourites(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("mysh",Context.MODE_PRIVATE);
        String object = sharedPreferences.getString("names","");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(object,type);
    }
}
