package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class GameListActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener{

    //データベース操作
    private SQLiteDatabase sqlDB;
    DBManager dbm;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){

    }

    @Override
    protected void onResume() {
        super.onResume();


        Button buttonAction1 = (Button) findViewById(R.id.button1);
        Button buttonAction2 = (Button) findViewById(R.id.button2);
        Button buttonAction3 = (Button) findViewById(R.id.button3);
        ListView listAction = (ListView)findViewById(R.id.ListViewGameList);

        //戻る
        buttonAction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //削除
        buttonAction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //ガチャ
        buttonAction3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameListActivity.this, gacha_activity.class);
                startActivity(intent);
            }
        });

       //リストビューを押された時の処理
       /* listGame.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            }
        });*/
        setValueToList(listAction);
    }
    //リスト表示用
    private void setValueToList(ListView list){
        SQLiteCursor cursor = null;

        //データベース接続
        dbm = new DBManager(this);
        sqlDB = dbm.getWritableDatabase();

        //DBMのメソッド呼び出し
        cursor = dbm.selectGameList(sqlDB);

        //リストビューの表示形式を指定
        int dblayout = android.R.layout.simple_list_item_1;

        //リストビューに表示する列
        String[] from = {"game"};

        //データの表示位置
        int[] to = new int[]{android.R.id.text1};

        //リストビューに表示するためのアダプタを生成
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, dblayout, cursor, from, to, 0);

        //アダプタをリストビューにセット
        list.setAdapter(adapter);
    }
}