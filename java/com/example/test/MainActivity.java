package com.example.test;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 对user表进行操作
         */

        // 设置URI
        Uri uri_word = Uri.parse("content://com.example.vocabularybook/words");

        // 插入表中数据
        ContentValues values = new ContentValues();
        values.put("id", 15);
        values.put("word", "Book");
        values.put("meaning", "书本");
        values.put("example", "This is a book.");


        // 获取ContentResolver
        ContentResolver resolver =  getContentResolver();
        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
        resolver.insert(uri_word,values);

        // 通过ContentResolver 向ContentProvider中查询数据
        Cursor cursor = resolver.query(uri_word, new String[]{"id","word","meaning","example"}, null, null, null);
        while (cursor.moveToNext()){
            Log.e("output:","query book:" + cursor.getInt(0) +" "+ cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3));
            // 将表中数据全部输出
        }
        cursor.close();
        // 关闭游标

    }
}