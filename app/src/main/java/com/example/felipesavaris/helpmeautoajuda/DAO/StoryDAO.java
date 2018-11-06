package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Model.Story;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.Util.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

import java.util.ArrayList;
import java.util.List;

public class StoryDAO {

    //Método responsável por retornar os Relatos para o ListView na Activity
    public List<Story> selectStories(Context context,
                                   int id_categoria) {
        List stories = new ArrayList<Story>();

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String columns[] = {
                    "id_story",
                    "id_usuario",
                    "id_categoria",
                    "story"
            };

            String where = "id_categoria = '" + id_categoria + "'";

            Cursor cursor = conexao.query(
                    "story",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null
            );

            while(cursor.moveToNext()) {
                Story story = new Story();

                story.setId_story(cursor.getInt(0));
                story.setId_usuario(cursor.getLong(1));
                story.setId_categoria(cursor.getInt(2));
                story.setStory(cursor.getString(3));

                stories.add(story);
            }

            //Fecha a conexão do banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return stories;

        } catch (SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
        }
        return null;
    }

    //Método responsável por fazer o INSERT de Stories
    public long insertStories(Context context,
                              Story story) {

        long returnDB;

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            //SQL reponsável por fazer o INSERT de Stories
            ContentValues values = new ContentValues();

            values.put("id_usuario", story.getId_usuario());
            values.put("id_categoria", story.getId_categoria());
            values.put("story", story.getStory());

            returnDB = conexao.insert(
                    "story",
                    null,
                    values
            );

            //Fecha a conexão do banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return returnDB;

        } catch(SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
            return -1;
        }
    }

    //Método responsável por Retornar o nome do Usuário do Story
    public String selectStoryUser(Context context,
                                   long id_usuario) {

        Usuario tmpUsr = new Usuario();

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String columns[] = {
                    "nome_usuario"
            };

            String where = "id_usuario = '" + id_usuario + "'";

            Cursor cursor = conexao.query(
                    "usuario",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null
            );

            String name = "";
            while(cursor.moveToNext()) {
                name = cursor.getString(0);
            }

            //Fecha a conexão com o banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return name;

        } catch(SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! -" + ex.getMessage()
            );
            return null;
        }
    }
}
