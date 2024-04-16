package es.ifp.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ComenzarActivity extends AppCompatActivity {

    protected DataBaseSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comenzar);

        db = new DataBaseSQL(this);
    }
}