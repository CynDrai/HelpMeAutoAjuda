package com.example.felipesavaris.helpmeautoajuda.Database;

import android.annotation.TargetApi;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class BackupDatabase {

    //ATENÇÃO, ESSA CLASSE SERVIRÁ APENAS ENQUANTO O DESENVOLVIMENTO
    //ESTIVER ACONTECENDO, SENDO APAGADA AO FIM, VISTO QUE AINDA
    //NÃO HÁ UM CONTROLE DE BACKUP DE BANCO DE DADOS AINDA

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void backupDatabase(Context context) {

        Calendar c = Calendar.getInstance();

        try {
            // Caminho de Origem do Seu Banco de Dados
            InputStream in = new FileInputStream(
                    new File(Environment.getDataDirectory()
                            + "/data/com.example.felipesavaris.helpmeautoajuda/databases/dbHMAA"));

            // Caminho de Destino do Backup do Seu Banco de Dados
            OutputStream out = new FileOutputStream(new File(
                    Environment.getExternalStorageDirectory()
                            + "/backups/backupHMAA " +
                            c.get(Calendar.DAY_OF_MONTH) + "." +
                            c.get(Calendar.MONTH) + "." +
                            c.get(Calendar.YEAR) + "_" +
                            c.get(Calendar.HOUR_OF_DAY) + ":" +
                            c.get(Calendar.MINUTE) + ":" +
                            c.get(Calendar.SECOND) +
                            ".db"));

            byte[] buff = new byte[1024];
            int len;
            while ((len = in.read(buff)) > 0) {
                out.write(buff, 0, len);
            }

            in.close();
            out.close();

            Toast.makeText(
                    context,
                    "Backup Realizado com sucesso",
                    Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {

            Toast.makeText(
                    context,
                    "Falha no Backup, é necessario permissão ou " +
                            "diretório não encontrado!",
                    Toast.LENGTH_LONG).show();

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
