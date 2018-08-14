package com.example.felipesavaris.helpmeautoajuda.Connection;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.felipesavaris.helpmeautoajuda.Database.dbHMAAOpenHelper;

public class ConnectionFactory {

    //Responsável de criar a conexão do Banco
    public static SQLiteDatabase criarConexao(Context context) {

        dbHMAAOpenHelper dbHMAAOpenHelper;
        SQLiteDatabase conexao;

        try {
            dbHMAAOpenHelper = new dbHMAAOpenHelper(context);

            conexao = dbHMAAOpenHelper.getWritableDatabase();
            
            return conexao;

        } catch (SQLException ex) {

            Toast.makeText(
                    context,
                    "Falha na Conexão do Banco : " + ex.getMessage(),
                    Toast.LENGTH_LONG).show();

            throw new RuntimeException(ex);
        }
    }
}
