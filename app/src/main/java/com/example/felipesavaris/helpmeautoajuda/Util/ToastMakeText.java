package com.example.felipesavaris.helpmeautoajuda.Util;

import android.content.Context;
import android.widget.Toast;

public class ToastMakeText {

    public static void makeText(Context context,
                                String message) {

        //Toast Genérico para todas as classes
        Toast.makeText(
                context,
                message,
                Toast.LENGTH_LONG)
        .show();

    }
}