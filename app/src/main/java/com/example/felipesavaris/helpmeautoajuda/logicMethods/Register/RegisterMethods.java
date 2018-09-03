package com.example.felipesavaris.helpmeautoajuda.logicMethods.Register;

import android.content.Context;
import android.widget.Toast;

import com.example.felipesavaris.helpmeautoajuda.DAO.RegisterDAO.RegisterDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;

import java.util.Random;

public class RegisterMethods {

    //Método Responsável de fazer a lógica de cadastro de usuários
    public static boolean addRegister(Context context, String email, String nameUsr,
                                   String nameFan, String senhaUsuario) {

        Usuario usuario = new Usuario();

        //Campo E-Mail
        if(email.isEmpty()) {
            makeText(context, "O campo E-Mail não pode estar vazio!");
            return false;
        }
        if(!email.contains("@") || !email.contains(".com")) {
            makeText(context, "Insira um E-Mail válido!");
            return false;
        }
        usuario.setEmail(email);

        //Campo Nome Real de Usuário
        if(nameUsr.isEmpty()) {
            makeText(context, "O campo Usuário não pode estar vazio!");
            return false;
        }
        for (byte a = 0; a < nameUsr.length(); a++) {
            if (Character.isDigit(nameUsr.charAt(a))) {
                makeText(context, "O campo Usuário não pode ter números!");
                return false;
            }
        }
        usuario.setNameUsr(nameUsr);

        //Campo nome Ficticio de Usuário
        if(nameFan.length() > 0 && nameFan.length() < 4) {
            makeText(context, "O nome Fictício deve ter mais que 3 caracteres!");
            return false;
        }
        usuario.setNameFan(nameFan);

        //Campo senha Usuário
        if(senhaUsuario.isEmpty()) {
            makeText(context, "O campo Senha não pode estar vazio!");
            return false;
        }
        if(senhaUsuario.length() < 8) {
            makeText(context, "O campo Senha deve ter mais de 7 caracteres!");
            return false;
        }

        //Hash de senha
        usuario.setRefSenha(senhaUsuario.hashCode());

        //Verificador de redundâncias no banco = ID_USUARIO e E-MAIL
        boolean result = false;
        while(result == false) {
            usuario.setId_usuario(GeneratorID.returnID());

            byte resultTmp = RegisterDAO.vrfIdEmail(context, email, usuario.getId_usuario());

            if (resultTmp == 1) continue;

            if (resultTmp == 2) {
                makeText(context, "Este E-mail já está cadastrado!");
                return false;
            }

            result = true;
        }

        //Resultado do sucesso do cadastro no banco
        //se - 1 == falha
        long resultDB;
        resultDB = RegisterDAO.addLogin(context, usuario);

        //Toast com o resultado do cadastro
        if(resultDB == -1) {
            makeText(context, "Falha no cadastro no banco de dados!");
            return false;
        } else {
            makeText(context, "Cadastro feito com sucesso");
        }

        return true;
    }

    private static void makeText(Context context, String str) {
        Toast.makeText(
                context,
                str,
                Toast.LENGTH_LONG).show();
    }
}
