package com.eviltest.utility;

import java.io.FileWriter;
import java.io.PrintWriter;

public  class Utility {

    public static void guardarUsuario(String usuario)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("utility/usuarios/usuario_validos",true);
            pw = new PrintWriter(fichero);

            pw.println(usuario);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    private static void sleep(int timeout){
        try{
            Thread.sleep(timeout);
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }

    }
}
