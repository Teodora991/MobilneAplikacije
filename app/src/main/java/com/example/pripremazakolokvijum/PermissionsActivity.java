package com.example.pripremazakolokvijum;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class PermissionsActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSIONS = 100;

    // Samo dangerous permissions (runtime)
    private String[] permissions = {

            // kamera i mikrofon
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,

            // lokacija
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,

            // storage (deprecated ali često tražen na kolokvijumu)
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,

            // kontakti
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,

            // telefon
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE,

            // sms
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS,
            Manifest.permission.READ_SMS,

            // kalendar
            Manifest.permission.READ_CALENDAR,
            Manifest.permission.WRITE_CALENDAR,

            // senzori
            Manifest.permission.BODY_SENSORS,
            Manifest.permission.ACTIVITY_RECOGNITION
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        // poziv za runtime permisije
        requestPermissions();
    }

    private void requestPermissions() {

        // traži sve permisije iz niza
        ActivityCompat.requestPermissions(this, permissions, REQUEST_PERMISSIONS);

        // posebna permisija za notifikacije (android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.POST_NOTIFICATIONS},
                    REQUEST_PERMISSIONS
            );
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSIONS) {

            // prolazak kroz sve rezultate
            for (int i = 0; i < permissions.length; i++) {

                // log rezultat (granted ili denied)
                Log.i("Permissions", permissions[i] + " : " + grantResults[i]);

                // provera da li je neka odbijena
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    Log.e("Permissions", "permission denied");
                }
            }
        }
    }
}