package com.example.felipesavaris.helpmeautoajuda.database;

public class ScriptDDL {

    //Criação da Table Usuário
    public static String getCreateTableUsuario() {

        String sql = "";

        sql = "CREATE TABLE IF NOT EXISTS USUARIO (";
        sql += "ID_USUARIO  INTEGER         NOT NULL,";
        sql += "NOME_REAL   VARCHAR(100)    NOT NULL,";
        sql += "NOME_FIC    VARCHAR(100)    NOT NULL,";
        sql += "SENHA       VARCHAR(100)    NOT NULL,";
        sql += "CONSTRAINT PK_LOGIN     PRIMARY KEY(ID_USUARIO));";

        return sql;
    }

}
