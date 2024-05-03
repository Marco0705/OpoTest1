package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    protected RadioGroup radioG;
    protected CheckBox check1;
    protected Button boton1;
    protected Button boton2;
    protected DataBaseSQL db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = new DataBaseSQL(this);

        Funciones f= new Funciones();

        label1 = (TextView) findViewById(R.id.label1_registro);
        label2 = (EditText) findViewById(R.id.label2_registro);
        label3 = (EditText) findViewById(R.id.label3_registro);
        label4 = (EditText) findViewById(R.id.label4_registro);
        label5 = (EditText) findViewById(R.id.label5_registro);
        label6 = (TextView) findViewById(R.id.label6_registro);
        label7 = (EditText) findViewById(R.id.label7_registro);
        radio1 = (RadioButton) findViewById(R.id.radio1_registro);
        radio2 = (RadioButton) findViewById(R.id.radio2_registro);
        radioG = (RadioGroup) findViewById(R.id.radioGroup_registro);
        check1 = (CheckBox) findViewById(R.id.check1_registro);
        boton1 = (Button) findViewById(R.id.boton1_registro);
        boton2 = (Button) findViewById(R.id.boton2_registro);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = String.valueOf(label2.getText());
                String email = String.valueOf(label3.getText());
                String pass1 = String.valueOf(label4.getText());
                String pass2 = String.valueOf(label5.getText());
                String cuenta = String.valueOf(label6.getText());


                if (!f.campos(nombre, email, pass1, pass2, cuenta, radio1.isChecked(), radio2.isChecked(), check1.isChecked())) {

                    Toast.makeText(RegistroActivity.this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();


                } else {

                    String plan = "";

                    if (radio1.isChecked()) {

                        plan = "Plan mensual";
                    } else if (radio2.isChecked()) {

                        plan = "Plan anual";
                    }


                    if (f.contrasena(pass1, pass2)) {

                        db.crearUsuario(nombre, email, pass1, plan, cuenta);
                        Intent pasarPantalla = new Intent(RegistroActivity.this, IniciarActivity.class);
                        finish();
                        startActivity(pasarPantalla);


                    } else {

                        Toast.makeText(RegistroActivity.this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                    }


                }
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