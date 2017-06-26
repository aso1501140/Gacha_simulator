package jp.ac.asojuku.jousenb.gacha_simulator;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;
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
        db.execSQL("CREATE TABLE IF NOT EXISTS game(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT,money INTEGER,stone INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS percent(_id INTEGER, rarelity TEXT, percent INTEGER,PRIMARY KEY(_id, rarelity));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        //db.execSQL("DROP TABLE game");
        //onCreate(db);

    }

    public void insert(SQLiteDatabase db,String inputMessage){
        String sql = "INSERT INTO game(title,money,stone) VALUES(?,?,?)";
        String sql1 = "INSERT INTO parsent(_id,rarelity,TEXT,percent) VALUES(?,?,?)";
        //DML文、DDL文の実行するときはexecSQLメソッドを使用
        db.execSQL(sql,new String[]{inputMessage});
    }

    //ゲームリストを取得
    public SQLiteCursor selectGameList(SQLiteDatabase db){
        String selectSql = "SELECT * FROM game ORDER BY _id";
        SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(selectSql, null);
        return cursor;
    }

    //ゲームリスト削除
    public void deleteGameList(SQLiteDatabase db, int id){
        String deleteSql = "DELETE FROM game WHERE _id = ?";
        String deleteSql1 = "DELETE FROM percent WHERE _id = ?";
        db.execSQL(deleteSql,new String[]{String.valueOf(id)});
    }
}
