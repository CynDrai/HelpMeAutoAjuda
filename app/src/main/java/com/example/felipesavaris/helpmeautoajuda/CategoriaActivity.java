package com.example.felipesavaris.helpmeautoajuda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.felipesavaris.helpmeautoajuda.DAO.CategoryDAO.CategoryDAO;

public class CategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        //Verificador de Categorias Estáticas
        CategoryDAO.addStaticCategory(this);

    }
}
