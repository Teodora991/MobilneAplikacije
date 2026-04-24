package com.example.pripremazakolokvijum;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ToastAndDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toast_and_dialog);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // TOAST BUTTON
        Button btnToast = findViewById(R.id.btnToast);
        btnToast.setOnClickListener(v -> {
            Toast.makeText(this, "This is a Toast message", Toast.LENGTH_SHORT).show();
        });

        // DIALOG BUTTON
        Button btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(v -> {

            new AlertDialog.Builder(this)
                    .setTitle("Dialog Title")
                    .setMessage("This is a simple dialog example")
                    .setPositiveButton("OK", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .show();

        });
    }
}