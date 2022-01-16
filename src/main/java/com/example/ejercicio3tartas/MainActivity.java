package com.example.ejercicio3tartas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edad;
    EditText nbr, ap;
    RadioButton hombre, mujer;
    CheckBox caja;
    EditText nombreConcurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edad = findViewById(R.id.edad);
        btn = findViewById(R.id.btn);
        nbr = findViewById(R.id.nbr);
        ap = findViewById(R.id.ap);
        hombre = findViewById(R.id.hombre);
        mujer = findViewById(R.id.mujer);
        caja = findViewById(R.id.caja);
        nombreConcurso = findViewById(R.id.nombreConcurso);
        caja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caja.isChecked()) {
                    nombreConcurso.setVisibility(View.VISIBLE);
                } else {
                    nombreConcurso.setVisibility(View.INVISIBLE);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed = edad.getText().toString();
                int ed1 = 0;
                try {
                    ed1 = Integer.parseInt(ed);
                } catch (Exception e) {
                    //Error a la hora de inscribirse sin rellenar la edad o dejar en blanco la aplicacion.
                }
                String nombre = nbr.getText().toString();
                String apellido = ap.getText().toString();

                if (nombre.equals("") || apellido.equals("") || ed1 == 0 || (caja.isChecked() && nombreConcurso.getText().toString().equals(""))) {
                    Toast.makeText(MainActivity.this, "Faltan campos por rellenar, revise el formulario, gracias. ", Toast.LENGTH_SHORT).show();
                } else if (ed1 < 18) {
                    Toast.makeText(MainActivity.this, "No puedes participar siendo menor. ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Te has inscrito correctamente " + nombre + ", gracias.  ", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}