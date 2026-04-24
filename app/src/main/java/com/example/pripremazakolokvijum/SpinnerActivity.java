package com.example.pripremazakolokvijum;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*
         * ============================================================
         * 1. BASIC SPINNER (STRING LISTA)
         * ============================================================
         *
         * - Spinner prikazuje jednostavne string vrednosti
         * - koristi ArrayAdapter<String>
         */

        Spinner spinner = findViewById(R.id.spinner);

        // DATA SOURCE (STRING LISTA)
        List<String> items = new ArrayList<>();
        items.add("Android");
        items.add("iOS");
        items.add("Windows");
        items.add("Linux");

        // ADAPTER (vezuje listu i UI)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                items
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        // LISTENER (hvata klik)
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = items.get(position);
                Log.i("Spinner", "Selected: " + selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        /*
         * ============================================================
         * 2. EMPLOYEE SPINNER (OBJEKTI - NAPREDNO)
         * ============================================================
         *
         * - Spinner prikazuje objekte (Employee)
         * - koristi ArrayAdapter<Employee>
         * - Employee mora imati toString() metodu
         *
         * UNCOMMENT ZA KORIŠĆENJE:
         */

        /*
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Marko", "Dev"));
        employees.add(new Employee(2, "Ana", "Designer"));
        employees.add(new Employee(3, "Ivan", "Tester"));

        ArrayAdapter<Employee> employeeAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                employees
        );

        employeeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(employeeAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Employee selected = employees.get(position);

                Log.i("Spinner", "ID: " + selected.id);
                Log.i("Spinner", "Name: " + selected.name);
                Log.i("Spinner", "Job: " + selected.job);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        */

    }
}