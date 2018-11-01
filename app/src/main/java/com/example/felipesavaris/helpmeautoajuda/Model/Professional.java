package com.example.felipesavaris.helpmeautoajuda.Model;

public class Professional {

    private long id_professional;
    private String email;
    private String name;
    private String ficName;
    private String cpf;
    private String cnpj;
    private String address;
    private long fone;
    private String refSenha;

    //Instância do Profissional
    private static Professional professionalUnico;

    public long getId_professional() {
        return id_professional;
    }

    public void setId_professional(long id_professional) {
        this.id_professional = id_professional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFicName() {
        return ficName;
    }

    public void setFicName(String ficName) {
        this.ficName = ficName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getFone() {
        return fone;
    }

    public void setFone(long fone) {
        this.fone = fone;
    }

    public String getRefSenha() {
        return refSenha;
    }

    public void setRefSenha(String refSenha) {
        this.refSenha = refSenha;
    }

    //Instância do Usuário
    public static Professional getProfessionalUnico() {
        return professionalUnico;
    }

    public static void setProfessionalUnico(Professional professionalUnico) {
        Professional.professionalUnico = professionalUnico;
    }
}
