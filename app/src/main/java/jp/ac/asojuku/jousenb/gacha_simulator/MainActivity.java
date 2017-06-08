package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by tatsuya hayashi on 2017/05/26
 */

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase sqlDB;
    DBManager dbm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //フォアグラウンド移行時、データベースを読み取りで開く
        /*
        dbm = new DBManager(this);
        sqlDB = dbm.getWritableDatabase();
        */

        Button btn = (Button) findViewById(R.id.register);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameListActivity.class);
                startActivity(intent);
            }
        });


        Button btn1 = (Button) findViewById(R.id.gacha);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameListActivity.class);
                startActivity(intent);

            }
        });
    }
}





    //バッググラウンド時にデータベースを閉じる
    /*
    @Override
    protected void onPause() {
        super.onPause();
        sqlDB.close();
    }
    */





