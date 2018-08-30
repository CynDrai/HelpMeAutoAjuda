package com.example.felipesavaris.helpmeautoajuda.DAO.CategoryDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Connection.ConnectionFactory;

public class CategoryDAO {

    //Método Responsável por adicionar as categorias estáticas
    public static void addStaticCategory(Context context) {

        final SQLiteDatabase conexao;

        try {

            conexao = ConnectionFactory.criarConexao(context);
            ContentValues values = new ContentValues();

        }catch(SQLException ex) {

            System.exit(0);

        }

    }
}
