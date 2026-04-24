package com.example.pripremazakolokvijum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pripremazakolokvijum.services.BackgroundService;

/*
 * ============================================================
 * KREIRANJE BACKGROUND SERVICE (ANDROID)
 * ============================================================
 *
 * 1. KREIRANJE SERVICE KLASE
 * ------------------------------------------------------------
 * - Kreira se nova klasa koja EXTEND-uje Service
 * - Override metode:
 *      - onCreate()      → inicijalizacija servisa
 *      - onStartCommand()→ logika koja se izvršava
 *      - onDestroy()     → čišćenje resursa
 *      - onBind()        → vraća null ako nije bound service
 *
 * ------------------------------------------------------------
 *
 * 2. IMPLEMENTACIJA LOGIKE
 * ------------------------------------------------------------
 * - U onStartCommand() se piše glavni kod servisa
 * - Može se pokrenuti Thread za asinhroni rad
 * - Servis NE smije blokirati UI thread
 *
 * ------------------------------------------------------------
 *
 * 3. REGISTRACIJA U MANIFESTU
 * ------------------------------------------------------------
 * - Servis se mora dodati u AndroidManifest.xml:
 *
 *   <service android:name=".MyBackgroundService" />
 *
 * ------------------------------------------------------------
 *
 * 4. POKRETANJE SERVISA IZ ACTIVITY
 * ------------------------------------------------------------
 * - Servis se pokreće preko Intent-a:
 *
 *   Intent intent = new Intent(this, MyBackgroundService.class);
 *   startService(intent);
 *
 * ------------------------------------------------------------
 *
 * 5. ZAUSTAVLJANJE SERVISA
 * ------------------------------------------------------------
 * - Može se zaustaviti:
 *      - stopSelf() (iz servisa)
 *      - stopService(intent) (iz Activity-ja)
 *
 * ------------------------------------------------------------
 *
 * 6. OPCIJA RADA
 * ------------------------------------------------------------
 * - START_STICKY → sistem može ponovo pokrenuti servis
 * - START_NOT_STICKY → servis se ne restartuje
 *
 * ============================================================
 */
public class BackgroundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_service);

        Button btnStart = findViewById(R.id.btnStartService);

        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(this, BackgroundService.class);
            startService(intent);
        });
    }
}