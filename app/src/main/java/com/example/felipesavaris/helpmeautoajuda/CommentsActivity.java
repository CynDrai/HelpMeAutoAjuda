package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.felipesavaris.helpmeautoajuda.Model.Story;
import com.example.felipesavaris.helpmeautoajuda.logicMethods.CommentsMethods;

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
            //Reinicia a Activity
            Intent it = getIntent();
            it.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();
            startActivity(it);
        }
    }
}
