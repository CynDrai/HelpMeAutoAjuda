package com.example.felipesavaris.helpmeautoajuda.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHMAAOpenHelper  extends SQLiteOpenHelper {

    //Alterar a versão do banco para cada alteração no onUpgrade
    public dbHMAAOpenHelper(Context context) {
        super(context, "dbHMAA", null, 21);
    }

    //Responsavel por criar o Banco de Dados
    @Override
    public void onCreate(SQLiteDatabase db) {

        ScriptDDL ddl = new ScriptDDL();
        db.execSQL(ddl.getAllTables());

    }

    //Responsável de atualizar as tabelas do Banco de Dados
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        ScriptDDL ddl = new ScriptDDL();

        if(oldVersion < 5) {
            db.execSQL(ddl.getAllTables());
        }

        if(oldVersion < 13) {
            db.execSQL("drop table categoria");
            db.execSQL(ddl.getTableCategoria());
        }

        if(oldVersion < 14) {
            db.execSQL("drop table usuario");
            db.execSQL(ddl.getTableUsuario());
        }

        if(newVersion == 16) {
            db.execSQL("drop table usuario");
            db.execSQL(ddl.getTableUsuario());
        }

        if(newVersion == 17) {
            db.execSQL("drop table usuario");
            db.execSQL(ddl.getTableUsuario());
        }

        if(newVersion > 17) {
            db.execSQL(ddl.getTableProfessional());
        }

        if(newVersion == 19) {
            db.execSQL("alter table professional " +
                            "add REFSENHA varchar(200) NOT NULL DEFAULT '';");
        }

        if(newVersion == 20) {
            db.execSQL("drop table professional");
            db.execSQL(ddl.getTableProfessional());
        }

        if(oldVersion < 20) {
            db.execSQL(ddl.getTableSerial());
        }
    }
}
