package com.example.felipesavaris.helpmeautoajuda.Database;

public class ScriptDDL {

    //Criação da Table Usuário
    public static String getTableUsuario() {

        String sql = "";

        sql =  "CREATE TABLE IF NOT EXISTS USUARIO (";
        sql += "ID_USUARIO          BIGINT              NOT NULL,";
        sql += "EMAIL               VARCHAR(100)        NOT NULL,";
        sql += "NOME_USUARIO        VARCHAR(100)        NOT NULL,";
        sql += "NOME_FIC            VARCHAR(100)        ,";
        sql += "SENHA               VARCHAR(100)        NOT NULL,";
        sql += "CONSTRAINT          PK_LOGIN            PRIMARY KEY(ID_USUARIO)); ";

        return sql;
    }

    //Criação da Table Categoria
    public static String getTableCategoria() {

        String sql = "";

        sql =  "CREATE TABLE IF NOT EXISTS CATEGORIA (";
        sql += "ID_CATEGORIA        INTEGER             NOT NULL,";
        sql += "ID_USUARIO          BIGINT              ,";
        sql += "NOME_CATEGORIA      VARCHAR(50)         NOT NULL,";
        sql += "CONSTRAINT          PK_CATEGORIA        PRIMARY KEY(ID_CATEGORIA),";
        sql += "CONSTRAINT FK_USUARIO_CATEGORIA FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)); ";

        //VALORES USADOS FUTURAMENTE EM UM DAO
        /*//Valores Estáticos de Categorias
        //Depressão
        sql += "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA)";
        sql += "VALUES(0, 'Depressão'); ";

        //Cigarro
        sql += "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA)";
        sql += "VALUES(1, 'Cigarro'); ";

        //Álcool
        sql += "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA)";
        sql += "VALUES(2, 'Álcool'); ";

        //Maconha
        sql += "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA)";
        sql += "VALUES(3, 'Maconha'); ";

        //Crack
        sql += "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA)";
        sql += "VALUES(4, 'Crack'); ";

        //Jogos de Azar
        sql += "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA)";
        sql += "VALUES(0, 'Jogos de Azar'); ";*/

        return sql;
    }

    //Método responsavel de retornar todas as tabelas
    public static String getAllTables() {

        String sql = "";

        sql =  getTableUsuario();
        sql += getTableCategoria();

        return sql;
    }

}
