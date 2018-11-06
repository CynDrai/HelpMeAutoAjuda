package com.example.felipesavaris.helpmeautoajuda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.felipesavaris.helpmeautoajuda.Model.Story;

public class CommentsActivity extends AppCompatActivity {

    private TextView tvUserStory, tvStory;

    private Story story;
    private String nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        this.story = new Story();

        //Dados da Story Selecionada
        this.story.setId_story(getIntent().getLongExtra("ID_STORY", 0));
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
}
