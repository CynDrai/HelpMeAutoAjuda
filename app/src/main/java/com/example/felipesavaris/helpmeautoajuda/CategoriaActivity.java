package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
    }

    //Botão Depressão
    public void depressionBt(View view) {
        //Mudança de Activity --> selectedCategoriaActivity
        //ATENÇÃO, HÁ APENAS UMA CATEGORIA FUNCIONANDO COM INTENÇÕES DE TESTES
        Intent it = new Intent(
                this,
                selectedCategoriaActivity.class
        );

        startActivity(it);
    }
}
