package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Model.Professional;
import com.example.felipesavaris.helpmeautoajuda.Util.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    //Método responsável de retornar a lista de Categorias
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

    //Método responsável por Verificar as categorias que o profissional está cadastrado
    public boolean vrfCheckBox(Context context,
                               int idCategoria,
                               long idProfessional) {

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String[] columns = {
                    "id_categoria",
                    "id_professional"
            };

            String where = "id_categoria = '" + idCategoria + "' and id_professional = '" + idProfessional + "'";

            Cursor cursor = conexao.query(
                    "categoria_professional",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null
            );

            Categoria categoriaTmp = new Categoria();
            Professional professionalTmp = new Professional();

            while(cursor.moveToNext()) {

                categoriaTmp.setId_categoria(cursor.getInt(0));
                professionalTmp.setId_professional(cursor.getLong(1));

                if(categoriaTmp.getId_categoria() != 0
                        ||
                        professionalTmp.getId_professional() != 0) {

                    return true;
                }
            }

            //Fecha a conexão do banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return false;

        } catch(SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
        }

        return false;
    }
}
