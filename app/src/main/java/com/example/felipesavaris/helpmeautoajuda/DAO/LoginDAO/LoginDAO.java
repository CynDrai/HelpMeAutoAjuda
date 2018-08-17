package com.example.felipesavaris.helpmeautoajuda.DAO.LoginDAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.felipesavaris.helpmeautoajuda.Connection.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;

public class LoginDAO {

    public static Usuario findLogin(Context context, String login, String senha) {

        final SQLiteDatabase conexao;
        String[] columns = {"id_usuario",
                "email",
                "nome_usuario",
                "nome_fic",
                "senha"};

        String where = "nome_usuario = '" + login + "' and senha = '" + senha + "'";

        conexao = ConnectionFactory.criarConexao(context);

        Cursor cursor = conexao.query(
                "usuario",
                columns,
                where,
                null,
                null,
                null,
                null,
                null);

        Usuario usrTmp = new Usuario();

        while(cursor.moveToNext()) {

            usrTmp.setId_usuario(cursor.getLong(0));
            usrTmp.setEmail(cursor.getString(1));
            usrTmp.setNameUsr(cursor.getString(2));
            usrTmp.setNameFan(cursor.getString(3));
            usrTmp.setSenhaUsuario(cursor.getString(4));
        }

        //Fecha a conexão do banco se aberta
        if(conexao.isOpen()) {
            conexao.close();
        }

        Toast.makeText(
                context,
                usrTmp.getNameUsr() + " " + usrTmp.getNameFan(),
                Toast.LENGTH_LONG).show();

        return null;
    }
}
