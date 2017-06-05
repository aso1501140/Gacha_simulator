package jp.ac.asojuku.jousenb.gacha_simulator;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase sqlDB;
    DBManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //フォアグラウンド時に読み取り専用でデータベースをオープンする
    @Override
    protected void onResume() {
        super.onResume();
        /*
        dbm = new DBManager(this);
        sqlDB = dbm.getWritableDatabase();
        */
    }

    /*
    @Override
    protected void onPause() {
        super.onPause();
        sqlDB.close();
    }
    */
}
