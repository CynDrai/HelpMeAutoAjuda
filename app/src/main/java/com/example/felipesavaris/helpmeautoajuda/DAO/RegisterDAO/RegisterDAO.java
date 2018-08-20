package com.example.felipesavaris.helpmeautoajuda.DAO.RegisterDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    //Método responsável de verificar dados redundantes no banco
    //Números de problemas = 1 - ID repetido, 2 - E-mail já cadastrado
    public static byte vrfIdEmail(Context context, String email, long id) {

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String[] columns = {
                    "id_usuario",
                    "email"};

            String where = "id_usuario = " + id + " or email = '" + email + "'";

            Cursor cursor = conexao.query(
                    "usuario",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null
            );


            while (cursor.moveToNext()) {

                Usuario usrTmp = new Usuario();

                usrTmp.setId_usuario(cursor.getLong(0));
                usrTmp.setEmail(cursor.getString(1));

                if (id == usrTmp.getId_usuario()) {
                    return 1;
                }

                if (email.equals(usrTmp.getEmail())) {
                    return 2;
                }
            }

            //Fecha a conexão do banco se aberta
            if (conexao.isOpen()) {
                conexao.close();
            }

        } catch(SQLException ex) {
            Toast.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
        return 0;
    }

}