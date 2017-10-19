package edu.orangecoastcollege.cs273.ttran1272.candystoreapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AnhTran on 10/19/2017.
 */

public class DatabaseManager extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "candyDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_CANDY = "candy";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";

    public DatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        // build sql create statement
        String sqlCreate = "create table " + TABLE_CANDY + "(" + ID;
        sqlCreate += " integer primary key autoincrement, " + NAME;
        sqlCreate += " text, " + PRICE + " real ";

        db.execSQL(sqlCreate);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // drop old table if it exists
        db.execSQL("drop table if exists" + TABLE_CANDY);
        onCreate(db);
    }

    public void insert(Candy candy) {

        SQLiteDatabase db = this.getWritableDatabase();

        // insert into candy values(null, 'candy1', '12.0' )
        String sqlInsert = "insert into " + TABLE_CANDY;
        sqlInsert += " values(null, '" + candy.getName();
        sqlInsert += "', '" + candy.getPrice() + "' )";

        db.execSQL(sqlInsert);
        db.close();
    }

    public void deleteById( int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        // delete from candy where id = 1
        String sqlDelete = "delete from " + TABLE_CANDY;
        sqlDelete += " where " + ID + " = " + id;

        db.execSQL(sqlDelete);
        db.close();
    }


    public void updateById( int id, String name, double price) {
        SQLiteDatabase db = this.getWritableDatabase();

        // update candy set name = 'aloha', price = '10.0' where id = 2
        String sqlUpdate = "update" + TABLE_CANDY;
        sqlUpdate += " set " + NAME + " = '" + name + "', ";
        sqlUpdate += PRICE + " = '" + price + "'";
        sqlUpdate += " where " + ID + " = " + id;

        db.execSQL(sqlUpdate);
        db.close();
\   }
}
