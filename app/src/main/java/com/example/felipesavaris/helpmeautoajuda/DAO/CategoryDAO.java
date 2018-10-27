package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Util.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public List selectAllCategories(Context context) {
        List categories = new ArrayList<Categoria>();

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String[] columns = {
                    "id_categoria",
                    "nome_categoria"
            };

            Cursor cursor = conexao.query(
                    "categoria",
                    columns,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            while (cursor.moveToNext()) {
                Categoria categoria = new Categoria();

                categoria.setId_categoria(cursor.getInt(0));
                categoria.setNome_categoria(cursor.getString(1));

                categories.add(categoria);
            }

            //Fecha a conexão do banco se aberta
            if (conexao.isOpen()) {
                conexao.close();
            }

            return categories;

        } catch (SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
        }
        return null;
    }
}
