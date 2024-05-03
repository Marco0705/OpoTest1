package es.ifp.opotest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class Funciones {


    public boolean contrasena(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        return false;


    }
    public boolean campos(String nombre, String email, String pass1, String pass2, String cuenta, boolean radio1, boolean radio2, boolean check1){
        if (nombre.equals("") || email.equals("") || pass1.equals("") || pass2.equals("") || cuenta.equals("") || ((!radio1 && !radio2)) || !check1) {
            return false;
        }
        return true;

    }
    public boolean admin(String a, String b){
        if(a.equals("admin")&& b.equals("admin")){
            return true;

        }
        return false;

    }
    public String resultado(int a, int b){
        if(a > b){

            return "Aprobado";
        }
        else{
            return "Suspendido";
        }

    }




}
