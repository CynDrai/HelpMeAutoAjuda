package com.example.felipesavaris.helpmeautoajuda;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.felipesavaris.helpmeautoajuda.Database.BackupDatabase;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Botão Login, SERVIDO APENAS COMO BACKUP NO MOMENTO
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loginBt (View view) {

        BackupDatabase.backupDatabase(this);

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
