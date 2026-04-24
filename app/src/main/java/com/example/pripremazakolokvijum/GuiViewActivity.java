package com.example.pripremazakolokvijum;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class GuiViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_view);

        // TextView
        TextView txtView = findViewById(R.id.textView);
        txtView.setOnClickListener(v ->
                Log.i("GUI", "TextView clicked")
        );



        // Radio Group
        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);

        radioGroupGender.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == R.id.rbMale) {
                Log.i("Gender", "Muško izabrano");
            }

            if (checkedId == R.id.rbFemale) {
                Log.i("Gender", "Žensko izabrano");
            }
        });

        // EditText
        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("GUI", "EditText: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // ImageView
        findViewById(R.id.imgView).setOnClickListener(v ->
                Log.i("GUI", "ImageView clicked")
        );

        // ToggleButton
        ToggleButton toggleBtn = findViewById(R.id.toggleBtn);
        toggleBtn.setOnClickListener(v -> {
            Log.i("GUI", "ToggleButton: " + toggleBtn.isChecked());
                }

        );

        // CheckBox
        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnClickListener(v ->
                Log.i("GUI", "CheckBox: " + checkBox.isChecked())
        );

        // Button
        Button buttonView = findViewById(R.id.btnView);
        buttonView.setOnClickListener(v -> {

            Log.i("GUI", "ButtonClicked");

            // promena TextView teksta
            txtView.setText("CHANGED");

            // promena boje teksta
            txtView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

            // promena pozadine TextView
            txtView.setBackgroundColor(getColor(android.R.color.holo_blue_light));

            editText.setText("Writing...");
            // checkbox toggle (ako je čekiran -> uncheck, ako nije -> check)
            checkBox.setChecked(!checkBox.isChecked());

            // selektuj "žensko" radio button
            radioGroupGender.check(R.id.rbFemale);
        });
    }
}