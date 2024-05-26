package es.ifp.opotest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;



    public class DataBaseSQL extends SQLiteOpenHelper {

        public DataBaseSQL(@Nullable Context context) {
            super(context, "opotest", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE usuarios(usuariosId integer PRIMARY KEY AUTOINCREMENT NOT NULL, oposicionesId INTEGER, nombre TEXT, email TEXT, contraseña TEXT, tipoPlan TEXT, nCuenta TEXT, foreign key(oposicionesId) references oposiciones(oposicionesId))");
            db.execSQL("CREATE TABLE oposiciones(oposicionesId integer PRIMARY KEY AUTOINCREMENT NOT NULL, nombreOposicion TEXT)");
            db.execSQL("CREATE TABLE preguntas(preguntasId integer PRIMARY KEY AUTOINCREMENT NOT NULL, oposicionesId INTEGER, enunciado TEXT, opcion1 TEXT, opcion2 TEXT, opcionCorrecta TEXT, foreign key(oposicionesId) references oposiciones(oposicionesId))");

        }

        public boolean crearUsuario(String nombre, String email, String contraseña, String tipoPlan, String nCuenta){

            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "INSERT INTO usuarios (oposicionesId, nombre, email, contraseña, tipoPlan, nCuenta) VALUES (1, ?, ?,?, ?, ?)";
            db.execSQL(sql, new String[]{nombre, email, contraseña, tipoPlan, nCuenta});
            return true;
        }

        public boolean usuarioExiste(String nombreUsuario) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM  usuarios  WHERE  email   = ?",
                    new String[]{nombreUsuario});
            boolean existe = cursor.getCount() > 0;
            cursor.close();
            return existe;
        }

        public boolean password(String nombreUsuario, String contraseñaIntroducida) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT contraseña FROM  usuarios  WHERE  email = ?",
                    new String[]{nombreUsuario});

            boolean existe = false;

            if (cursor.moveToFirst()) {
                // Obtiene la contraseña almacenada en la base de datos
                String contraseñaAlmacenada = cursor.getString(cursor.getColumnIndex("contraseña"));

                // Compara la contraseña almacenada con la contraseña introducida por el usuario
                existe = contraseñaAlmacenada.equals(contraseñaIntroducida);
            }
            return existe;
        }

        public boolean oposiciones(String nombreOposicion){

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO oposiciones (nombreOposicion) VALUES ('" + nombreOposicion + "')");
            return true;
        }

        public void crearPregunta(){

            String enunciado = "";
            String opcion1 = "";
            String opcion2 = "";
            String opcionCorrecta = "";

            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "INSERT INTO preguntas (oposicionesId, enunciado, opcion1, opcion2, opcionCorrecta) VALUES (1, ?, ?,?, ?)";
             enunciado = "¿Para qué se usa el dispositivo ASAP LOCK de la marca PETZL?";
             opcion1 = "Como anticaídas deslizante para cuerda con función de bloqueo.";
             opcion2 = "Como polifreno en el que la polea tiene incorporado un bloqueador.";
             opcionCorrecta = "Como anticaídas deslizante para cuerda con función de bloqueo.";
            db.execSQL(sql, new String[]{enunciado, opcion1, opcion2, opcionCorrecta});

            enunciado = "¿Cuantos manorreductores son necesarios para trabajar con dos cojines de alta presión con \n" +
                    "consola simultáneamente?";
            opcion1 = "2";
            opcion2 = "1";
            opcionCorrecta = "1";
            db.execSQL(sql, new String[]{enunciado, opcion1, opcion2, opcionCorrecta});

            enunciado = "La ruptura del cinturón térmico de una inversión térmica se produce.";
            opcion1 = "A media mañana, cuando se calienta más el fondo del valle.";
            opcion2 = "Por la noche a medida que el aire cercano al suelo se enfría más rápido que el de capas \n" +
                    "superiores.";
            opcionCorrecta = "A media mañana, cuando se calienta más el fondo del valle.";
            db.execSQL(sql, new String[]{enunciado, opcion1, opcion2, opcionCorrecta});

            enunciado = "Cuando hablamos del Hosemaster nos referimos a:";
            opcion1 = "Un equipo de espuma contraincendios.";
            opcion2 =  "Un equipo para excarcelación.";
            opcionCorrecta = "Un equipo de espuma contraincendios.";
            db.execSQL(sql, new String[]{enunciado, opcion1, opcion2, opcionCorrecta});

            enunciado = "¿Cómo denominamos a las poleas móviles cuando las utilizamos en un polipasto?";
            opcion1 = "Palancas de primera clase.";
            opcion2 =  "Palancas de segunda clase.";
            opcionCorrecta = "Palancas de segunda clase.";
            db.execSQL(sql, new String[]{enunciado, opcion1, opcion2, opcionCorrecta});

            enunciado = "¿Es obligatorio que un ascensor disponga de una comunicación en cabina con el exterior?";
            opcion1 = "Solo es obligatorio para ascensores de 4 o más personas. ";
            opcion2 =  " Sí es obligatorio desde 1999.";
            opcionCorrecta = " Sí es obligatorio desde 1999.";
            db.execSQL(sql, new String[]{enunciado, opcion1, opcion2, opcionCorrecta});


        }

        public String enunciado(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("SELECT enunciado FROM preguntas WHERE preguntasId = ?", new String[]{String.valueOf(id)});
            String enunciado = "";
            if (res.moveToFirst()) {
                enunciado = res.getString(0);
            }
            res.close();
            db.close();
            return enunciado;
        }

        public String opcion1(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("SELECT opcion1 FROM preguntas WHERE preguntasId = ?", new String[]{String.valueOf(id)});
            String opcion1 = "";
            if (res.moveToFirst()) {
                opcion1 = res.getString(0);
            }
            res.close();
            db.close();
            return opcion1;
        }

        public String opcion2(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("SELECT opcion2 FROM preguntas WHERE preguntasId = ?", new String[]{String.valueOf(id)});
            String opcion2 = "";
            if (res.moveToFirst()) {
                opcion2 = res.getString(0);
            }
            res.close();
            db.close();
            return opcion2;
        }

        public String opcionCorrecta(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("SELECT opcionCorrecta FROM preguntas WHERE preguntasId = ?", new String[]{String.valueOf(id)});
            String opcionCorrecta = "";
            if (res.moveToFirst()) {
                opcionCorrecta = res.getString(0);
            }
            res.close();
            db.close();
            return opcionCorrecta;
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }


    }

