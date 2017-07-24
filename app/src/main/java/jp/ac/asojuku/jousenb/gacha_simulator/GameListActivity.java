package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class GameListActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener{

    //データベース操作
    private SQLiteDatabase sqlDB;
    DBManager dbm;

    //変数
    int selectedID = -1;
    int lastPosition = -1;
    int num;

    //かしこまり
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
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
        String[] from = {"title"};

        //データの表示位置
        int[] to = new int[]{android.R.id.text1};

        //リストビューに表示するためのアダプタを生成
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, dblayout, cursor, from, to, 0);

        //アダプタをリストビューにセット
        list.setAdapter(adapter);

        cursor.moveToFirst();//カーソルを0に合わせる
        num = cursor.getInt(0);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){

    }

    @Override
    protected void onResume() {
        super.onResume();

        Button buttonAction1 = (Button) findViewById(R.id.backbutton);
        Button buttonAction2 = (Button) findViewById(R.id.deletebutton);
        Button buttonAction3 = (Button) findViewById(R.id.gachabutton);
        Button buttonAction4 = (Button) findViewById(R.id.raritybutton);
        ListView listAction = (ListView)findViewById(R.id.ListViewGameList);

        //戻る
        buttonAction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //削除
        buttonAction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //行がある
                if (lastPosition != -1){
                    dbm.deleteGameList(sqlDB, selectedID);


                    //削除後のデータをリスト表示
                    ListView listAction = (ListView)findViewById(R.id.ListViewGameList);
                    setValueToList(listAction);

                    //初期値に戻す
                    selectedID = -1;
                    lastPosition = -1;
                }else {
                    Toast.makeText(getApplicationContext(),"削除する行を選択してください",Toast.LENGTH_LONG).show();
                }
            }
        });

        //ガチャ
        buttonAction3.setOnClickListener(new View.OnClickListener() {
            //変数
            SQLiteCursor cursor = null;
            String[] rare = new String[3];
            int[] perc = new int[3];
            int i = 0;
            int money = 0;
            int stone = 0;

            @Override
            public void onClick(View view) {

                //行がある
                if (lastPosition != -1) {
                    //ゲーム表の取得
                    cursor = dbm.selectgameList(sqlDB, selectedID);
                    money = cursor.getInt(2);
                    stone = cursor.getInt(3);
                    cursor.close();

                    //パーセントの取得
                    cursor = dbm.selectGPercentList(sqlDB, selectedID);
                    for (boolean next =cursor.moveToFirst(); next; next = cursor.moveToNext()) {
                        rare[i] = cursor.getString(1);
                        perc[i] = cursor.getInt(2);
                        Log.v("データ", rare[i]);
                        Log.v("データ", String.valueOf(perc[i]));
                        i++;
                    }
                    cursor.close();

                    //遷移作へデータを飛ばす
                    Intent intent = new Intent(getApplicationContext(),gacha_activity.class);
                    intent.putExtra("rare",rare);
                    intent.putExtra("perc",perc);
                    intent.putExtra("money",money);
                    intent.putExtra("stone",stone);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"ガチャる行を選択してください",Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonAction4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(lastPosition != 1) {
                    String gid = dbm.selectPercentList(sqlDB);
                    Intent intent = new Intent(GameListActivity.this, Rarity.class);
                    intent.putExtra("_id", gid);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"追加する行を選択してください",Toast.LENGTH_LONG).show();
                }
            }
        });







       //リストビューを押された時の処理
       listAction.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                if(selectedID != -1){
                    parent.getChildAt(lastPosition).setBackgroundColor(0);
                }
                view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),  R.color.tap_color));
                SQLiteCursor cursor = (SQLiteCursor)parent.getItemAtPosition(position);

                selectedID = cursor.getInt(cursor.getColumnIndex("_id"));

                lastPosition = position;
            }
       });
        setValueToList(listAction);
    }
}