package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Model.Professional;
import com.example.felipesavaris.helpmeautoajuda.Util.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

import org.mindrot.jbcrypt.BCrypt;

public class LoginDAO {

    //Login Usuário Comum
    public Usuario findLogin(Context context,
                             String email,
                             String senha) {

        try {
            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String[] columns = {
                    "id_usuario",
                    "email",
                    "nome_usuario",
                    "nome_fic",
                    "refsenha"
            };


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

            //Fecha a conexão do banco se aberta
            if (conexao.isOpen()) {
                conexao.close();
            }

            //Return caso usuário não autenticado
            if(usrTmp.getEmail() == null) {
                ToastMakeText.makeText(
                        context,
                        "Dados fornecidos incorretos!"
                );
                return null;
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

    //Login Profissional
    public Professional findLoginProfessional(Context context,
                                              String email,
                                              String senha) {

        try{

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String[] columns = {
                    "id_professional",
                    "email",
                    "name",
                    "ficname",
                    "cpf",
                    "cnpj",
                    "address",
                    "fone",
                    "refsenha"
            };

            String where = "email = '" + email + "'";

            Cursor cursor = conexao.query(
                    "professional",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            Professional professionalTmp = new Professional();

            while(cursor.moveToNext()) {

                //Comparador de Hash, se diferente, o profissional não será logado
                professionalTmp.setRefSenha(cursor.getString(8));
                if(!BCrypt.checkpw(senha, professionalTmp.getRefSenha())) {
                    professionalTmp.setEmail(null);
                    break;
                }

                professionalTmp.setId_professional(cursor.getLong(0));
                professionalTmp.setEmail(cursor.getString(1));
                professionalTmp.setName(cursor.getString(2));
                professionalTmp.setFicName(cursor.getString(3));
                professionalTmp.setCpf(cursor.getString(4));
                professionalTmp.setCnpj(cursor.getString(5));
                professionalTmp.setAddress(cursor.getString(6));
                professionalTmp.setFone(cursor.getLong(7));

            }

            //Fecha a conexão do banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            //Return null caso Profissional não exista
            if(professionalTmp.getEmail() == null) {
                return professionalTmp;
            }

            //Set Instância Unica Professional
            Professional.setProfessionalUnico(professionalTmp);

            return professionalTmp;

        }catch(SQLException ex) {
            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
        }
        return null;
    }
}
