package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.felipesavaris.helpmeautoajuda.Model.Categoria;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;

public class CategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
    }

    @Override
    public void onBackPressed() {

        //Apagar a instância do Usuário caso aperte o botão voltar
        if(Usuario.getUsuarioUnico() != null) {
            Usuario.setUsuarioUnico(null);
        }

        super.onBackPressed();
    }

    //Botão Depressão
    public void depressionBt(View view) {
        //Mudança de Activity --> selectedCategoriaActivity
        //ATENÇÃO, HÁ APENAS UMA CATEGORIA FUNCIONANDO COM INTENÇÕES DE TESTES
        Intent it = new Intent(
                this,
                selectedCategoriaActivity.class
        );

        Categoria categoria = new Categoria();

        categoria.setId_categoria(0);
        categoria.setNome_categoria("Depressão");

        Categoria.setCategoriaUnica(categoria);

        startActivity(it);
    }
}
