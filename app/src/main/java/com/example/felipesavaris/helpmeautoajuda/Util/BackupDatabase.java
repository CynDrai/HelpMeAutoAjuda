package com.example.felipesavaris.helpmeautoajuda.Util;

import android.annotation.TargetApi;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;

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

        //Diretório Personalizado
        final String DIR = "/backupsHMAA";
        File folder = new File(Environment.getExternalStorageDirectory() + DIR);
        if(!folder.exists()) {
            folder.mkdir();
        }

        try {
            // Caminho de Origem do Seu Banco de Dados
            InputStream in = new FileInputStream(
                    new File(Environment.getDataDirectory()
                            + "/data/com.example.felipesavaris.helpmeautoajuda/databases/dbHMAA"));

            // Caminho de Destino do Backup do Seu Banco de Dados
            OutputStream out = new FileOutputStream(new File(
                    Environment.getExternalStorageDirectory()
                            + DIR + "/backupHMAA " +
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

            ToastMakeText.makeText(
                    context,
                    "Backup Realizado com sucesso"
            );

        } catch (FileNotFoundException e) {

            ToastMakeText.makeText(
                    context,
                    "Falha no Backup, é necessario permissão ou " +
                            "diretório não encontrado!"
            );

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
