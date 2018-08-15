package com.example.felipesavaris.helpmeautoajuda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.felipesavaris.helpmeautoajuda.logicMethods.Register.RegisterMethods;

public class CadastroActivity extends AppCompatActivity {

    private EditText edEmail, edNameUsr, edNameFan, edSenhaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    //Botão responsável de fazer o cadastro de novos usuários
    public void cadastroBt(View view) {

        //Inicialização dos EditText
        this.edEmail = (EditText) findViewById(R.id.edEmail);
        this.edNameUsr = (EditText) findViewById(R.id.edNameUsr);
        this.edNameFan = (EditText) findViewById(R.id.edNameFan);
        this.edSenhaUsuario = (EditText) findViewById(R.id.edSenhaUsuario);

        RegisterMethods.addRegister(
                this,
                this.edEmail.getText().toString(),
                this.edNameUsr.getText().toString(),
                this.edNameFan.getText().toString(),
                this.edSenhaUsuario.getText().toString()
        );

    }

}
