package com.example.felipesavaris.helpmeautoajuda;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;

public class selectedCategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_categoria);

        //CÓDIGO TEMPORÁRIO
        String test[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "M", "N", "O",
        "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        ListView listaTeste = findViewById(R.id.lstRelatos);

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, test);

        listaTeste.setAdapter(adapter);
        //CÓDIGO TEMPORÁRIO

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Depressão");
    }

    @Override
    public void onBackPressed() {

        //Apagar a instância do Usuário caso aperte o botão voltar
        if(Usuario.getUsuarioUnico() != null) {
            Usuario.setUsuarioUnico(null);
        }

        super.onBackPressed();
    }
}
