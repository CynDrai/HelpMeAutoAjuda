package com.example.felipesavaris.helpmeautoajuda.logicMethods;

import android.content.Context;

import com.example.felipesavaris.helpmeautoajuda.DAO.CommentDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Comment;
import com.example.felipesavaris.helpmeautoajuda.Model.Story;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;

public class CommentsMethods {

    public boolean sendComment(Context context,
                               String commentText,
                               Story story) {

        Comment comment = new Comment();

        //Campo Comment
        if(commentText.isEmpty()) {
            ToastMakeText.makeText(
                    context,
                    "O campo Comentário não deve estar vazio!"
            );
            return false;
        }
        if(commentText.length() > 600) {
            ToastMakeText.makeText(
                    context,
                    "O campo Comentário não deve ter mais de 600 caracteres!"
            );
            return false;
        }
        comment.setComment(commentText);

        comment.setId_story(story.getId_story());
        comment.setId_usuario(Usuario.getUsuarioUnico().getId_usuario());

        CommentDAO dao = new CommentDAO();

        long resultDB = dao.insertComment(
                context,
                comment
        );

        if(resultDB == -1) {
            return false;
        }
        return true;
    }
}
