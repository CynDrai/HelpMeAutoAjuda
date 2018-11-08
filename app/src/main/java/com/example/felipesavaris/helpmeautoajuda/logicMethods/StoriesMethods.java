package com.example.felipesavaris.helpmeautoajuda.logicMethods;

import android.content.Context;

import com.example.felipesavaris.helpmeautoajuda.DAO.StoryDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;
import com.example.felipesavaris.helpmeautoajuda.Model.Story;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

public class StoriesMethods {

    public boolean addStory(Context context,
                            String story) {

        Story tmpStory = new Story();

        //Campo Relato
        if(story.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo do Relato não pode ser enviado vazio!"
            );
            return false;
        }
        if(story.length() < 10) {
            ToastMakeText.makeText(
                    context,
                    "O relato deve ter mais de 10 caracteres!"
            );
            return false;
        }
        if(story.length() > 600) {
            ToastMakeText.makeText(
                    context,
                    "O relato deve conter de 10 a 600 caracteres!"
            );
            return false;
        }
        tmpStory.setStory(story);

        tmpStory.setId_usuario(Usuario.getUsuarioUnico().getId_usuario());
        tmpStory.setId_categoria(Categoria.getCategoriaUnica().getId_categoria());

        StoryDAO dao = new StoryDAO();

        long returnDB = dao.insertStories(context, tmpStory);

        if(returnDB == -1) {
            return false;
        } else {
            ToastMakeText.makeText(
                    context,
                    "Cadastro de Relato efetuado com sucesso"
            );
        }

        return true;
    }

}
