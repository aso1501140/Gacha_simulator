package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gacha_activity extends AppCompatActivity {

    Button Btnback;
    Button Btn10kai;
    Button Btn1kai;

    int p1 = 0;
    int p2 = 0;
    int p3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha_activity);

        //渡された確率を取り出す
        Intent intent = getIntent();
        p1 = intent.getIntExtra("P1", 0);
        p2 = intent.getIntExtra("P1", 0);
        p3 = intent.getIntExtra("P1", 0);
        //%単位だったものを小数点に戻す
        p1 = p1 / 100 ;


    }




}
