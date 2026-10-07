package com.example.proyectomovil;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtalle);

        // 1. Encontrar el TextView en tu diseño XML
        TextView tvDetalle = findViewById(R.id.tvDetalle);

        // 2. Capturar el mensaje enviado desde MainActivity
        String mensaje = getIntent().getStringExtra("EXTRA_MENSAJE");

        // 3. Mostrar el mensaje en la pantalla si el TextView no es nulo
        if (mensaje != null && tvDetalle != null) {
            tvDetalle.setText(mensaje);
        }
    }
}