package com.example.felipesavaris.helpmeautoajuda;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class selectedCategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_categoria);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Depressão");
    }
}
