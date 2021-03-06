package com.example.felipesavaris.helpmeautoajuda.Database;

public class ScriptDDL {

    //Criação da Table Serial
    protected String getTableSerial() {

        String sql;

        sql =  "CREATE TABLE IF NOT EXISTS SERIAL(";
        sql += "SERIAL              VARCHAR(11)         NOT NULL,";
        sql += "CONSTRAINT          PK_SERIAL           PRIMARY KEY(SERIAL)); ";

        return sql;
    }

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
        sql += "REFSENHA            VARCHAR(200)        NOT NULL,";
        sql += "CONSTRAINT          PK_PROFESSIONAL     PRIMARY KEY(ID_PROFESSIONAL)); ";

        return sql;
    }

    //Criação da Table Categoria
    protected String getTableCategoria() {

        String sql = "";

        sql =  "CREATE TABLE IF NOT EXISTS CATEGORIA (";
        sql += "ID_CATEGORIA        INTEGER             NOT NULL,";
        sql += "NOME_CATEGORIA      VARCHAR(50)         NOT NULL,";
        sql += "CONSTRAINT          PK_CATEGORIA        PRIMARY KEY(ID_CATEGORIA)); ";

        return sql;
    }

    //Criação da Table Categoria_Professional -> N..N
    protected String getTableCategoriaProfessional() {

        String sql = "";

        sql =  "CREATE TABLE IF NOT EXISTS CATEGORIA_PROFESSIONAL(";
        sql += "ID_GENERIC                      INTEGER                         AUTO INCREMENT,";
        sql += "ID_CATEGORIA                    INTEGER                         NOT NULL,";
        sql += "ID_PROFESSIONAL                 BIGINT                          NOT NULL,";
        sql += "CONSTRAINT                      PK_CATEGORIA_PROFESSIONAL       PRIMARY KEY(ID_GENERIC),";
        sql += "CONSTRAINT                      FK_CATEGORIA_PROFESSIONAL       FOREIGN KEY(ID_CATEGORIA) ";
        sql +=      "REFERENCES     CATEGORIA(ID_CATEGORIA),";
        sql += "CONSTRAINT                      FK_PROFESSIONAL_CATEGORIA       FOREIGN KEY(ID_PROFESSIONAL) ";
        sql +=      "REFERENCES     PROFESSIONAL(ID_PROFESSIONAL)); ";

        return sql;
    }

    //Criação da Table Story
    protected String getTableStory() {

        String sql = "";

        sql =  "CREATE TABLE IF NOT EXISTS STORY(";
        sql += "ID_STORY                        INTEGER                         PRIMARY KEY AUTOINCREMENT NOT NULL,";
        sql += "ID_USUARIO                      BIGINT                          NOT NULL,";
        sql += "ID_CATEGORIA                    INTEGER                         NOT NULL,";
        sql += "STORY                           VARCHAR(600)                    NOT NULL,";
        sql += "CONSTRAINT                      FK_STORY_USER                   FOREIGN KEY(ID_USUARIO)";
        sql +=      "REFERENCES     USUARIO(ID_USUARIO),";
        sql += "CONSTRAINT                      FK_STORY_CATEGORY               FOREIGN KEY(ID_CATEGORIA)";
        sql +=      "REFERENCES     CATEGORIA(ID_CATEGORIA)); ";

        return sql;
    }

    //Criação da Table Comments
    protected String getTableComments() {

        String sql = "";

        sql =  "CREATE TABLE IF NOT EXISTS COMMENTS(";
        sql += "ID_COMMENT                      INTEGER                         PRIMARY KEY AUTOINCREMENT NOT NULL,";
        sql += "ID_STORY                        INTEGER                         NOT NULL,";
        sql += "ID_USUARIO                      BIGINT                          NOT NULL,";
        sql += "COMMENT                         VARCHAR(600)                    NOT NULL,";
        sql += "CONSTRAINT                      FK_COMMENT_STORY                FOREIGN KEY(ID_STORY)";
        sql +=      "REFERENCES     STORY(ID_STORY),";
        sql += "CONSTRAINT                      FK_COMMENT_USER                 FOREIGN KEY(ID_USUARIO)";
        sql +=      "REFERENCES     USUARIO(ID_USUARIO)); ";

        return sql;
    }
}
