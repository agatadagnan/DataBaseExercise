package com.example.databaseexercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
    You have some "to do" here. There are some useful tips when using sqlite.
 */

public class DataBaseOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ShoppingList.db";
    public static final String TABLE_NAME = "shopping_list";
    public static final String COL_ID = "ID";
    public static final String COL_2 = "PRODUCT";
    public static final String COL_3 = "AMOUNT";
    public static final String COL_4 = "SHOP";
    public static final String UPGRADE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public static final String CREATE = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_2 + " TEXT, " + COL_3 + " TEXT, " + COL_4 + " TEXT" + ")";
    public static final String CREATE2 = "CREATE TABLE " + TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUCT TEXT, AMOUNT TEXT, SHOP TEXT)";
    public static final String GET_ALL = "select * from " + TABLE_NAME;

    public DataBaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //when you change sth in the structure of DB (tables, columns etc) you have to change version to see changes
    }

    //TODO: fill this method in (1 line needed)
    @Override
    public void onCreate(SQLiteDatabase db) {
        //this is executed only when you are creating db for the first time
        //use execSQL method with suitable String from above
        /*
        enter your code here
         */
    }

    //TODO: fill this method in (2 lines needed)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //this is executed when you change version of your DB which means that you loose all of data by doing so
        //use execSQL method with suitable string from above and create db again
        /*
        enter your code here
         */
    }

    public boolean insertData(String product, String amount, String shop){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, product);
        contentValues.put(COL_3, amount);
        contentValues.put(COL_4, shop);
        // if you have no idea what it is... it probably is null
        //TODO: use suitable method
        /*
        change the following code:
        */
        long result = -1;


        //the method that you have to use returns value so we can use it to check if the operation was successful
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        //cursor interface provides random read-write access to the result set returned by a database query
        SQLiteDatabase db = this.getWritableDatabase();
        //TODO: change "" for sth better
        Cursor result = db.rawQuery("", null);
        return result;
    }

    public boolean modifyData(String id, String product, String amount, String shop){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, id);
        contentValues.put(COL_2, product);
        contentValues.put(COL_3, amount);
        contentValues.put(COL_4, shop);
        //TODO: use update method, it is similar to insert method, you will need: "ID = ?" and new String[] {id}

        // "ID = ?" ID is unique so we use it to localize row to modify
        /*
        enter your code here
         */
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        //TODO: use delete method it is very similar to update method
        /*
        change the following code:
        */
        Integer result = 0;

        //this method returns number od affected rows or if data is not deleted it returns 0
        return result;
    }

    //Ok if you are done here go back to the MainActivity.java for more work
}


// This is the second part, don't do it just yet, we will go back to it if we have time.

/*
        Now you will create your own table
        Think of some kind of a list and create necessary Strings for it (name, columns etc). Then you will need a string like "CREATE" one.
        Modify overridden methods, create new ones (to get all of the data and to insert the data).
        Then go to the activity_main.xml file and add some buttons like i did earlier.
        After that go to MainActivity.java and update the onCreate method, and add listeners to new buttons.
        For the button that shows data you can use showData method.
        Good Luck!
 */
