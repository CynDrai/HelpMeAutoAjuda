package com.example.felipesavaris.helpmeautoajuda.Database;

public class ScriptDDL {

    //Criação da Table Usuário
    protected String getTableUsuario() {

        String sql = "";

        sql =  "CREATE TABLE IF NOT EXISTS USUARIO (";
        sql += "ID_USUARIO          BIGINT              NOT NULL,";
        sql += "EMAIL               VARCHAR(100)        NOT NULL,";
        sql += "NOME_USUARIO        VARCHAR(100)        NOT NULL,";
        sql += "NOME_FIC            VARCHAR(100)        ,";
        sql += "REFSENHA            VARCHAR(200)        NOT NULL,";
        sql += "CONSTRAINT          PK_LOGIN            PRIMARY KEY(ID_USUARIO)); ";

        return sql;
    }

    //Criação da Table Professional
    protected String getTableProfessional() {

        String sql;

        sql =  "CREATE TABLE IF NOT EXISTS PROFESSIONAL (";
        sql += "ID_PROFESSIONAL     BIGINT              NOT NULL,";
        sql += "EMAIL               VARCHAR(100)        NOT NULL,";
        sql += "NAME                VARCHAR(100)        NOT NULL,";
        sql += "FICNAME             VARCHAR(150)        ,";
        sql += "CPF                 VARCHAR(14)         NOT NULL,";
        sql += "CNPJ                VARCHAR(18)         ,";
        sql += "ADDRESS             VARCHAR(100)        NOT NULL,";
        sql += "FONE                BIGINT              NOT NULL,";
        sql += "CONSTRAINT          PK_PROFESSIONAL     PRIMARY KEY(ID_PROFESSIONAL)); ";

        return sql;
    }

    //Criação da Table Categoria
    protected String getTableCategoria() {

        String sql = "";

        sql =  "CREATE TABLE IF NOT EXISTS CATEGORIA (";
        sql += "ID_CATEGORIA        INTEGER             NOT NULL,";
        sql += "NOME_CATEGORIA      VARCHAR(50)         NOT NULL,";
        sql += "CONSTRAINT          PK_CATEGORIA        PRIMARY KEY(ID_CATEGORIA));";

        return sql;
    }

    //Método responsavel de retornar todas as tabelas
    protected String getAllTables() {

        String sql = "";

        sql =  getTableUsuario();
        sql += getTableCategoria();
        sql += getTableProfessional();

        return sql;
    }

}
