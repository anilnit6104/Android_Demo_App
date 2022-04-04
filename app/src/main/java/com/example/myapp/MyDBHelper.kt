package com.example.myapp

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME TEXT,EMAIL TEXT,PHONE INTEGER,PWD TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}