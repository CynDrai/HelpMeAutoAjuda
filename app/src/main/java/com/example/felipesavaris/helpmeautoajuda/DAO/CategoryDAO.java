package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.ContentValues;
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

            while(cursor.moveToNext()) {
                Categoria categoria = new Categoria();

                categoria.setId_categoria(cursor.getInt(0));
                categoria.setNome_categoria(cursor.getString(1));

                categories.add(categoria);
            }

            //Fecha a conexão do banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return categories;

        } catch(SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
        }
        return null;
    }

    //TEMPORÁRIO até o fim do código
    //Método Responsável por adicionar as categorias estáticas
    public void addStaticCategory(Context context) {

        //Lista de Categorias
        ArrayList list = vrfCategory(context);

        //Condição para fazer INSERTS de categorias Estáticas
        if(list.size() < 6) {
            addCategoryDepressao(context);

            addCategoryCigarro(context);

            addCategoryAlcool(context);

            addCategoryMaconha(context);

            addCategoryCrack(context);

            addCategoryJogosDeAzar(context);
        }
    }

    //Categoria Depressão
    private void addCategoryDepressao(Context context){

        final SQLiteDatabase conexao;

        ContentValues values = new ContentValues();
        conexao = ConnectionFactory.criarConexao(context);

        Categoria categoria = new Categoria();
        categoria.setId_categoria(0);
        categoria.setNome_categoria("Depressão");

        values.put("id_categoria", categoria.getId_categoria());
        values.put("nome_categoria", categoria.getNome_categoria());

        conexao.insert(
                "categoria",
                null,
                values
        );

        if(conexao.isOpen()) {
            conexao.close();
        }
    }

    //Categoria Cigarro
    private void addCategoryCigarro(Context context){

        final SQLiteDatabase conexao;

        ContentValues values = new ContentValues();
        conexao = ConnectionFactory.criarConexao(context);

        Categoria categoria = new Categoria();
        categoria.setId_categoria(1);
        categoria.setNome_categoria("Cigarro");

        values.put("id_categoria", categoria.getId_categoria());
        values.put("nome_categoria", categoria.getNome_categoria());

        conexao.insert(
                "categoria",
                null,
                values
        );

        if(conexao.isOpen()) {
            conexao.close();
        }
    }

    //Categoria Álcool
    private void addCategoryAlcool(Context context){

        final SQLiteDatabase conexao;

        ContentValues values = new ContentValues();
        conexao = ConnectionFactory.criarConexao(context);

        Categoria categoria = new Categoria();
        categoria.setId_categoria(2);
        categoria.setNome_categoria("Álcool");

        values.put("id_categoria", categoria.getId_categoria());
        values.put("nome_categoria", categoria.getNome_categoria());

        conexao.insert(
                "categoria",
                null,
                values
        );

        if(conexao.isOpen()) {
            conexao.close();
        }
    }

    //Categoria Maconha
    private void addCategoryMaconha(Context context){

        final SQLiteDatabase conexao;

        ContentValues values = new ContentValues();
        conexao = ConnectionFactory.criarConexao(context);

        Categoria categoria = new Categoria();
        categoria.setId_categoria(3);
        categoria.setNome_categoria("Maconha");

        values.put("id_categoria", categoria.getId_categoria());
        values.put("nome_categoria", categoria.getNome_categoria());

        conexao.insert(
                "categoria",
                null,
                values
        );

        if(conexao.isOpen()) {
            conexao.close();
        }
    }

    //Categoria Crack
    private void addCategoryCrack(Context context){

        final SQLiteDatabase conexao;

        ContentValues values = new ContentValues();
        conexao = ConnectionFactory.criarConexao(context);

        Categoria categoria = new Categoria();
        categoria.setId_categoria(4);
        categoria.setNome_categoria("Crack");

        values.put("id_categoria", categoria.getId_categoria());
        values.put("nome_categoria", categoria.getNome_categoria());

        conexao.insert(
                "categoria",
                null,
                values
        );

        if(conexao.isOpen()) {
            conexao.close();
        }
    }

    //Categoria Jogos de Azar
    private void addCategoryJogosDeAzar(Context context){

        final SQLiteDatabase conexao;

        ContentValues values = new ContentValues();
        conexao = ConnectionFactory.criarConexao(context);

        Categoria categoria = new Categoria();
        categoria.setId_categoria(5);
        categoria.setNome_categoria("Jogos de Azar");

        values.put("id_categoria", categoria.getId_categoria());
        values.put("nome_categoria", categoria.getNome_categoria());

        conexao.insert(
                "categoria",
                null,
                values
        );

        if(conexao.isOpen()) {
            conexao.close();
        }
    }

    private ArrayList vrfCategory(Context context) {

        final SQLiteDatabase conexao;
        conexao = ConnectionFactory.criarConexao(context);

        String columns[] = {
                "id_categoria",
                "nome_categoria"};

        Cursor cursor = conexao.query(
                "categoria",
                columns,
                null,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList tmpCat = new ArrayList();

        while(cursor.moveToNext()) {
            Categoria categoria = new Categoria();

            categoria.setId_categoria(cursor.getInt(0));
            categoria.setNome_categoria(cursor.getString(1));

            tmpCat.add(categoria);
        }

        if(conexao.isOpen()) {
            conexao.close();
        }

        return tmpCat;
    }
}
