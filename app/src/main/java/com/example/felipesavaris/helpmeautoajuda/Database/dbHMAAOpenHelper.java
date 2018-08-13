package com.example.felipesavaris.helpmeautoajuda.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHMAAOpenHelper  extends SQLiteOpenHelper {
    public dbHMAAOpenHelper(Context context) {
        super(context, "dbHMMA", null, 1);
    }

    //Responsavel por criar o Banco de Dados
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ScriptDDL.getCreateTableUsuario());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}