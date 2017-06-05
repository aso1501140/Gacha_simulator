package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hiroyuki matsuda on 2017/05/26.
 */

public class DBManager extends SQLiteOpenHelper {
    /*
    context 呼び出し元
    name データベース名
    factory cursorオブジェクト
    version 書き換え時に毎回数値を上げる　1,2...
     */

    public DBManager(Context context){
        super(context,"simulator.sqlite3",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE game(gid integer primarykey autoincrement,title text,money integer,stone integer;)");
        db.execSQL("CREATE TABLE percent(gid integer,rarelity text,percent integer,primary key(gid,rarelity))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
