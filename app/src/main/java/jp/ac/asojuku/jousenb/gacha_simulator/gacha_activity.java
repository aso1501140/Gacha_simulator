package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class gacha_activity extends AppCompatActivity {
    int[] pe1 = new int[3];
    double p1 = 0;
    double p2 = 0;
    double p3 = 0;

    int gstone = 0;
    int gmoney = 0;
    int ten = 0;

    int cnt = 0;

    //レアリティごとの個数を数えるための変数
    int ssr = 0;
    int sr = 0;
    int r = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();


        //渡された確率を取り出す
        Intent intent = getIntent();
        pe1 = intent.getIntArrayExtra("perc");
        gmoney = intent.getIntExtra("money",0);
        gstone =intent.getIntExtra("stone",0);
        ten = gmoney * 10;
        //配列に格納されたパーセンテージを格納する
        p1 = pe1[0];
        p2 = pe1[1];
        p3 = pe1[2];
        //%単位だったものを小数点に戻す
        p1 = p1 / 100;
        p2 = p2 / 100;
        p3 = p3 / 100;



        Button Btnback = (Button) findViewById(R.id.Btnback);
        Button Btn1kai = (Button) findViewById(R.id.Btn1kai);
        Button Btn10kai = (Button) findViewById(R.id.Btn10kai);


        Btn1kai.setOnClickListener(new View.OnClickListener() {

            //ガチャを１回まわす
            @Override
            public void onClick(View view) {
                double g = Math.random();
                cnt = cnt + 1;

                if(g < p3){
                    ssr = ssr + 1 ;
                } else if ( g < p2 ) {
                    sr = sr + 1 ;
                } else if ( g < p1 ) {
                    r = r + 1 ;
                }

                //文字の表示
                TextView TextView1 = (TextView)findViewById(R.id.TextView1);
                double pp1 = p3 * 100;
                String o1 = String.valueOf(pp1);
                double pp2 = p2 * 100;
                String o2 = String.valueOf(pp2);
                double pp3 = p1 * 100;
                String o3 = String.valueOf(pp3);
                TextView1.setText("SSR:"+o1+"%" + "SR"+o2+"%" + "R:" + o3 + "%");

                TextView TextView2 = (TextView)findViewById(R.id.TextView2);
                int stone = cnt * gstone;
                String stone2 = String.valueOf(stone);
                TextView2.setText("消費石:"+stone2+"個");

                TextView TextView3 = (TextView)findViewById(R.id.TextView3);
                int money = cnt * gmoney;
                //String money2 = String.valueOf(money);
                TextView3.setText("推定金額"+money+"円");


                TextView textView11 = (TextView)findViewById(R.id.textView11);
                String ssr2 = String.valueOf(ssr);
                textView11.setText("SSR:"+ssr2+"個");

                TextView textView10 = (TextView)findViewById(R.id.textView10);
                String sr2 = String.valueOf(sr);
                textView10.setText("SR"+sr2+"個");

                TextView textView12 = (TextView)findViewById(R.id.textView12);
                String r2 = String.valueOf(r);
                textView12.setText("R:"+r2+"個");



            }
        });

       Btn10kai.setOnClickListener(new View.OnClickListener(){
            //ガチャを10回まわす
           public void onClick(View view){
               cnt = cnt + 10;

               for(int i = 0;i<11;i++){

                   double g = Math.random();
                   if(g < p3){
                       ssr = ssr + 1 ;
                       Log.e("ろぐ2", String.valueOf(ssr));
                   } else if ( g < p2 ) {
                       sr = sr + 1 ;
                       Log.e("ろぐ3", String.valueOf(sr));
                   } else if ( g < p1 ) {
                       r = r + 1;
                       Log.e("ろぐ4", String.valueOf(r));
                   }

               }

               //文字の表示
               TextView TextView1 = (TextView)findViewById(R.id.TextView1);
               double pp1 = p3 * 100;
               String o1 = String.valueOf(pp1);
               double pp2 = p2 * 100;
               String o2 = String.valueOf(pp2);
               double pp3 = p1 * 100;
               String o3 = String.valueOf(pp3);
               TextView1.setText("SSR:"+o1+"%" + "SR"+o2+"%" + "R:" + o3 + "%");

               TextView TextView2 = (TextView)findViewById(R.id.TextView2);
               int stone = cnt * gstone;
               String stone2 = String.valueOf(stone);
               TextView2.setText("消費石:"+stone2+"個");

               TextView TextView3 = (TextView)findViewById(R.id.TextView3);
               int money = cnt * ten;
               //String money2 = String.valueOf(money);
               TextView3.setText("推定金額:"+money+"円");

               TextView textView11 = (TextView)findViewById(R.id.textView11);
               String ssr2 = String.valueOf(ssr);
               textView11.setText("SSR:"+ssr2+"個");

               TextView textView10 = (TextView)findViewById(R.id.textView10);
               String sr2 = String.valueOf(sr);
               textView10.setText("SR:"+sr2+"個");

               TextView textView12 = (TextView)findViewById(R.id.textView12);
               String r2 = String.valueOf(r);
               textView12.setText("R:"+r2+"個");




           }

       });


        Btnback.setOnClickListener(new View.OnClickListener(){
            //戻るボタンをクリック
            public void onClick(View view){
                finish();
            }
        });





}

}