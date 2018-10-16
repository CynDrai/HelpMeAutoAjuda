package com.example.felipesavaris.helpmeautoajuda.Util;

import android.content.Context;
import android.widget.Toast;

public class ToastMakeText {

    public static void makeText(Context context, String str) {

        //Toast Genérico para todas as classes
        Toast.makeText(
                context,
                str,
                Toast.LENGTH_LONG)
        .show();

    }
}