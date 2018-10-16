package com.example.felipesavaris.helpmeautoajuda.Util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionUtil {

    //Método para Requisitar a Permissão WRITE_EXTERNAL_STORAGE
    public static void callWriteOnSDCard(
            Activity activity,
            Context context,
            final int REQUEST_PERMISSIONS_CODE) {

        //Checa se já tem a permissão
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {

            //Verifica se há a necessidade de mostrar a mensagem
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                //Mensagem da permissão
                ActivityCompat.requestPermissions(
                        activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_PERMISSIONS_CODE);
            }
        }
    }
}
