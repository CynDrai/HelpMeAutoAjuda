package com.example.felipesavaris.helpmeautoajuda.Model;

public class Story {

    private long id_story;
    private long id_usuario;
    private int id_categoria;
    private String story;

    public long getId_story() {
        return id_story;
    }

    public void setId_story(long id_story) {
        this.id_story = id_story;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
