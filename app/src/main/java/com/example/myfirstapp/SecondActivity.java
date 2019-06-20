package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvTitle, tvNombre, tvEdad, tvCorreo;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvTitle = findViewById(R.id.textView_title_second);
        tvNombre = findViewById(R.id.textView_nombre_second);
        tvEdad = findViewById(R.id.textView_edad_second);
        tvCorreo = findViewById(R.id.textView_correo_second);
        btnRegresar = findViewById(R.id.button_regresar_second);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            String textNombre = tvNombre.getText() + ": " + bundle.getString("nombre", "sin nombre");
            String textEdad = tvEdad.getText() + ": " + bundle.getString("edad", "sin edad");
            String textCorreo = tvCorreo.getText() + ": " + bundle.getString("correo", "sin correo");

            tvNombre.setText(textNombre);
            tvEdad.setText(textEdad);
            tvCorreo.setText(textCorreo);
        }

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
