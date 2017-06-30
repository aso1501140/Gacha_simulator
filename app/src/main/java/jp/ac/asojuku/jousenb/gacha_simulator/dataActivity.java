package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dataActivity extends AppCompatActivity {
    private SQLiteDatabase sqlDB;
    DBManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Button btn = (Button) findViewById(R.id.button);
        Button button = (Button) findViewById(R.id.button2);
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
                Intent intent = new Intent(dataActivity.this, probabilityActivity.class);
                startActivity(intent);


            }
        });
    }

        @Override
        protected void onResume () {
            super.onResume();
            dbm = new DBManager(this);
            sqlDB = dbm.getWritableDatabase();
        }

    @Override
    protected void onPause() {
        super.onPause();
        sqlDB.close();


        final EditText title = (EditText) findViewById(R.id.titlename);

        final EditText onc = (EditText) findViewById(R.id.once);

        final EditText consnum = (EditText) findViewById(R.id.consumptionnum);

        Button Registration = (Button) findViewById(R.id.button2);

        Registration.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String titlename = title.getText().toString();

        String once = onc.getText().toString();

        String consum = consnum.getText().toString();

        //入力文字列があれば、insert実行
        if (titlename !=  null)dbm.insert(sqlDB,titlename);

        if(once != null)dbm.insert(sqlDB,once);

        if(consnum != null)dbm.insert(sqlDB,once);

        //入力欄をクリア
        title.setText("");
        onc.setText("");
        consnum.setText("");

    }
});
    }
    }



