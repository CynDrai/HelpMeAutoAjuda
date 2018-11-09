package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.felipesavaris.helpmeautoajuda.Adapter.Comments.ListCommentsAdapter;
import com.example.felipesavaris.helpmeautoajuda.DAO.CommentDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Comment;
import com.example.felipesavaris.helpmeautoajuda.Model.Story;
import com.example.felipesavaris.helpmeautoajuda.logicMethods.CommentsMethods;

import java.util.ArrayList;
import java.util.List;

public class CommentsActivity extends AppCompatActivity {

    private TextView tvUserStory, tvStory;
    private EditText edCommentText;
    private ListView lvComments;

    private Story story;
    private String nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        this.story = new Story();

        //Dados da Story Selecionada
        this.story.setId_story(getIntent().getIntExtra("ID_STORY", 0));
        this.story.setId_usuario(getIntent().getLongExtra("ID_USUARIO", 0));
        this.story.setId_categoria(getIntent().getIntExtra("ID_CATEGORIA", 0));
        this.story.setStory(getIntent().getStringExtra("STORY"));

        //Nome do dono da Story
        this.nameUser = getIntent().getStringExtra("NAME_USER");

        //Set do Nome do dono da Story
        this.tvUserStory = findViewById(R.id.tvUserStory);
        this.tvUserStory.setText(this.nameUser);

        //Set da Story
        this.tvStory = findViewById(R.id.tvStory);
        this.tvStory.setText(this.story.getStory());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Comentários");

        loadComments();
    }

    //Botão Enviar Comment
    public void btSendComment(View view) {

        //Inicialização do EditText
        this.edCommentText = findViewById(R.id.edCommentText);

        CommentsMethods commentsMethods = new CommentsMethods();
        boolean boo = false;

        boo = commentsMethods.sendComment(
                this,
                this.edCommentText.getText().toString(),
                this.story
        );

        if(boo) {
            this.edCommentText.setText("");
            loadComments();
        }
    }

    public void loadComments() {

        //Lista de Comments
        CommentDAO dao = new CommentDAO();
        List lstComments =
                new ArrayList<Comment>(
                        dao.selectComments(
                                this,
                                this.story.getId_story()
                        )
                );

        //Adapter do ListView
        ListCommentsAdapter adapter =
                new ListCommentsAdapter(
                        this,
                        lstComments
                );

        //Inicialização do ListView
        this.lvComments = findViewById(R.id.lvComments);

        //Set Adapter no ListView
        this.lvComments.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
