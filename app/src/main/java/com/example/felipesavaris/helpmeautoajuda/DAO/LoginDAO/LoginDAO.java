package com.example.felipesavaris.helpmeautoajuda.DAO.LoginDAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.felipesavaris.helpmeautoajuda.Connection.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;

public class LoginDAO {

    public static Usuario findLogin(Context context, String email, String senha) {

        try {
            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String[] columns = {
                    "id_usuario",
                    "email",
                    "nome_usuario",
                    "nome_fic",
                    "senha"};

            String where = "email = '" + email + "' and senha = '" + senha + "'";

            Cursor cursor = conexao.query(
                    "usuario",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            Usuario usrTmp = new Usuario();

            while (cursor.moveToNext()) {

                usrTmp.setId_usuario(cursor.getLong(0));
                usrTmp.setEmail(cursor.getString(1));
                usrTmp.setNameUsr(cursor.getString(2));
                usrTmp.setNameFan(cursor.getString(3));
                usrTmp.setSenhaUsuario(cursor.getString(4));
            }

            //Toast para mostrar dados pegos do banco
            //Método será retirado quando a activity categorias for lançada
            if(usrTmp.getEmail() == null) {
                Toast.makeText(
                        context,
                        "Dados fornecidos incorretos!",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(
                        context,
                        "E-Mail: " + usrTmp.getEmail() + "\n" +
                                "Nome Real: " + usrTmp.getNameUsr() + "\n" +
                                "Nome Fantasia: " + usrTmp.getNameFan(),
                        Toast.LENGTH_LONG).show();
            }
            //Fecha a conexão do banco se aberta
            if (conexao.isOpen()) {
                conexao.close();
            }

        } catch (SQLException ex) {
            Toast.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage(),
                    Toast.LENGTH_LONG).show();
        }

        return null;
    }
}
