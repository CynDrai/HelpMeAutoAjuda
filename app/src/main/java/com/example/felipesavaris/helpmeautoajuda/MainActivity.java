package com.example.felipesavaris.helpmeautoajuda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginBt (View view) {
        Toast.makeText(
                this,
                "Método não suportado ainda",
                Toast.LENGTH_LONG).show();
    }

    public void cadastroBt (View view) {

        //Mudança de Activity --> CadastroActivity
        Intent it = new Intent(
                this,
                CadastroActivity.class);

        startActivity(it);
    }
    
}
