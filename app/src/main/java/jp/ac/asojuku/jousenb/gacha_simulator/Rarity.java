package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Rarity extends AppCompatActivity {

    private SQLiteDatabase sqlDB;
    DBManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rarity);

        Button btn = (Button) findViewById(R.id.back);
        Button button = (Button) findViewById(R.id.Registration);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Rarity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Rarity.this, GameListActivity.class);
                startActivity(intent);


            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        dbm = new DBManager(this);
        sqlDB = dbm.getWritableDatabase();
        //前画面から値を取得
        Intent i = getIntent();
        //Edittextと「登録」Buttonを登録
        final EditText raritys = (EditText)findViewById(R.id.rarity);

        final EditText percents = (EditText)findViewById(R.id.percent);

        final String id = i.getStringExtra("_id");

        Button insertButton = (Button)findViewById(R.id.Registration);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rarity = raritys.getText().toString();
                String percent = percents.getText().toString();

                //数値をString型からintに変換
                int perc = Integer.parseInt(percent);
                int ids = Integer.parseInt(id);
                //入力文字列があればinsert実行
                if(rarity == null){}
                else if(percent != null)dbm.insertp(sqlDB,ids,rarity,perc);
                //入力欄をクリア
                raritys.setText("");
                percents.setText("");

                Intent intent = new Intent(Rarity.this,GameListActivity.class);
                startActivity(intent);


            }
        });


    }

}
