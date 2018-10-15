package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Util.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

import org.mindrot.jbcrypt.BCrypt;

public class LoginDAO {

    public Usuario findLogin(Context context, String email, String senha) {

        try {
            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String[] columns = {
                    "id_usuario",
                    "email",
                    "nome_usuario",
                    "nome_fic",
                    "refsenha"};


            String where = "email = '" + email + "'";

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

                //Comparador de Hash, se diferente, o usuário não será logado
                usrTmp.setRefSenha(cursor.getString(4));

                if(!BCrypt.checkpw(senha, usrTmp.getRefSenha())) {
                    usrTmp.setEmail(null);
                    break;
                }

                usrTmp.setId_usuario(cursor.getLong(0));
                usrTmp.setEmail(cursor.getString(1));
                usrTmp.setNameUsr(cursor.getString(2));
                usrTmp.setNameFan(cursor.getString(3));

            }

            //Return caso usuário não autenticado
            if(usrTmp.getEmail() == null) {
                ToastMakeText.makeText(
                        context,
                        "Dados fornecidos incorretos!"
                );
                return null;
            }

            //Fecha a conexão do banco se aberta
            if (conexao.isOpen()) {
                conexao.close();
            }

            //Return da Instância
            return usrTmp;

        } catch (SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
        }

        return null;

    }
}
