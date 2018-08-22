package com.example.felipesavaris.helpmeautoajuda.logicMethods.Login;

import android.content.Context;
import android.widget.Toast;

import com.example.felipesavaris.helpmeautoajuda.DAO.LoginDAO.LoginDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;

public class LoginMethods {

    //Método responsavel de fazer o Login
    public static Usuario loginAccount(
            Context context, String email, String senha) {

        if(email.isEmpty() || senha.isEmpty()) {
            makeText(context,
                    "O campo usuário ou senha estão vazios!");
            return null;
        }

        return LoginDAO.findLogin(context, email, senha);
    }

    public static void makeText(Context context , String str) {
        Toast.makeText(
                context,
                str,
                Toast.LENGTH_LONG).show();
    }

}