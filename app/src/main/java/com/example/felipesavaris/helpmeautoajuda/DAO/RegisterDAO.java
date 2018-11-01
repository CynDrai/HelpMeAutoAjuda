package com.example.felipesavaris.helpmeautoajuda.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felipesavaris.helpmeautoajuda.Model.Professional;
import com.example.felipesavaris.helpmeautoajuda.Util.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

public class RegisterDAO {

    //Método Responsável por Cadastrar novos Usuários
    public long addLogin(Context context,
                         Usuario usuario) {

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
            values.put("refsenha", usuario.getRefSenha());

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

            ToastMakeText.makeText(
                    context,
                    "Falha no cadastro do Banco - " + ex.getMessage()
            );

            return -1;

        }
    }

    //Método responsável por cadastrar novos profissionais
    public long addLoginProfessional(Context context,
                                     Professional professional) {

        final SQLiteDatabase conexao;

        try{

            conexao = ConnectionFactory.criarConexao(context);

            long returnDB;

            //SQL Reponsável por fazer o INSERT de Profissionais
            ContentValues values = new ContentValues();

            values.put("id_professional", professional.getId_professional());
            values.put("email", professional.getEmail());
            values.put("name", professional.getName());
            values.put("ficname", professional.getFicName());
            values.put("cpf", professional.getCpf());
            values.put("cnpj", professional.getCnpj());
            values.put("address", professional.getAddress());
            values.put("fone", professional.getFone());
            values.put("refsenha", professional.getRefSenha());

            returnDB = conexao.insert(
                    "professional",
                    null,
                    values
            );

            //Fecha a conexão do banco se aberta
            if(conexao.isOpen()) {
                conexao.close();
            }

            return returnDB;

        }catch (SQLException ex) {

            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
            return -1;
        }
    }

    //Método responsável de verificar dados redundantes no banco
    //Ligado com addLogin
    //Números de problemas = 1 - ID repetido, 2 - E-mail já cadastrado
    public byte vrfIdEmail(Context context,
                           String email,
                           long id) {

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String[] columns = {
                    "id_usuario",
                    "email"
            };

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

            ToastMakeText.makeText(
                    context,
                    "Houve um erro no banco de dados! - " + ex.getMessage()
            );
        }
        return 0;
    }

    //Método responsável de verificar dados redundantes no banco
    //Ligado com addLoginProfessional
    //Números de problemas = 1 - ID repetido, 2 - E-mail já cadastrado
    public byte vrfIdEmailProfessional(Context context,
                                       String email,
                                       long id) {

        try {

            final SQLiteDatabase conexao;
            conexao = ConnectionFactory.criarConexao(context);

            String[] columns = {
                    "id_professional",
                    "email"
            };

            String where = "id_professional = " + id + " or email = '" + email + "'";

            Cursor cursor = conexao.query(
                    "professional",
                    columns,
                    where,
                    null,
                    null,
                    null,
                    null
            );

            while (cursor.moveToNext()) {

                Professional professional = new Professional();

                professional.setId_professional(cursor.getLong(0));
                professional.setEmail(cursor.getString(1));

                if (id == professional.getId_professional()) {
                    return 1;
                }

                if (email.equals(professional.getEmail())) {
                    return 2;
                }
            }

            //Fecha a conexão do banco se aberta
            if (conexao.isOpen()) {
                conexao.close();
            }

        } catch(SQLException ex) {

            ToastMakeText.makeText(
                    context,
                    "Erro um erro no banco de dados! - " + ex.getMessage()
            );

        }
        return 0;
    }
}
