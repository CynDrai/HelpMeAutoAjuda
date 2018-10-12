package com.example.felipesavaris.helpmeautoajuda.Util;

import java.util.Random;

public class GeneratorID {

    public static long returnID() {
        //Gerador de ID's manual para novos Registros de usuários
        String codigo = "";
        String[] id_ran = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        Random random = new Random();
        for(int i = 0; i < 16; i++) {
            codigo += id_ran[random.nextInt(id_ran.length)];
        }

        return (Long.parseLong(codigo));
    }

}
