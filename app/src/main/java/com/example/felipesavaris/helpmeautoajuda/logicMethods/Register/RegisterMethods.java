package com.example.felipesavaris.helpmeautoajuda.logicMethods.Register;

import android.content.Context;

import com.example.felipesavaris.helpmeautoajuda.DAO.RegisterDAO.RegisterDAO;

public class RegisterMethods {

    //Método Responsável de fazer a lógica de cadastro de usuários
    public static void addRegister(Context context, String email, String nameUsr,
                                   String nameFan, String senhaUsuario) {

        RegisterDAO.addLogin(context);

    }

}
