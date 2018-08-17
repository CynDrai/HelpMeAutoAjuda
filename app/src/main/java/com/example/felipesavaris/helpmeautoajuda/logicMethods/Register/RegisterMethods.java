package com.example.felipesavaris.helpmeautoajuda.logicMethods.Register;

import android.content.Context;
import android.widget.Toast;

import com.example.felipesavaris.helpmeautoajuda.DAO.RegisterDAO.RegisterDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;

public class RegisterMethods {

    //Método Responsável de fazer a lógica de cadastro de usuários
    public static void addRegister(Context context, String email, String nameUsr,
                                   String nameFan, String senhaUsuario) {

        Usuario usuario = new Usuario();

        if(email.isEmpty()) {
            makeText(context, "O campo E-Mail não pode estar vazio!");
            return;
        }
        usuario.setEmail(email);

        if(nameUsr.isEmpty()) {
            makeText(context, "O campo Usuário não pode estar vazio!");
            return;
        }
        usuario.setNameUsr(nameUsr);

        usuario.setNameFan(nameFan);

        if(senhaUsuario.isEmpty()) {
            makeText(context, "O campo Senha não pode estar vazio!");
            return;
        }
        usuario.setSenhaUsuario(senhaUsuario);

        //Resultado do sucesso do cadastro no banco
        //se - 1 == falha
        long resultDB;

        resultDB = RegisterDAO.addLogin(context, usuario);

        //Toast com o resultado do cadastro
        if(resultDB == - 1) {
            makeText(context, "Falha no cadastro no banco de dados!");
        } else {
            makeText(context, "Cadastro feito com sucesso");
        }

    }

    public static void makeText(Context context ,String str) {
        Toast.makeText(
                context,
                str,
                Toast.LENGTH_LONG).show();
    }

}
