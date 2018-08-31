package com.example.felipesavaris.helpmeautoajuda;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.felipesavaris.helpmeautoajuda.DAO.CategoryDAO.CategoryDAO;
import com.example.felipesavaris.helpmeautoajuda.Database.BackupDatabase;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.logicMethods.Login.LoginMethods;

public class MainActivity extends AppCompatActivity {

    private EditText edEmailUsuario, edSenhaUsuario;

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
        this.edEmailUsuario = (EditText) findViewById(R.id.edEmailUsuario);
        this.edSenhaUsuario = (EditText) findViewById(R.id.edSenhaUsuario);

        //Dados do usuário após Login bem sucedido
        Usuario.setUsuarioUnico(LoginMethods.loginAccount(
                this, this.edEmailUsuario.getText().toString(),
                this.edSenhaUsuario.getText().toString()));

        if(Usuario.getUsuarioUnico() != null) {

            //Backup Banco de Dados
            BackupDatabase.backupDatabase(this);

            //Mudança de Activity --> CategoriaActivity
            Intent it = new Intent(
              this,
              CategoriaActivity.class
            );

            startActivity(it);

        }
    }

    //Botão Cadastro
    public void cadastroBt (View view) {

        //Mudança de Activity --> CadastroActivity
        Intent it = new Intent(
                this,
                CadastroActivity.class
        );

        startActivity(it);
    }
    
}
