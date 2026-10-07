package com.example.proyectomovil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- 1. INTENTS EXPLÍCITOS (3 obligatorios) ---
        Button btnEx1 = findViewById(R.id.btnExplicito1);
        Button btnEx2 = findViewById(R.id.btnExplicito2);
        Button btnEx3 = findViewById(R.id.btnExplicito3);

        // Ir a DetalleActivity enviando datos extra
        btnEx1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
            intent.putExtra("EXTRA_MENSAJE", "Hola desde el MainActivity principal");
            startActivity(intent);
            
        });

        // Ir a ConfigActivity
        btnEx2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
            startActivity(intent);
        });

        // Ir a AyudaActivity
        btnEx3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AyudaActivity.class);
            startActivity(intent);
        });

        // --- 2. INTENTS IMPLÍCITOS (5 obligatorios) ---
        Button btnImp1 = findViewById(R.id.btnImplicito1);
        Button btnImp2 = findViewById(R.id.btnImplicito2);
        Button btnImp3 = findViewById(R.id.btnImplicito3);
        Button btnImp4 = findViewById(R.id.btnImplicito4);
        Button btnImp5 = findViewById(R.id.btnImplicito5);

        // 1. Abrir Mapa
        btnImp1.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:-33.4489,-70.6693?q=Santo+Tomas");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            startActivity(mapIntent);
        });

        // 2. Abrir Página Web
        btnImp2.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.santo-tomas.cl");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        });

        // 3. Llamar por Teléfono
        btnImp3.setOnClickListener(v -> {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:912345678"));
            startActivity(phoneIntent);
        });

        // 4. Enviar Correo Electrónico
        btnImp4.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:contacto@santotomas.cl"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Prueba Prototipo 2 Android");
            try {
                startActivity(emailIntent);
            } catch (Exception e) {
                Toast.makeText(this, "No hay aplicaciones de correo instaladas", Toast.LENGTH_SHORT).show();
            }
        });

        // 5. Tomar Fotografía con la Cámara
        btnImp5.setOnClickListener(v -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(takePictureIntent);
            } else {
                Toast.makeText(this, "Cámara no disponible en este dispositivo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}