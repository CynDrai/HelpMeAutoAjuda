package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Model.Comment;
import com.example.felipesavaris.helpmeautoajuda.Util.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

public class CommentDAO {

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
