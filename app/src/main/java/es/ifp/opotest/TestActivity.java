package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    protected TextView label1;
    protected TextView label2;
    protected TextView label3;
    protected TextView label4;
    protected TextView label5;
    protected TextView label6;
    protected Button boton1;
    protected Button boton2;
    protected RadioButton radio1;
    protected RadioButton radio2;

    protected RadioButton radio3;

    protected RadioButton radio4;

    protected RadioButton radio5;

    protected RadioButton radio6;

    protected RadioButton radio7;

    protected RadioButton radio8;

    protected RadioButton radio9;

    protected RadioButton radio10;

    protected RadioButton radio11;

    protected RadioButton radio12;

    protected DataBaseSQL db;

    protected String opcionCorrecta;

    protected int numAciertos = 0;

    protected int numFallos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        db = new DataBaseSQL(this);

        label1 = (TextView) findViewById(R.id.label1_test);
        label2 = (TextView) findViewById(R.id.label2_test);
        label3 = (TextView) findViewById(R.id.label3_test);
        label4 = (TextView) findViewById(R.id.label4_test);
        label5 = (TextView) findViewById(R.id.label5_test);
        label6 = (TextView) findViewById(R.id.label6_test);

        boton1 = (Button) findViewById(R.id.boton1_test);
        boton2 = (Button) findViewById(R.id.boton2_test);

        radio1 = (RadioButton) findViewById(R.id.radio1_test);
        radio2 = (RadioButton) findViewById(R.id.radio2_test);
        radio3 = (RadioButton) findViewById(R.id.radio3_test);
        radio4 = (RadioButton) findViewById(R.id.radio4_test);
        radio5 = (RadioButton) findViewById(R.id.radio5_test);
        radio6 = (RadioButton) findViewById(R.id.radio6_test);
        radio7 = (RadioButton) findViewById(R.id.radio7_test);
        radio8 = (RadioButton) findViewById(R.id.radio8_test);
        radio9 = (RadioButton) findViewById(R.id.radio9_test);
        radio10 = (RadioButton) findViewById(R.id.radio10_test);
        radio11 = (RadioButton) findViewById(R.id.radio11_test);
        radio12 = (RadioButton) findViewById(R.id.radio12_test);

        label1.setText(db.enunciado(1));
        radio1.setText(db.opcion1(1));
        radio2.setText(db.opcion2(1));

        label2.setText(db.enunciado(2));
        radio3.setText(db.opcion1(2));
        radio4.setText(db.opcion2(2));

        label3.setText(db.enunciado(3));
        radio5.setText(db.opcion1(3));
        radio6.setText(db.opcion2(3));

        label4.setText(db.enunciado(4));
        radio7.setText(db.opcion1(4));
        radio8.setText(db.opcion2(4));

        label5.setText(db.enunciado(5));
        radio9.setText(db.opcion1(5));
        radio10.setText(db.opcion2(5));

        label6.setText(db.enunciado(6));
        radio11.setText(db.opcion1(6));
        radio12.setText(db.opcion2(6));



        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                opcionCorrecta = db.opcionCorrecta(1);


                if (radio1.isChecked()) {

                    if (radio1.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }
                if (radio2.isChecked()) {

                    if (radio2.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }



                opcionCorrecta = db.opcionCorrecta(2);


                if (radio3.isChecked()) {

                    if (radio3.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }
                if (radio4.isChecked()) {

                    if (radio4.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }


                opcionCorrecta = db.opcionCorrecta(3);


                if (radio5.isChecked()) {

                    if (radio5.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }
                if (radio6.isChecked()) {

                    if (radio6.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }



                opcionCorrecta = db.opcionCorrecta(4);


                if (radio7.isChecked()) {

                    if (radio7.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }
                if (radio8.isChecked()) {

                    if (radio8.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }



                opcionCorrecta = db.opcionCorrecta(5);


                if (radio9.isChecked()) {

                    if (radio9.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }
                if (radio10.isChecked()) {

                    if (radio10.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }



                opcionCorrecta = db.opcionCorrecta(6);


                if (radio11.isChecked()) {

                    if (radio11.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }
                if (radio12.isChecked()) {

                    if (radio12.getText().toString().equals(opcionCorrecta)) {
                        numAciertos++;


                    } else {
                        numFallos++;
                    }
                }

                Intent pasarPantalla = new Intent(TestActivity.this, ResultadoActivity.class);
                finish();
                startActivity(pasarPantalla);

            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pasarPantalla = new Intent(TestActivity.this, ComenzarActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });


    }
}