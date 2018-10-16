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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
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
}
