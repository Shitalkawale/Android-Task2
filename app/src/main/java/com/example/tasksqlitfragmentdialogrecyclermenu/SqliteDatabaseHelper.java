package com.example.tasksqlitfragmentdialogrecyclermenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SqliteDatabaseHelper extends SQLiteOpenHelper
{
    public static final int Data_Base_Version=1;
    public static final String DatabaseName="mydatabase";
    public static final String TABLE_NAME="Information";
    public final String username="username";
    public final String email="email";
    public final String mobile="mobile";
    public final String address="address";

    public SqliteDatabaseHelper(@Nullable Context context) {
        super(context, DatabaseName, null, Data_Base_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_create="CREATE TABLE "+TABLE_NAME+"("+username+" varchar(100),"+email+" varchar(100),"+mobile+" varchar(100),"+address+" varchar(100)"+")";
        db.execSQL(table_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_table="DROP TABLE "+TABLE_NAME;
        db.execSQL(drop_table);
    }

    public void add(Information information)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(username,information.getUsername());
        contentValues.put(email,information.getEmail());
        contentValues.put(address,information.getAddress());
        contentValues.put(mobile,information.getMobile());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();

    }

    public void update(Information information)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(username,information.getUsername());


        sqLiteDatabase.update(TABLE_NAME,contentValues,
                mobile+"=?",new String[]{information.getMobile()});
        sqLiteDatabase.close();

    }

    public List<Information> view()
    {
        List<Information> customerList=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String selectAllData="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=sqLiteDatabase.rawQuery(selectAllData,null);

        if (cursor.moveToFirst())
        {
            do {
                Information information=new Information();
                information.setUsername(cursor.getString(0));
                information.setEmail(cursor.getString(1));
                information.setMobile(cursor.getString(2));
                information.setAddress(cursor.getString(3));
                customerList.add(information);
            }while (cursor.moveToNext());

        }
        return customerList;
    }

    public void delete(String name1)
    {

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, username+"=?",new String[]{name1});
        sqLiteDatabase.close();

    }

    public List<Information> getDetails(Information information)
    {
        List<Information> customerList=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String selectAllData="SELECT * FROM "+TABLE_NAME +" WHERE "+ mobile+"=?";
        Cursor cursor=sqLiteDatabase.rawQuery(selectAllData,new String[]{information.getMobile()});

        if (cursor!=null)
        {
            cursor.moveToFirst();
            Information information1=new Information();
            information1.setUsername(cursor.getString(0));
            information1.setEmail(cursor.getString(1));
            information1.setMobile(cursor.getString(2));
            information1.setAddress(cursor.getString(3));
            customerList.add(information1);

        }

        return customerList;

    }

    public List<Information> viewInfo()
    {
        List<Information> customerList=new ArrayList<>();
        Information information=new Information();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String selectAllData="SELECT * FROM "+TABLE_NAME+" WHERE "+username+"="+information.getUsername();
        Cursor cursor=sqLiteDatabase.rawQuery(selectAllData,null);

        if (cursor.moveToFirst())
        {
            do {
                Information information1=new Information();
                information1.setUsername(cursor.getString(0));
                information1.setEmail(cursor.getString(1));
                information1.setMobile(cursor.getString(2));
                information1.setAddress(cursor.getString(3));
                customerList.add(information1);
            }while (cursor.moveToNext());

        }
        return customerList;
    }
}
