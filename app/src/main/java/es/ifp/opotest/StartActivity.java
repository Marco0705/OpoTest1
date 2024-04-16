package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    protected TextView label1;
    protected Button boton1;
    protected Button boton2;
    protected DataBaseSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBaseSQL(this);

        label1 = (TextView) findViewById(R.id.label1_start);
        boton1 = (Button) findViewById(R.id.boton1_start);
        boton2 = (Button) findViewById(R.id.boton2_start);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pasarPantalla = new Intent(StartActivity.this, RegistroActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pasarPantalla = new Intent(StartActivity.this, IniciarActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

    }
}