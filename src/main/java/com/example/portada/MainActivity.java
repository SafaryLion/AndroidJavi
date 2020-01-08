package com.example.portada;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Button bmapa;
    Button btelefono;
    Button bcorreo;
    ImageView i_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmapa = findViewById(R.id.btnMapa);
        btelefono = findViewById(R.id.button);
        bcorreo = findViewById(R.id.button2);

        i_logo = (ImageView) findViewById(R.id.imageView);


        //ABRIR APP LLAMADAS

         btelefono.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Uri number = Uri.parse("tel:943512389");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                startActivity(callIntent);
            }
        });


         //ABRIR CORREO

        bcorreo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","greenphone@sedecentral.com", null));
                startActivity(emailIntent);
            }
        });


        //ABRIR MAPA
        bmapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mapaIntent = new Intent(getApplicationContext(), MapsActivity1.class);
                startActivity(mapaIntent);
            }
        });


    }
}

