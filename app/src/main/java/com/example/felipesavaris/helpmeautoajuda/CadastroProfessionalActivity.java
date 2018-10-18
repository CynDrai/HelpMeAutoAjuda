package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CadastroProfessionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professional);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cadastro Profissional");
    }

    //Botão Cadastro Profissional
    public void cadastroProfessionalBt(View view) {

        //Mudança de Activity --> ProfessionalActivity(TEMPORÁRIO)
        Intent it = new Intent(
                this,
                ProfessionalActivity.class
        );

        startActivity(it);
    }
}
