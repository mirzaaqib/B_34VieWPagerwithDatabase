package com.pallefire.b_34viewpagerwithdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mirzaaqibbeg on 06-01-2017.
 */

public class Mydatabase {

    //step5: creating here two variables
    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;//for doing dml operation

    //step6: create object for myhelper variable
    public Mydatabase(Context context){
        myHelper=new MyHelper(context,"techpalle.db",null,1);

    }
    //step7: create sqlitedatabase object using open method
    public void open(){
        sqLiteDatabase=myHelper.getWritableDatabase();
    }

    //step8: perform dml operation
    public void insertStudent(String name,String subject,String email){
        ContentValues contentValues=new ContentValues();
        contentValues.put("sname",name);
        contentValues.put("ssubject",subject);
        contentValues.put("semail",email);
        sqLiteDatabase.insert("student",null,contentValues);

    }
    //keep update & delete() on hold
    //step 9: write cursor code for query steps--pass db name with 6 null
    public Cursor queryStudent(){
        Cursor cursor=null;
        cursor=sqLiteDatabase.query("student",null,null,null,null,null,null);
        return cursor;
    }
    //step 10: close the database
    public void close(){
        sqLiteDatabase.close();
    }
    //step3 create inner helper class for performing the ddl operation
    private class MyHelper extends SQLiteOpenHelper {

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //ste4:create all the required table in this method
            //here we will put sql statement inside the java code.
            db.execSQL("create table student(_id integer primary key, sname text, ssubject text,semail text);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
