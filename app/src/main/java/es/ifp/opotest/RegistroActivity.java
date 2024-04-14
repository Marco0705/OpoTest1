package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegistroActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText label2;
    protected EditText label3;
    protected EditText label4;
    protected EditText label5;
    protected TextView label6;
    protected EditText label7;
    protected RadioButton radio1;
    protected RadioButton radio2;
    protected CheckBox check1;
    protected Button boton1;
    protected Button boton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        label1 = (TextView) findViewById(R.id.label1_registro);
        label2 = (EditText) findViewById(R.id.label2_registro);
        label3 = (EditText) findViewById(R.id.label3_registro);
        label4 = (EditText) findViewById(R.id.label4_registro);
        label5 = (EditText) findViewById(R.id.label5_registro);
        label6 = (TextView) findViewById(R.id.label6_registro);
        label7 = (EditText) findViewById(R.id.label7_registro);
        radio1 = (RadioButton) findViewById(R.id.radio1_registro);
        radio2 = (RadioButton) findViewById(R.id.radio2_registro);
        check1 = (CheckBox) findViewById(R.id.check1_registro);
        boton1 = (Button) findViewById(R.id.boton1_registro);
        boton2 = (Button) findViewById(R.id.boton2_registro);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pasarPantalla = new Intent(RegistroActivity.this, IniciarActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pasarPantalla = new Intent(RegistroActivity.this, StartActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

    }
}