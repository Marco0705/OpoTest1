package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IniciarActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText label2;
    protected EditText label3;
    protected Button boton1;
    protected Button boton2;
    protected DataBaseSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);

        db = new DataBaseSQL(this);

        label1 = (TextView) findViewById(R.id.label1_inciar);
        label2 = (EditText) findViewById(R.id.label2_iniciar);
        label3 = (EditText) findViewById(R.id.label3_inciar);
        boton1 = (Button) findViewById(R.id.boton1_iniciar);
        boton2 = (Button) findViewById(R.id.boton2_iniciar);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = label2.getText().toString();
                String pass = label3.getText().toString();

                if (usuario.equals("admin") && pass.equals("admin") ){

                    Intent pasarPantalla1 = new Intent(IniciarActivity.this, AdminActivity.class);
                    finish();
                    startActivity(pasarPantalla1);
                    Toast.makeText(IniciarActivity.this, "OKKKKKKKK", Toast.LENGTH_SHORT).show();

                }
                else{
                    if(db.usuarioExiste(label2.getText().toString())){
                        if(db.password(label2.getText().toString(), label3.getText().toString())){
                            Intent pasarPantalla = new Intent(IniciarActivity.this, ComenzarActivity.class);
                            finish();
                            startActivity(pasarPantalla);
                        }
                        else {
                            Toast.makeText(IniciarActivity.this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(IniciarActivity.this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                    }

                }
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