package com.example.felipesavaris.helpmeautoajuda.Database;

class ScriptDDLCategories {

    //Categoria Depressão
    protected String insertDepressao() {

        String sql = "";

        sql =  "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA) " +
                "VALUES(0, 'Depressão'); ";

        return sql;
    }

    //Categoria Cigarro
    protected String insertCigarro() {

        String sql = "";

        sql = "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA) " +
                "VALUES(1, 'Cigarro'); ";

        return sql;
    }

    //Categoria Alcool
    protected String insertAlcool() {

        String sql = "";

        sql = "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA)" +
                "VALUES(2, 'Álcool'); ";

        return sql;
    }

    //Categoria Maconha
    protected String insertMaconha() {

        String sql = "";

        sql = "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA) " +
                "VALUES(3, 'Maconha'); ";

        return sql;
    }

    //Categoria Crack
    protected String insertCrack() {

        String sql = "";

        sql = "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA) " +
                "VALUES(4, 'Crack'); ";

        return sql;
    }

    //Categoria Jogos de Azar
    protected String insertJogosDeAzar() {

        String sql = "";

        sql = "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME_CATEGORIA)\n" +
                "VALUES(5, 'Jogos de Azar'); ";

        return sql;
    }

}
