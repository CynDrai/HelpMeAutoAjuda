package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
    }

    //Botão de Salvamento de Relatos
    public void btRegisterStories(View view) {
        //TEMPORÁRIO
        Intent it = new Intent(
                this,
                selectedCategoriaActivity.class
        );
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(it);
    }
}
