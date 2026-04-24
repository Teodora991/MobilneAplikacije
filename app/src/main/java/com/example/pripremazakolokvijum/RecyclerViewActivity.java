package com.example.pripremazakolokvijum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pripremazakolokvijum.adapters.EmployeeAdapter;
import com.example.pripremazakolokvijum.models.Employee;

import java.util.ArrayList;
import java.util.List;


/*
 * RecyclerView - koraci implementacije:
 *
 * 1. Dodati RecyclerView dependency u build.gradle:
 *    implementation 'androidx.recyclerview:recyclerview:1.3.2'
 *
 * 2. U layout fajlu (activity_recycler_view.xml) dodati RecyclerView komponentu:
 *    <androidx.recyclerview.widget.RecyclerView ... />
 *
 * 3. Kreirati layout za jedan item (npr. item_layout.xml)
 *    - definiše kako izgleda jedan red (npr. TextView-ovi za id, ime, zanimanje)
 *
 * 4. Kreirati model klasu (Employee)
 *    - sadrži podatke koji se prikazuju (id, name, job)
 *
 * 5. Kreirati Adapter klasu (EmployeeAdapter)
 *    - nasleđuje RecyclerView.Adapter
 *    - implementira:
 *        onCreateViewHolder() -> kreira view za jedan item
 *        onBindViewHolder()   -> povezuje podatke sa view-om
 *        getItemCount()       -> vraća broj elemenata
 *    - sadrži ViewHolder koji drži reference na view elemente
 *
 * 6. U Activity:
 *    - pronaći RecyclerView (findViewById)
 *    - pripremiti listu podataka (List<Employee>)
 *    - kreirati adapter i proslediti podatke
 *    - postaviti LayoutManager (obavezno!)
 *    - povezati adapter sa RecyclerView
 *
 * 7. Rezultat:
 *    - RecyclerView prikazuje listu elemenata (zaposlenih)
 *
 * Napomena:
 * - Bez LayoutManager-a RecyclerView neće prikazati ništa
 * - Adapter je veza između podataka i UI prikaza
 */

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // lista zaposlenih
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Marko", "Programer"));
        employees.add(new Employee(2, "Ana", "Dizajner"));
        employees.add(new Employee(3, "Ivan", "Tester"));

        EmployeeAdapter adapter = new EmployeeAdapter(employees);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}