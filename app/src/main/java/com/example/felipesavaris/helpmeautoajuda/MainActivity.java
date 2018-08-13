package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.felipesavaris.helpmeautoajuda.Connection.ConnectionFactory;

import java.sql.PreparedStatement;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Botão Login
    public void loginBt (View view) {

        this.conexao = ConnectionFactory.criarConexao(this);

        conexao.close();

        // Linha teste para insert, update, delete e select
        // SQLiteStatement stmp = conexao.compileStatement("");

    }

    //Botão Cadastro
    public void cadastroBt (View view) {

        //Mudança de Activity --> CadastroActivity
        Intent it = new Intent(
                this,
                CadastroActivity.class);

        startActivity(it);
    }
    
}
