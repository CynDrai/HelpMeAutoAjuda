package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.felipesavaris.helpmeautoajuda.logicMethods.StoriesMethods;

public class StoriesActivity extends AppCompatActivity {

    private EditText edStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
    }

    //Botão de Salvamento de Relatos
    public void btRegisterStories(View view) {

        //Inicialização do EditText
        this.edStories = findViewById(R.id.edStories);

        StoriesMethods st = new StoriesMethods();

        boolean boo = false;
        boo = st.addStory(
                this,
                this.edStories.getText().toString()
        );

        if(boo) {
            //Mudança de Activity -> selectedCategoriaActivity
            Intent it = new Intent(
                    this,
                    selectedCategoriaActivity.class
            );
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(it);
        }
    }
}
