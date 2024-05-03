import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import junit.framework.TestCase;


import es.ifp.opotest.Funciones;

public class OpoTestTest extends TestCase {


    /*public void testAdmin() {
        Funciones ra = new Funciones();
        boolean res = ra.admin("admin", "admin");
        assertEquals(true, res);

    }


    public void testCampos() {
        Funciones ra = new Funciones();
        boolean res = ra.campos("adri", "adri@gmail.com", "1234", "1234", "888888888", true, false, true);
        assertEquals(true, res);

    }


    public void testContrasena() {
        Funciones ra = new Funciones();
        boolean res = ra.contrasena("paco", "paco");
        assertEquals(true, res);
    }*/




    public void testResultado(){
        Funciones ra = new Funciones();
        boolean res = Boolean.parseBoolean(ra.resultado(2, 4));
        assertEquals(false, res);
    }



}