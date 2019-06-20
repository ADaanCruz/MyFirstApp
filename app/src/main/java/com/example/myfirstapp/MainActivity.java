package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    EditText etNombre, etEdad, etCorreo;
    Button btnAceptar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.textView_title_main);
        etNombre = findViewById(R.id.editText_name_main);
        etEdad = findViewById(R.id.editText_years_main);
        etCorreo = findViewById(R.id.editText_email_main);
        btnAceptar = findViewById(R.id.button_aceptar_main);
        btnSalir = findViewById(R.id.button_salir_main);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String edad = etEdad.getText().toString();
                String correo = etCorreo.getText().toString();

                if (!(nombre.trim().equals("")) && !(edad.trim().equals("")) && !(correo.trim().equals(""))){
                    if (correo.contains("@")) {
                        Intent intent = new Intent(v.getContext(), SecondActivity.class);
                        intent.putExtra("nombre", nombre);
                        intent.putExtra("edad", edad);
                        intent.putExtra("correo", correo);

                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this,
                                "Ingresa un correo válido",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this,
                            "Completa correctamente los campos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
