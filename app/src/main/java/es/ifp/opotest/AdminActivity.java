package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText label2;
    protected EditText label3;
    protected EditText label4;
    protected EditText label5;
    protected Button boton1;
    protected Button boton2;
    protected DataBaseSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        db = new DataBaseSQL(this);

        label1 = (TextView) findViewById(R.id.label1_admin);
        label2 = (EditText) findViewById(R.id.label2_admin);
        label3 = (EditText) findViewById(R.id.label3_admin);
        label4 = (EditText) findViewById(R.id.label4_admin);
        label5 = (EditText) findViewById(R.id.label5_admin);
        boton1 = (Button) findViewById(R.id.boton1_admin);
        boton2 = (Button) findViewById(R.id.boton2_admin);



        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String enunciado = String.valueOf(label2.getText());
                String opcion1= String.valueOf(label3.getText());
                String opcion2 = String.valueOf(label4.getText());
                String opcionCorrecta = String.valueOf(label5.getText());

                db.crearPregunta(enunciado, opcion1, opcion2, opcionCorrecta);
                Intent pasarPantalla = new Intent(AdminActivity.this, AdminActivity.class);
                finish();
                startActivity(pasarPantalla);

            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pasarPantalla = new Intent(AdminActivity.this, StartActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

    }
}