package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.felipesavaris.helpmeautoajuda.Adapter.Stories.ListStoriesAdapter;
import com.example.felipesavaris.helpmeautoajuda.DAO.StoryDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;
import com.example.felipesavaris.helpmeautoajuda.Model.Story;

import java.util.ArrayList;
import java.util.List;

public class selectedCategoriaActivity extends AppCompatActivity {

    private ListView lstRelatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_categoria);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Categoria.getCategoriaUnica().getNome_categoria());

        loadStories();
    }

    @Override
    public void onBackPressed() {

        //Apagar a instância da categoria caso aperte o botão voltar
        if(Categoria.getCategoriaUnica() != null) {
            Categoria.setCategoriaUnica(null);
        }

        super.onBackPressed();
    }

    //Botão Deixar Relato
    public void btRegisterStories(View view) {
        //Mudança de Activity -> StoriesActivity
        Intent it = new Intent(
                this,
                StoriesActivity.class
        );

        startActivity(it);
    }

    public void loadStories() {

        //Lista de Stories
        StoryDAO dao = new StoryDAO();
        List lstStories =
                new ArrayList<Story>(
                        dao.selectStories(
                                this,
                                Categoria.getCategoriaUnica().getId_categoria()
                        )
                );

        //Adapter do ListView
        ListStoriesAdapter adapter =
                new ListStoriesAdapter(
                        this,
                        lstStories
                );

        //Inicialização do ListView
        this.lstRelatos = (ListView) findViewById(R.id.lstRelatos);

        //Set Adapter no ListView
        this.lstRelatos.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
