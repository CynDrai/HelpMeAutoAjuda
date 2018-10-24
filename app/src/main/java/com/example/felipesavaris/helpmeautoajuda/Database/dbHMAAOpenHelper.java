package com.example.felipesavaris.helpmeautoajuda.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHMAAOpenHelper  extends SQLiteOpenHelper {

    //Alterar a versão do banco para cada alteração no onUpgrade
    public dbHMAAOpenHelper(Context context) {
        super(context, "dbHMAA", null, 25);
    }

    //Responsavel por criar o Banco de Dados
    @Override
    public void onCreate(SQLiteDatabase db) {

        ScriptDDL ddl = new ScriptDDL();

        db.execSQL(ddl.getTableUsuario());
        db.execSQL(ddl.getTableProfessional());
        db.execSQL(ddl.getTableCategoria());
        db.execSQL(ddl.getTableSerial());

    }

    //Responsável de atualizar as tabelas do Banco de Dados
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        ScriptDDL ddl = new ScriptDDL();

        if(oldVersion < newVersion) {

            db.execSQL("drop table if exists usuario");
            db.execSQL("drop table if exists professional");
            db.execSQL("drop table if exists categoria");
            db.execSQL("drop table if exists serial");

            db.execSQL(ddl.getTableUsuario());
            db.execSQL(ddl.getTableProfessional());
            db.execSQL(ddl.getTableCategoria());
            db.execSQL(ddl.getTableSerial());
        }
    }
}
