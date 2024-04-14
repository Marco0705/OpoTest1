package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IniciarActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText label2;
    protected EditText label3;
    protected Button boton1;
    protected Button boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);

        label1 = (TextView) findViewById(R.id.label1_inciar);
        label2 = (EditText) findViewById(R.id.label2_iniciar);
        label3 = (EditText) findViewById(R.id.label3_inciar);
        boton1 = (Button) findViewById(R.id.boton1_iniciar);
        boton2 = (Button) findViewById(R.id.boton2_iniciar);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // INCIAR SESION

                Intent pasarPantalla = new Intent(IniciarActivity.this, ComenzarActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pasarPantalla = new Intent(IniciarActivity.this, StartActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

    }
}