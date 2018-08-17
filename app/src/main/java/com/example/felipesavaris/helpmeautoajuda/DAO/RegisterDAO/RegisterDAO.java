package com.example.felipesavaris.helpmeautoajuda.DAO.RegisterDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.felipesavaris.helpmeautoajuda.Connection.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;

public class RegisterDAO {

    public static long addLogin(Context context, Usuario usuario) {

        final SQLiteDatabase conexao;

        try {

            conexao = ConnectionFactory.criarConexao(context);

            //SQL responsável por fazer inserts de cadastros
            ContentValues values = new ContentValues();
            long returnDB;

            values.put("id_usuario", usuario.getId_usuario());
            values.put("email", usuario.getEmail());
            values.put("nome_usuario", usuario.getNameUsr());
            values.put("nome_fic", usuario.getNameFan());
            values.put("senha", usuario.getSenhaUsuario());

            returnDB = conexao.insert(
                    "usuario",
                    null,
                    values);

            //Fecha a conexão do banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return returnDB;

        } catch (SQLException ex) {

            Toast.makeText(
                    context,
                    "Falha no cadastro do Banco - " + ex.getMessage(),
                    Toast.LENGTH_LONG).show();

            return -1;

        }
    }
}
