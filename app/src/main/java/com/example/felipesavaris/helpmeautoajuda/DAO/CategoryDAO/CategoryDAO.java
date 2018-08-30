package com.example.felipesavaris.helpmeautoajuda.DAO.CategoryDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Connection.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;

import java.util.ArrayList;

public class CategoryDAO {

    //Método Responsável por adicionar as categorias estáticas
    //ADICIONAR DADOS CONCRETOS PARA PESQUISA
    public static void addStaticCategory(Context context) {

        ArrayList list = vrfCategory(context);

        if(!list.contains(0)) addCategoryDepressao(context);

        if(!list.contains(1)) addCategoryCigarro(context);

        if(!list.contains(2)) addCategoryAlcool(context);

        if(!list.contains(3)) addCategoryMaconha(context);

        if(!list.contains(4)) addCategoryCrack(context);

        if(!list.contains(5)) addCategoryJogosDeAzar(context);

    }

    public static void addCategoryDepressao(Context context){

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

    public static void addCategoryCigarro(Context context){

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

    public static void addCategoryAlcool(Context context){

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

    public static void addCategoryMaconha(Context context){

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

    public static void addCategoryCrack(Context context){

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

    public static void addCategoryJogosDeAzar(Context context){

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

    public static ArrayList vrfCategory(Context context) {

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
