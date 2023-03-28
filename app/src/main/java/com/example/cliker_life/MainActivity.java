package com.example.cliker_life;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static public int coutmoney = 0;
    static public int money = 1;
    static public int nalog = 0;
    Button click, improve;
    ProgressBar lvl11;
    static public TextView textmoney, nalogi;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button)findViewById(R.id.click);
        improve = (Button)findViewById(R.id.improve);
        textmoney = (TextView)findViewById(R.id.money);
        nalogi = (TextView)findViewById(R.id.nalogi);
        Saved.init(getApplicationContext());
        new Saved().load_save();
        Click();
    }
    void Click(){
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coutmoney += money;
                textmoney.setText(coutmoney + "$");
                nalog += 1;
                nalogi.setText("Налог\n" + nalog + "$");
                ProgressBar progressBar = findViewById(R.id.lvl11);
                progressBar.setProgress(coutmoney);
                new Saved().save();
            }
        });
        improve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Improve.class);
                startActivity(intent);
            }
        });

    }

}
