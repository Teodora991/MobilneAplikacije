package com.example.pripremazakolokvijum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class ExplicitAndImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_and_implicit_intent);

        Button btnExplicit = findViewById(R.id.btnExplicit);
        Button btnImplicit = findViewById(R.id.btnImplicit);

        // explicit intent
        btnExplicit.setOnClickListener(v -> {
            Intent intent = new Intent(this, ToolbarActivity.class);
            startActivity(intent);
        });

        // implicit intent
        btnImplicit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(intent);
        });

        // 1. OTVARANJE WEB STRANICE
// ACTION_VIEW: Android otvara URL u dostupnom browseru
        btnImplicit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.google.com"));
            startActivity(intent);
        });


// 2. OTVARANJE MAPA
// ACTION_VIEW + geo URI: otvara mapu i pretrazuje lokaciju
        btnImplicit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Belgrade"));
            startActivity(intent);
        });


// 3. OTVARANJE TELEFONA (dialer)
// ACTION_DIAL: otvara broj u dialer-u, NE poziva automatski
        btnImplicit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:123456789"));
            startActivity(intent);
        });


// 4. SLANJE EMAIL-A
// ACTION_SENDTO + mailto: otvara email aplikaciju sa popunjenim primaocem
        btnImplicit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:test@gmail.com"));
            startActivity(intent);
        });


// 5. SHARE TEKSTA
// ACTION_SEND: otvara share meni (WhatsApp, Viber, itd.)
        btnImplicit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello world");
            startActivity(intent);
        });
    }
}