package com.example.felipesavaris.helpmeautoajuda.logicMethods;

import android.content.Context;

import com.example.felipesavaris.helpmeautoajuda.DAO.RegisterDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Professional;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.Util.GeneratorID;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

import org.mindrot.jbcrypt.BCrypt;

public class RegisterMethods {

    //Método Responsável de fazer a lógica de cadastro de usuários
    public static boolean addRegister(Context context,
                                      String email,
                                      String nameUsr,
                                      String nameFan,
                                      String senhaUsuario) {

        Usuario usuario = new Usuario();

        //Campo E-Mail
        if(email.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo E-Mail não pode estar vazio!"
            );
            return false;
        }
        if(email.contains("@")) {
            if(!email.contains(".com")) {
                ToastMakeText.makeText(
                        context,
                        "Insira um E-Mail válido!"
                );

                return false;
            }
        }
        usuario.setEmail(email);

        //Campo Nome Real de Usuário
        if(nameUsr.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo Usuário não pode estar vazio!"
            );
            return false;
        }
        for (byte a = 0; a < nameUsr.length(); a++) {
            if (Character.isDigit(nameUsr.charAt(a))) {
                ToastMakeText.makeText(
                        context,
                        "O campo Usuário não pode ter números!"
                );
                return false;
            }
        }
        usuario.setNameUsr(nameUsr);

        //Campo nome Ficticio de Usuário
        if(nameFan.length() > 0 && nameFan.length() < 4) {
            ToastMakeText.makeText(
                    context,
                    "O nome Fictício deve ter mais que 3 caracteres!"
            );
            return false;
        }
        usuario.setNameFan(nameFan);

        //Campo senha Usuário
        if(senhaUsuario.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo Senha não pode estar vazio!"
            );
            return false;
        }
        if(senhaUsuario.length() < 8) {
            ToastMakeText.makeText(
                    context,
                    "O campo Senha deve ter mais de 7 caracteres!"
            );
            return false;
        }

        //Hash de senha
        senhaUsuario = BCrypt.hashpw(senhaUsuario, BCrypt.gensalt(5));
        usuario.setRefSenha(senhaUsuario);

        //Verificador de redundâncias no banco = ID_USUARIO e E-MAIL
        boolean result = false;
        RegisterDAO dao = new RegisterDAO();
        GeneratorID gId = new GeneratorID();

        while(result == false) {
            //Gerador de ID
            usuario.setId_usuario(gId.returnID());

            //Verificação de redundância = Resultado
            byte resultTmp = dao.vrfIdEmail(context, email, usuario.getId_usuario());

            if (resultTmp == 1) continue;

            if (resultTmp == 2) {
                ToastMakeText.makeText(
                        context,
                        "Este E-mail já está cadastrado!"
                );
                return false;
            }

            result = true;
        }

        //Resultado do sucesso do cadastro no banco
        //se - 1 == falha
        long resultDB;
        resultDB = dao.addLogin(context, usuario);

        //Toast com o resultado do cadastro
        if(resultDB == -1) {
            ToastMakeText.makeText(
                    context,
                    "Falha no cadastro no banco de dados!"
            );
            return false;

        } else {
            ToastMakeText.makeText(
                    context,
                    "Cadastro feito com sucesso"
            );
        }

        return true;
    }

    //Método responsável de registrar novos Profissionais
    public boolean addRegisterProfessional(Context context,
                                           String email,
                                           String name,
                                           String ficName,
                                           String cpf,
                                           String cnpj,
                                           String address,
                                           String fone,
                                           String password) {

        Professional professional = new Professional();

        //Campo E-Mail
        if(email.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo E-Mail não pode estar vazio!"
            );
            return false;
        }
        if(email.contains("@")) {
            if(!email.contains(".com")) {
                ToastMakeText.makeText(
                        context,
                        "Insira um E-Mail válido!"
                );

                return false;
            }
        }
        professional.setEmail(email);

        //Campo Nome Real de Usuário
        if(name.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo Nome do Profissional não pode estar vazio!"
            );
            return false;
        }
        for (byte a = 0; a < name.length(); a++) {
            if (Character.isDigit(name.charAt(a))) {
                ToastMakeText.makeText(
                        context,
                        "O campo Nome do Profissional não pode ter números!"
                );
                return false;
            }
        }
        professional.setName(name);

        //Campo nome Ficticio de Usuário
        if(ficName.length() > 0 && ficName.length() < 4) {
            ToastMakeText.makeText(
                    context,
                    "O nome Fictício deve ter mais que 3 caracteres!"
            );
            return false;
        }
        professional.setFicName(ficName);

        //Campo CPF
        if(cpf.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo CPF não deve estar vazio!"
            );
            return false;
        }
        for(byte a = 0; a < cpf.length(); a++) {
            if(Character.isLetter(cpf.charAt(a))) {
                ToastMakeText.makeText(
                        context,
                        "O campo CPF não deve ter letras!"
                );
                return false;
            }
        }
        if(cpf.length() < 11) {
            ToastMakeText.makeText(
                    context,
                    "O campo CPF deve ter 11 números!"
            );
            return false;
        }
        professional.setCpf(cpf);

        //Campo CNPJ
        if(cnpj.length() > 0 && cnpj.length() < 14) {
            ToastMakeText.makeText(
                    context,
                    "O campo CNPJ deve ter mais de 14 números!"
            );
            return false;
        }
        for(byte a = 0; a < cnpj.length(); a++) {
            if(Character.isLetter(cnpj.charAt(a))) {
                ToastMakeText.makeText(
                        context,
                        "O campo CNPJ não deve ter letras!"
                );
                return false;
            }
        }
        professional.setCnpj(cnpj);

        //Campo Address
        if(address.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo Endereço não deve estar vazio!"
            );
            return false;
        }
        if(address.length() > 100) {
            ToastMakeText.makeText(
                    context,
                    "O campo Endereço não deve ter mais de 100 caracteres!"
            );
            return false;
        }
        professional.setAddress(address);

        //Campo Telefone
        if(fone.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo Telefone não deve estar vazio!"
            );
            return false;
        }
        if(fone.length() > 15) {
            ToastMakeText.makeText(
                    context,
                    "Númeração Invalida - EX de modelo de número:\n" +
                            "Celular: XXX (XX) X XXXX-XXXX\n" +
                            "Telefone: XXX (XX) XXXX-XXXX"
            );
            return false;
        }
        for(byte a = 0; a < fone.length(); a++) {
            if(Character.isLetter(fone.charAt(a))) {
                ToastMakeText.makeText(
                        context,
                        "O campo Telefone não deve conter letras!"
                );
                return false;
            }
        }
        professional.setFone(Long.parseLong(fone));

        //Campo Senha
        if(password.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo Senha não deve estar vazio!"
            );
            return false;
        }
        if(password.length() < 8) {
            ToastMakeText.makeText(
                    context,
                    "O campo senha não deve ter menos de 8 caracteres!"
            );
            return false;
        }
        password = BCrypt.hashpw(password, BCrypt.gensalt(5));
        professional.setRefSenha(password);

        boolean result = false;
        GeneratorID generatorID = new GeneratorID();
        RegisterDAO dao = new RegisterDAO();

        //Verificador de Redundâncias no banco -> ID_PROFESSIONAL, EMAIL
        while(result == false) {
            //Gerador de ID
            professional.setId_professional(generatorID.returnID());

            //Verificação de redundância = Resultado
            byte resultTmp = dao.vrfIdEmailProfessional(
                    context,
                    email,
                    professional.getId_professional()
            );

            if (resultTmp == 1) continue;

            if (resultTmp == 2) {
                ToastMakeText.makeText(
                        context,
                        "Este E-mail já está cadastrado!"
                );
                return false;
            }
            result = true;
        }

        //Resultado do sucesso do cadastro no banco
        //se - 1 == falha
        long resultDB;
        resultDB = dao.addLoginProfessional(context, professional);

        //Toast com o resultado do cadastro
        if(resultDB == -1) {
            ToastMakeText.makeText(
                    context,
                    "Falha no cadastro no banco de dados!"
            );
            return false;

        } else {
            ToastMakeText.makeText(
                    context,
                    "Cadastro feito com sucesso"
            );
        }

        return true;
    }

}
