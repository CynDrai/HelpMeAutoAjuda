package com.example.felipesavaris.helpmeautoajuda.DAO.RegisterDAO;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import com.example.felipesavaris.helpmeautoajuda.Connection.ConnectionFactory;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;

import java.util.Random;

public class RegisterDAO {

    public static void addLogin(Context context, Usuario usuario) {

        final SQLiteDatabase conexao;

        Random random = new Random();
        int i = random.nextInt(99999999);
        usuario.setId_usuario((long) i);

        try {

            conexao = ConnectionFactory.criarConexao(context);

            //SQL responsável por fazer inserts de cadastros
            String sql = "insert into usuario(id_usuario, ";
            sql += "email, nome_usuario, nome_fic, senha) ";
            sql += "values(?, ?, ?, ?, ?)";

            SQLiteStatement stmp = conexao.compileStatement(sql);

            stmp.bindLong(1, usuario.getId_usuario());
            stmp.bindString(2, usuario.getEmail());
            stmp.bindString(3, usuario.getNameUsr());
            stmp.bindString(4, usuario.getNameFan());
            stmp.bindString(5, usuario.getSenhaUsuario());

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
