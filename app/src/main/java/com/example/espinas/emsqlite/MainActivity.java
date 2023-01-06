package com.example.espinas.emsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase mydatabase=this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,age INT)");
        mydatabase.execSQL("INSERT INTO users (name,age) VALUES ('Ali',34)");
        mydatabase.execSQL("UPDATE users SET age = 21 WHERE name = 'Ali'");
        mydatabase.execSQL("DELETE FROM users WHERE age = 21");
        Cursor c=mydatabase.rawQuery("SELECT * FROM users",null);
        int nameIndex=c.getColumnIndex("name");
        int ageIndex=c.getColumnIndex("age");
        if(c.moveToFirst()){
            do{
                Log.i("Name",c.getString(nameIndex));
                Log.i("Age",c.getInt(ageIndex)+"");
            }while (c.moveToNext());
        }
    }
}
