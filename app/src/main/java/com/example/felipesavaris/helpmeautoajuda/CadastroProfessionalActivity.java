package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.felipesavaris.helpmeautoajuda.Util.ToastMakeText;
import com.example.felipesavaris.helpmeautoajuda.logicMethods.RegisterMethods;

public class CadastroProfessionalActivity extends AppCompatActivity {

    private EditText edEmailProfessional, edNameProfessional, edFicNameProfessional,
    edCpfProfessional, edCnpjCompany, edAddress, edFone, edPasswordProfessional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professional);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cadastro Profissional");
    }

    //Botão Cadastro Profissional
    public void cadastroProfessionalBt(View view) {

        //Inicialização dos EditText
        this.edEmailProfessional = (EditText) findViewById(R.id.edEmailProfessional);
        this.edNameProfessional = (EditText) findViewById(R.id.edNameProfessional);
        this.edFicNameProfessional = (EditText) findViewById(R.id.edFicNameProfessional);
        this.edCpfProfessional = (EditText) findViewById(R.id.cpfProfessional);
        this.edCnpjCompany = (EditText) findViewById(R.id.cnpjCompany);
        this.edAddress = (EditText) findViewById(R.id.address);
        this.edFone = (EditText) findViewById(R.id.fone);
        this.edPasswordProfessional = (EditText) findViewById(R.id.passwordProfessional);

        RegisterMethods rm = new RegisterMethods();

        boolean boo;

        //Método de Cadastro Profissional
        boo = rm.addRegisterProfessional(
                this,
                this.edEmailProfessional.getText().toString(),
                this.edNameProfessional.getText().toString(),
                this.edFicNameProfessional.getText().toString(),
                this.edCpfProfessional.getText().toString(),
                this.edCnpjCompany.getText().toString(),
                this.edAddress.getText().toString(),
                this.edFone.getText().toString(),
                this.edPasswordProfessional.getText().toString()
        );

        if (boo) {

            ToastMakeText.makeText(
                    this,
                    "Cadastro efetuado com sucesso!"
            );

            //Mudança de Activity --> MainActivity
            Intent it = new Intent(
                    this,
                    MainActivity.class
            );

            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(it);

        }
    }
}
