package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    protected DataBaseSQL db;
    private Bundle extras;
    protected TextView label1;
    protected TextView label2;
    protected Button boton1;
    protected Button boton2;
    protected int paquete1;
    protected int paquete2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        db = new DataBaseSQL(this);
        label1 = (TextView) findViewById(R.id.label1_resultado);
        label2 = (TextView) findViewById(R.id.label2_resultado);
        boton1 = (Button) findViewById(R.id.boton1_resultado);
        boton2 = (Button) findViewById(R.id.boton2_resultado);

        extras=getIntent().getExtras();
        if(extras!=null){
            paquete1=extras.getInt("NUMACIERTOS");
            paquete2=extras.getInt("NUMFALLOS");
            label1.setText(String.valueOf("Respuestas correctas: " + paquete1));
            label2.setText(String.valueOf("Respuestas incorrectas: " + paquete2));
        }else{
            Toast.makeText(this, "Error al pasar el paquete", Toast.LENGTH_SHORT).show();
        }

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasarPantalla = new Intent(ResultadoActivity.this, TestActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }
}
