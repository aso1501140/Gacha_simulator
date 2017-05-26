package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Context;
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
}
