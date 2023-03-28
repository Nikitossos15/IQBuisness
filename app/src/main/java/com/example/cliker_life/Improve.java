package com.example.cliker_life;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Improve extends AppCompatActivity {
    Button laptop, city_price, bckl;
    public static int price1 = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        laptop = (Button) findViewById(R.id.laptop);
        city_price = (Button) findViewById(R.id.city_price);
        laptop.setText("Улучшить доход от нажатия, " + price1 + " $");
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= price1) {
                    MainActivity.money += 10;
                    MainActivity.coutmoney -= price1;
                    price1+=30;
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    laptop.setText("Увеличить доход от нажатия, " + price1 + "$");
                    new Saved().save();
                }
            }
        });
        city_price.setText("Оплатить налоги " + MainActivity.nalog);
        city_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= MainActivity.nalog){
                    MainActivity.coutmoney -= MainActivity.nalog;
                    MainActivity.nalog = 0;
                    MainActivity.nalogi.setText("Налог\n" + MainActivity.nalog);
                    city_price.setText("Оплатить налоги " + MainActivity.nalog);
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    new Saved().save();
                }
            }
        });
    }
}
