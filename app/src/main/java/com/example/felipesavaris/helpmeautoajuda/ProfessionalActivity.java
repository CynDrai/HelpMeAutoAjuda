package com.example.felipesavaris.helpmeautoajuda;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.felipesavaris.helpmeautoajuda.Adapter.Categories.ListCategoryAdapter;

import java.util.ArrayList;

public class ProfessionalActivity extends AppCompatActivity {

    private ListView listCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Inscrição de categorias");

        loadCategories();
    }

    private void loadCategories() {

        ArrayList lst = new ArrayList();
        lst.add("Teste");

        ListCategoryAdapter adapter =
                new ListCategoryAdapter(
                        this,
                        lst
                );

        this.listCategorias = (ListView) findViewById(R.id.lstCategory);

        listCategorias.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

}
