package com.example.felipesavaris.helpmeautoajuda;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.felipesavaris.helpmeautoajuda.Adapter.CategoriesProfessional.ListCategoryAdapter;
import com.example.felipesavaris.helpmeautoajuda.DAO.CategoryDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;
import com.example.felipesavaris.helpmeautoajuda.Model.Professional;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalActivity extends AppCompatActivity {

    private ListView listCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Inscrição de Categorias");

        loadCategories();
    }

    @Override
    public void onBackPressed() {

        //Apagar a instância do Profissional caso aperte o botão voltar
        if(Professional.getProfessionalUnico() != null) {
            Professional.setProfessionalUnico(null);
        }

        super.onBackPressed();
    }

    private void loadCategories() {

        //Lista das categorias
        CategoryDAO dao = new CategoryDAO();
        List lstCategories =
                new ArrayList<Categoria>(dao.selectAllCategories(this));

        //Adapter do ListView
        ListCategoryAdapter adapter =
                new ListCategoryAdapter(
                        this,
                        lstCategories
                );

        //Inicialização do ListView
        this.listCategorias = (ListView) findViewById(R.id.lstCategory);

        //Set Adapter no ListView
        listCategorias.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

}
