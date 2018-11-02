package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.felipesavaris.helpmeautoajuda.logicMethods.RegisterMethods;

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

        RegisterMethods registerMethods = new RegisterMethods();
        boolean boo;

        //Resultado do Registro
        boo = registerMethods.addRegister(
                this,
                this.edEmail.getText().toString(),
                this.edNameUsr.getText().toString(),
                this.edNameFan.getText().toString(),
                this.edSenhaUsuario.getText().toString()
        );

        //Mudança de Activity --> MainActivity
        if(boo) {
            Intent it = new Intent(
                    this,
                    MainActivity.class
            );
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(it);
        }
    }

    //Botão Serial
    public void serialBt(View view) {

        //Mudança de Activity --> CadastroProfessionalActivity
        Intent it = new Intent(
                this,
                CadastroProfessionalActivity.class
        );
        startActivity(it);
    }
}
