package com.example.felipesavaris.helpmeautoajuda.Util;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Database.dbHMAAOpenHelper;

public class ConnectionFactory {

    //Responsável de criar a conexão do Banco
    public static SQLiteDatabase criarConexao(Context context) {

        final dbHMAAOpenHelper dbHMAAOpenHelper;
        final SQLiteDatabase conexao;

        try {
            dbHMAAOpenHelper = new dbHMAAOpenHelper(context);

            conexao = dbHMAAOpenHelper.getWritableDatabase();
            
            return conexao;

        } catch (SQLException ex) {

            ToastMakeText.makeText(
                    context,
                    "Falha na Conexão do Banco : " + ex.getMessage()
            );

            throw new RuntimeException(ex);
        }
    }
}
