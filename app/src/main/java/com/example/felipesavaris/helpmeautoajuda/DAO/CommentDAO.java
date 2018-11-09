package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Model.Comment;
import com.example.felipesavaris.helpmeautoajuda.Util.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

    //Método responsável por retornar uma lista de Comentários
    public List<Comment> selectComments(Context context,
                                        int id_story) {
        List<Comment> comments = new ArrayList<Comment>();

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String columns[] = {
                    "id_comment",
                    "id_story",
                    "id_usuario",
                    "comment"
            };

            String where = "id_story = '" + id_story + "'";

            Cursor cursor = conexao.query(
                    "comments",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null
            );

            while(cursor.moveToNext()) {
                Comment comment = new Comment();

                comment.setId_comment(cursor.getInt(0));
                comment.setId_story(cursor.getInt(1));
                comment.setId_usuario(cursor.getLong(2));
                comment.setComment(cursor.getString(3));

                comments.add(comment);
            }

            //Fecha a conexão com o banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return comments;

        } catch(SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
            return null;
        }
    }

    //Método responsável por retornar o nome do usuário que fez do Comentário
    public String selectCommentUser(Context context,
                                    long id_usuario) {

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String columns[] = {
                    "nome_usuario"
            } ;

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

        } catch(SQLException ex){
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
            return null;
        }
    }

    //Método responsável por fazer o INSERT de Comments
    public long insertComment(Context context,
                              Comment comment) {

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);
            long returnDB;

            //SQL reponsável por fazer o INSERT de Stories
            ContentValues values = new ContentValues();

            values.put("id_story", comment.getId_story());
            values.put("id_usuario", comment.getId_usuario());
            values.put("comment", comment.getComment());

            returnDB = conexao.insert(
                    "comments",
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
}
