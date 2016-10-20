package com.example.zw.the_first_code;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by zw on 2016/8/12.
 */
public class MyProvider extends ContentProvider {
    public static final int TABLE1_DIR=0;
    public static final int TABLE1_ITEM = 1;

    public static final int TABLE2_DIR = 2;

    public static final int TABLE2_ITEM = 3;
    public static UriMatcher uriMatcher;
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);

    }

    @Override
    public boolean onCreate() {
        return false;
    }

    //uri确定查询哪张表 projection用于确定查询哪些列 selection和selectionArgs用于查询哪些行
    //sortOrder用于对结果进行排序 查询的结果存放在Cursor中返回
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }
    //根据传入的内容URI来返回相应的MIME类型
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
