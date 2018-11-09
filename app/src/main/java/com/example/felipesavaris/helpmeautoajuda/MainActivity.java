package com.example.felipesavaris.helpmeautoajuda;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.felipesavaris.helpmeautoajuda.Model.Professional;
import com.example.felipesavaris.helpmeautoajuda.Model.Usuario;
import com.example.felipesavaris.helpmeautoajuda.Util.BackupDatabase;
import com.example.felipesavaris.helpmeautoajuda.Util.PermissionUtil;
import com.example.felipesavaris.helpmeautoajuda.logicMethods.LoginMethods;

public class MainActivity extends AppCompatActivity {

    private EditText edEmailUsuario, edSenhaUsuario;

    public final int REQUEST_PERMISSIONS_CODE = 128;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Controle de Logo na Barra do Aplicativo
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //Checa se o sistema já tem a permissão
        int permission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        );

        //Se não houver a permissão
        if(permission == -1) {
            PermissionUtil.callWriteOnSDCard(
                    this,
                    REQUEST_PERMISSIONS_CODE
            );
        }
    }

    //Botão Login
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loginBt(View view) {

        //Inicialização dos EditText
        this.edEmailUsuario = (EditText) findViewById(R.id.edEmailUsuario);
        this.edSenhaUsuario = (EditText) findViewById(R.id.edSenhaUsuario);

        LoginMethods loginMethods = new LoginMethods();

        //Dados do usuário após Login bem sucedido
        Usuario.setUsuarioUnico(loginMethods.loginAccount(
                this,
                this.edEmailUsuario.getText().toString(),
                this.edSenhaUsuario.getText().toString())
        );

        //Checa se o sistema já tem a permissão
        int permission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        );

        //Caso o Login seja do Usuário
        if (Usuario.getUsuarioUnico() != null) {

            //Se houver a permissão, o backup será realizado
            if(permission == 0) {
                //Backup Banco de Dados
                BackupDatabase.backupDatabase(this);
            }

            //Mudança de Activity --> CategoriaActivity
            Intent it = new Intent(
                    this,
                    CategoriaActivity.class
            );
            startActivity(it);
        }

        //Caso o Login seja do Profissional
        if(Professional.getProfessionalUnico() != null) {

            //Se houver a permissão, o backup será realizado
            if(permission == 0) {
                //Backup Banco de Dados
                BackupDatabase.backupDatabase(this);
            }

            //Mudança de Activity --> ProfessionalActivity
            Intent it = new Intent(
                      this,
                    ProfessionalActivity.class
            );
            startActivity(it);
        }
    }

    //Botão Cadastro
    public void cadastroBt(View view) {

        //Mudança de Activity --> CadastroActivity
        Intent it = new Intent(
                this,
                CadastroActivity.class
        );
        startActivity(it);
    }
}
