package com.example.felipesavaris.helpmeautoajuda.Model;

public class Categoria {

    private int id_categoria;
    private String nome_categoria;

    //Instância de Categoria
    private static Categoria categoriaUnica;

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    //Instância de Categoria
    public static Categoria getCategoriaUnica() {
        return categoriaUnica;
    }

    public static void setCategoriaUnica(Categoria categoriaUnica) {
        Categoria.categoriaUnica = categoriaUnica;
    }
}
