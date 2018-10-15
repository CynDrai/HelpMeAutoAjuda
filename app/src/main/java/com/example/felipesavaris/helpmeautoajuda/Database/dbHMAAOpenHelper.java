package com.example.felipesavaris.helpmeautoajuda.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHMAAOpenHelper  extends SQLiteOpenHelper {

    private Context context;

    //Alterar a versão do banco para cada alteração no onUpgrade
    public dbHMAAOpenHelper(Context context) {
        super(context, "dbHMAA", null, 17);
    }

    //Responsavel por criar o Banco de Dados
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ScriptDDL.getAllTables());

    }

    //Responsável de atualizar as tabelas do Banco de Dados
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion < 5) {
            db.execSQL(ScriptDDL.getAllTables());
        }

        if(oldVersion < 13) {
            db.execSQL("drop table categoria");
            db.execSQL(ScriptDDL.getTableCategoria());
        }

        if(oldVersion < 14) {
            db.execSQL("drop table usuario");
            db.execSQL(ScriptDDL.getTableUsuario());
        }

        if(newVersion == 16) {
            db.execSQL("drop table usuario");
            db.execSQL(ScriptDDL.getTableUsuario());
        }

        if(newVersion == 17) {
            db.execSQL("drop table usuario");
            db.execSQL(ScriptDDL.getTableUsuario());
        }
    }
}
