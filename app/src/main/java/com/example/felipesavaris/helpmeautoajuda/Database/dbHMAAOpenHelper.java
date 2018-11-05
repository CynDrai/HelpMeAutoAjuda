package com.example.felipesavaris.helpmeautoajuda.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHMAAOpenHelper  extends SQLiteOpenHelper {

    //Alterar a versão do banco para cada alteração no onUpgrade
    public dbHMAAOpenHelper(Context context) {
        super(context, "dbHMAA", null, 30);
    }

    //Responsavel por criar o Banco de Dados
    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create Tables
        ScriptDDL ddl = new ScriptDDL();

        db.execSQL(ddl.getTableUsuario());
        db.execSQL(ddl.getTableProfessional());
        db.execSQL(ddl.getTableCategoria());
        db.execSQL(ddl.getTableSerial());
        db.execSQL(ddl.getTableCategoriaProfessional());
        db.execSQL(ddl.getTableStory());

        //Insert Categorias
        ScriptDDLCategories insert = new ScriptDDLCategories();

        db.execSQL(insert.insertDepressao());
        db.execSQL(insert.insertCigarro());
        db.execSQL(insert.insertAlcool());
        db.execSQL(insert.insertMaconha());
        db.execSQL(insert.insertCrack());
        db.execSQL(insert.insertJogosDeAzar());

    }

    //Responsável de atualizar as tabelas do Banco de Dados
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion < 29) {


            db.execSQL("drop table if exists usuario");
            db.execSQL("drop table if exists professional");
            db.execSQL("drop table if exists categoria");
            db.execSQL("drop table if exists serial");
            db.execSQL("drop table if exists categoria_professional");

            ScriptDDL ddl = new ScriptDDL();

            db.execSQL(ddl.getTableUsuario());
            db.execSQL(ddl.getTableProfessional());
            db.execSQL(ddl.getTableCategoria());
            db.execSQL(ddl.getTableSerial());
            db.execSQL(ddl.getTableCategoriaProfessional());

            ScriptDDLCategories insert = new ScriptDDLCategories();

            db.execSQL(insert.insertCigarro());
            db.execSQL(insert.insertAlcool());
            db.execSQL(insert.insertMaconha());
            db.execSQL(insert.insertCrack());
            db.execSQL(insert.insertJogosDeAzar());

        }

        if(oldVersion < newVersion) {

            ScriptDDL ddl = new ScriptDDL();

            db.execSQL(ddl.getTableStory());
        }
    }
}
