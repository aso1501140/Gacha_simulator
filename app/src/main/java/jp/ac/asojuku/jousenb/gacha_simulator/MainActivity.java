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

    //テーブルの作成

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
        
        dbm = new DBManager(this);
        sqlDB = dbm.getWritableDatabase();

        Button buttonAction = (Button) findViewById(R.id.register);

        buttonAction.setOnClickListener(new View.OnClickListener() {
            //データの登録
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        dataActivity.class);
                startActivity(intent);
            }
        });
        Button button2Action = (Button) findViewById(R.id.button2);

        button2Action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //ゲームリスト
                Intent intent = new Intent(MainActivity.this,
                        GameListActivity.class);
                startActivity(intent);
            }
        });

        Button button4Action = (Button) findViewById(R.id.button4);

        button4Action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        gacha_activity.class);
                startActivity(intent);
            }
        });

    }



    //バッググラウンド時にデータベースを閉じる

    @Override
    protected void onPause() {
        super.onPause();
        sqlDB.close();
    }


}


