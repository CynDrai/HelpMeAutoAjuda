package com.example.felipesavaris.helpmeautoajuda.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHMAAOpenHelper  extends SQLiteOpenHelper {

    //Alterar a versão do banco para cada alteração no onUpgrade
    public dbHMAAOpenHelper(Context context) {
        super(context, "dbHMAA", null, 35);
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
        db.execSQL(ddl.getTableComments());

        //Insert Categorias
        ScriptDDLCategories insert = new ScriptDDLCategories();

        db.execSQL(insert.insertDepressao());
        db.execSQL(insert.insertCigarro());
        db.execSQL(insert.insertAlcool());
        db.execSQL(insert.insertMaconha());
        db.execSQL(insert.insertCrack());
        db.execSQL(insert.insertJogosDeAzar());

        //INSERT para Apresentação
        db.execSQL("insert into usuario(id_usuario, email, nome_usuario, nome_fic, refsenha)" +
                " values(20202020, 'apresentacao@exemplo.com', 'Fernando Rigo Botelho', 'RazZ', " +
                "'$2a$05$e7mYssd2iJlMJDjIlVNL1O/94VzM6QzA4iglWq7nx9XNqCZzX6RhK')");

        db.execSQL("insert into professional(id_professional, email, name, ficname, cpf, cnpj, address, fone , refsenha)" +
                " values(40404040, 'profissional@exemplo.com', 'Rodrigo do Espirito Santo', 'Clinica de Depressão'," +
                " '00000000000', '00000000000000', 'Rua Guarani 1550', '45998745612', " +
                "'$2a$05$e7mYssd2iJlMJDjIlVNL1O/94VzM6QzA4iglWq7nx9XNqCZzX6RhK')");

        db.execSQL("insert into categoria_professional(id_categoria, id_professional) " +
                "values(0, 40404040)");
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

            db.execSQL(insert.insertDepressao());
            db.execSQL(insert.insertCigarro());
            db.execSQL(insert.insertAlcool());
            db.execSQL(insert.insertMaconha());
            db.execSQL(insert.insertCrack());
            db.execSQL(insert.insertJogosDeAzar());

        }

        if(oldVersion < 32) {

            ScriptDDL ddl = new ScriptDDL();

            db.execSQL(ddl.getTableStory());

        }

        if(oldVersion < 33) {

            ScriptDDL ddl = new ScriptDDL();

            db.execSQL(ddl.getTableComments());
        }

        if(oldVersion < 34) {

            ScriptDDLCategories insert = new ScriptDDLCategories();

            db.execSQL(insert.insertDepressao());

        }

        if(oldVersion < newVersion) {
            //INSERT para Apresentação
            db.execSQL("insert into usuario(id_usuario, email, nome_usuario, nome_fic, refsenha)" +
                    " values(20202020, 'apresentacao@exemplo.com', 'Fernando Rigo Botelho', 'RazZ', " +
                    "'$2a$05$e7mYssd2iJlMJDjIlVNL1O/94VzM6QzA4iglWq7nx9XNqCZzX6RhK')");

            db.execSQL("insert into professional(id_professional, email, name, ficname, cpf, cnpj, address, fone , refsenha)" +
                    " values(40404040, 'profissional@exemplo.com', 'Rodrigo do Espirito Santo', 'Clinica de Depressão'," +
                    " '00000000000', '00000000000000', 'Rua Guarani 1550', '45998745612', " +
                    "'$2a$05$e7mYssd2iJlMJDjIlVNL1O/94VzM6QzA4iglWq7nx9XNqCZzX6RhK')");

            db.execSQL("insert into categoria_professional(id_categoria, id_professional) " +
                    "values(0, 40404040)");
        }
    }
}
