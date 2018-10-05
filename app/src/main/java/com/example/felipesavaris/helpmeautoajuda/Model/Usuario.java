package com.example.felipesavaris.helpmeautoajuda.Model;

public class Usuario {

    private Long id_usuario;
    private String email;
    private String nameUsr;
    private String nameFan;
    private String refSenha;


    //Instância do Usuário
    private static Usuario usuarioUnico;


    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameUsr() {
        return nameUsr;
    }

    public void setNameUsr(String nameUsr) {
        this.nameUsr = nameUsr;
    }

    public String getNameFan() {
        return nameFan;
    }

    public void setNameFan(String nameFan) {
        this.nameFan = nameFan;
    }

    public String getRefSenha() {
        return refSenha;
    }

    public void setRefSenha(String refSenha) {
        this.refSenha = refSenha;
    }

    //Instância do Usuário
    public static Usuario getUsuarioUnico() {
        return usuarioUnico;
    }

    public static void setUsuarioUnico(Usuario usuarioUnico) {
        Usuario.usuarioUnico = usuarioUnico;
    }
}
