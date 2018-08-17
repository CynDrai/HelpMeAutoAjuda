package com.example.felipesavaris.helpmeautoajuda;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.felipesavaris.helpmeautoajuda.Database.BackupDatabase;
import com.example.felipesavaris.helpmeautoajuda.logicMethods.Login.LoginMethods;

public class MainActivity extends AppCompatActivity {

    private EditText edNomeUsuario, edSenhaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Botão Login
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loginBt (View view) {

        //Inicialização dos EditText
        this.edNomeUsuario = (EditText) findViewById(R.id.edNomeUsuario);
        this.edSenhaUsuario = (EditText) findViewById(R.id.edSenhaUsuario);

        LoginMethods.loginAccount(this, this.edNomeUsuario.getText().toString(),
                this.edSenhaUsuario.getText().toString());

        //Backup Banco de Dados
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
