package com.example.felipesavaris.helpmeautoajuda;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.felipesavaris.helpmeautoajuda.Adapter.ProfessionalData.ListProfessionalDataAdapter;
import com.example.felipesavaris.helpmeautoajuda.DAO.ProfessionalDAO;
import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;
import com.example.felipesavaris.helpmeautoajuda.Model.Professional;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalDataActivity extends AppCompatActivity {

    private ListView lstProfessionalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional_data);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lista de Profissionais");

        loadProfessionals();
    }

    public void loadProfessionals() {

        ProfessionalDAO dao = new ProfessionalDAO();

        //Lista dos Profissionais
        List lstProfessionals =
                new ArrayList<Professional>(
                        dao.selectProfessionals(
                                this,
                                Categoria.getCategoriaUnica().getId_categoria()
                        )
                );

        //Adapter do ListView
        ListProfessionalDataAdapter adapter =
                new ListProfessionalDataAdapter(
                        this,
                        lstProfessionals
                );

        //Inicialização do ListView
        this.lstProfessionalData = findViewById(R.id.lstProfessionalData);

        //Set adapter no ListView
        this.lstProfessionalData.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
