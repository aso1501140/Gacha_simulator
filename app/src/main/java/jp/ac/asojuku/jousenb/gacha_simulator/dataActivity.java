package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Intent;
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
        final EditText title = (EditText)findViewById(R.id.taitoru);

        final EditText SSR = (EditText)findViewById(R.id.SSR);

        final EditText SR = (EditText)findViewById(R.id.SR);

        final EditText RR = (EditText)findViewById(R.id.R);

        final EditText onece = (EditText)findViewById(R.id.onece);

        final EditText gachastone = (EditText)findViewById(R.id.gachastone);

        Button insertButton = (Button)findViewById(R.id.regist);

        insertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String titles = title.getText().toString();
                String RaritySS = SSR.getText().toString();
                String RaritySR = SR.getText().toString();
                String RarityR = RR.getText().toString();
                String onemore = onece.getText().toString();
                String gstone = gachastone.getText().toString();


            }
        });


    }
}

