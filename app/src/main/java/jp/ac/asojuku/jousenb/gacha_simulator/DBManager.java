package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

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

    //ぷりぷり

    public DBManager(Context context){
        super(context,"simulator.sqlite3",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS game(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT,money INTEGER,stone INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS percent(_id INTEGER, rarelity TEXT, percent INTEGER,PRIMARY KEY(_id, rarelity));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        //db.execSQL("DROP TABLE game");
        //onCreate(db);
    }

    public void insert(SQLiteDatabase db, String t, int m, int s){
        String sql = "INSERT INTO game(title,money,stone) VALUES(?,?,?)";

        //DML文、DDL文の実行するときはexecSQLメソッドを使用1
        db.execSQL(sql,new String[]{t,String.valueOf(m),String.valueOf(s)});
    }

    public void insertp(SQLiteDatabase db,int i,String r,int p){
        String sql = "INSERT INTO percent(_id,rarelity,percent) VALUES(?,?,?)";
        db.execSQL(sql,new String[]{String.valueOf(i),r,String.valueOf(p)});
    }

    //ゲームリストを取得
    public SQLiteCursor selectGameList(SQLiteDatabase db){
        String selectSql = "SELECT * FROM game ORDER BY _id";
        SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(selectSql, null);
        return cursor;
    }

    //ゲームリスト（登録用）
    public String selectPercentList(SQLiteDatabase db){
        String result = null;
        String selectSql = "SELECT * FROM game ORDER BY _id desc limit 1";
        SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(selectSql, null);
        cursor.moveToFirst();
        result = cursor.getString(0);
        Log.v("データ",result);
        return result;
    }

    public SQLiteCursor selectGPercentList(SQLiteDatabase db,int gid){
        String pselect = "SELECT * FROM percent WHERE _id = ?";
        SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(pselect, new String[]{String.valueOf(gid)});
        cursor.moveToFirst();
        return cursor;
    }

    public SQLiteCursor selectgameList(SQLiteDatabase db,int gid){
        String select = "SELECT * FROM game WHERE _id = ?";
        SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(select, new String[]{String.valueOf(gid)});
        cursor.moveToFirst();
        return cursor;
    }



    //ゲームリスト削除
    public void deleteGameList(SQLiteDatabase db, int id){
        String deleteSql = "DELETE FROM game WHERE _id = ?";
        String deleteSql1 = "DELETE FROM percent WHERE _id = ?";
        db.execSQL(deleteSql,new String[]{String.valueOf(id)});
        db.execSQL(deleteSql1,new String[]{String.valueOf(id)});
    }
}
