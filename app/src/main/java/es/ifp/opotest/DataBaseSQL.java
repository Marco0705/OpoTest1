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

        public boolean oposiciones(String nombreOposicion){

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO oposiciones (nombreOposicion) VALUES ('" + nombreOposicion + "')");
            return true;
        }

        public boolean crearPregunta(String enunciado, String opcion1, String opcion2, String opcionCorrecta){

            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "INSERT INTO preguntas (oposicionesId, enunciado, opcion1, opcion2, opcionCorrecta) VALUES (1, ?, ?,?, ?)";
            db.execSQL(sql, new String[]{enunciado, opcion1, opcion2, opcionCorrecta});
            return true;
        }


        public ArrayList<String> getAllAudios(){

            ArrayList<String> audios = new ArrayList<String>();

            Cursor res = null;
            SQLiteDatabase db = this.getReadableDatabase();
            res = db.rawQuery("SELECT * FROM media", null);

            res.moveToLast();
            if(res.getCount() > 0){

                res.moveToFirst();
                while(!res.isAfterLast()){
                    audios.add(res.getString(0) + ". " + res.getString(1));
                    res.moveToNext();
                }

            }
            return audios;
        }

        public String obtenerTitulo(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("SELECT titulo FROM media WHERE id = ?", new String[]{String.valueOf(id)});
            String titulo = "";
            if (res.moveToFirst()) {
                titulo = res.getString(0);
            }
            res.close();
            db.close();
            return titulo;
        }

        public String obtenerUrl(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("SELECT url FROM media WHERE id = ?", new String[]{String.valueOf(id)});
            String url = "";
            if (res.moveToFirst()) {
                url = res.getString(0);
            }
            res.close();
            db.close();
            return url;
        }


        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

