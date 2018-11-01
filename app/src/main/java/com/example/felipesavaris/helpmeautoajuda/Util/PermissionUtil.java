package com.example.felipesavaris.helpmeautoajuda.Util;

import android.Manifest;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;

public class PermissionUtil {

    //Método para Requisitar a Permissão WRITE_EXTERNAL_STORAGE
    public static void callWriteOnSDCard(
            Activity activity,
            final int REQUEST_PERMISSIONS_CODE) {

        //Mensagem da permissão
        ActivityCompat.requestPermissions(
                activity,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_PERMISSIONS_CODE
        );
    }
}
