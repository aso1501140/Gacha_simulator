package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dataActivity extends AppCompatActivity {
    private SQLiteDatabase sqlDB;
    DBManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Button btn = (Button) findViewById(R.id.back);
        Button button = (Button) findViewById(R.id.Registration);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dataActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dataActivity.this, GameListActivity.class);
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
        //Edittextと「登録」Buttonを登録
        final EditText titles = (EditText)findViewById(R.id.title);

        final EditText oneg = (EditText)findViewById(R.id.onece);

        final EditText gachastone = (EditText)findViewById(R.id.gachastone);

        Button insertButton = (Button)findViewById(R.id.Registration);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titles.getText().toString();
                String ones = oneg.getText().toString();
                String gstone = gachastone.getText().toString();
                //数値をString型からintに変換
                int one = Integer.parseInt(ones);
                int gtone = Integer.parseInt(gstone);
                //入力文字列があればinsert実行
                if(title == null){}
                else if(ones == null){}
                else if(gstone != null)dbm.insert(sqlDB,title,one,gtone);
                //入力欄をクリア
                titles.setText("");
                oneg.setText("");
                gachastone.setText("");

                String gid = dbm.selectPercentList(sqlDB);

                Intent intent = new Intent(dataActivity.this,Rarity.class);
                intent.putExtra("_id",gid);
                startActivity(intent);


            }
        });


    }
}
