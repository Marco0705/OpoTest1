package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ComenzarActivity extends AppCompatActivity {

    protected DataBaseSQL db;
    protected TextView label1;
    protected Button boton1;
    protected Button boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comenzar);

        db = new DataBaseSQL(this);
        label1= (TextView) findViewById(R.id.label1_comenzar);
        boton1= (Button) findViewById(R.id.boton1_comenzar);
        boton2= (Button) findViewById(R.id.boton2_comenzar);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pasarPantalla = new Intent(ComenzarActivity.this, TestActivity.class);
                finish();
                startActivity(pasarPantalla);



            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pasarPantalla = new Intent(ComenzarActivity.this, StartActivity.class);
                finish();
                startActivity(pasarPantalla);

            }
        });


    }
}