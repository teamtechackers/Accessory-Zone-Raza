package com.example.accessory_zone_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context)
    {
        super(context, "userdata.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(name TEXT primary key, price TEXT, dec TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");

    }
    public Boolean insertuserdata(String name, String price, String dec) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("price",price);
        contentValues.put("dec",dec);
        long result = DB.insert("Userdetails",null, contentValues);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean updateuserdata(String name, String price, String dec) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("price", price);
        contentValues.put("dec", dec);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Boolean deletedata(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails",null);
        return cursor;
    }
}
