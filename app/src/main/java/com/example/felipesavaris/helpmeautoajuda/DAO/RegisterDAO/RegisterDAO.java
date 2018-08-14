package com.example.felipesavaris.helpmeautoajuda.DAO.RegisterDAO;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import com.example.felipesavaris.helpmeautoajuda.Connection.ConnectionFactory;

public class RegisterDAO {

    public static void addLogin(Context context) {

        SQLiteDatabase conexao;

        try {

            conexao = ConnectionFactory.criarConexao(context);

            //SQL responsável por fazer inserts de cadastros
            String sql = "insert into usuario(id_usuario, ";
            sql += "email, nome_usuario, nome_fic, senha) ";
            sql += "values(?, ?, ?, ?, ?)";

            SQLiteStatement stmp = conexao.compileStatement(sql);

            stmp.bindLong(1, 2);
            stmp.bindString(2, "");
            stmp.bindString(3, "");
            stmp.bindString(4, "");
            stmp.bindString(5, "");

            stmp.execute();

            stmp.close();

            Toast.makeText(
                    context,
                    "Cadastro feito com sucesso!",
                    Toast.LENGTH_LONG).show();

        } catch (SQLException ex) {

            Toast.makeText(
                    context,
                    "Falha no cadastro do Banco - " + ex.getMessage(),
                    Toast.LENGTH_LONG).show();

        }

    }
}
