package com.example.felipesavaris.helpmeautoajuda.logicMethods;

import android.content.Context;

import com.example.felipesavaris.helpmeautoajuda.DAO.LoginDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

public class LoginMethods {

    //Método responsavel de fazer o Login
    public static Usuario loginAccount(Context context,
                                       String email,
                                       String senha) {

        if(email.isEmpty() || senha.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo usuário ou senha estão vazios!"
            );
            return null;
        }

        LoginDAO dao = new LoginDAO();

        //Possivel Login Profissional
        if(dao.findLoginProfessional(context, email, senha).getEmail() != null) {
            return null;
        }

        //Return Usuário comum
        return dao.findLogin(context, email, senha);
    }

}