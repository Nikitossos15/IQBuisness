package com.example.cliker_life;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import static com.example.cliker_life.MainActivity.nalogi;
import static com.example.cliker_life.MainActivity.nalogi;
import static com.example.cliker_life.MainActivity.textmoney;

public class Saved extends AppCompatActivity {
    private static SharedPreferences.Editor editor;
    private static SharedPreferences preferences;
    public Saved(){};
    public static void init(Context context){
        if (preferences == null){
            preferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }
    void save(){
        editor.putInt("money", MainActivity.coutmoney);
        editor.putInt("price1", Improve.price1);
        editor.putInt("moneyplus", MainActivity.money);
        editor.putInt("nalogi", MainActivity.nalog);
        editor.commit();
    }
    void load_save(){
        MainActivity.coutmoney = preferences.getInt("money", 0);
        Improve.price1 = preferences.getInt("price1", 5);
        MainActivity.money = preferences.getInt("moneyplus", 1);
        MainActivity.nalog = preferences.getInt("nalogi", 0);
        textmoney.setText(MainActivity.coutmoney + "");
        nalogi.setText("Налог\n" + MainActivity.nalog);
    }
}
