package com.example.felipesavaris.helpmeautoajuda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText edEmail, edNameUsr, edNameFan, edSenhaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }



}
