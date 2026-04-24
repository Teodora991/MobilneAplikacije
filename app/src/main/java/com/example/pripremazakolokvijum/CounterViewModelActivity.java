package com.example.pripremazakolokvijum;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.pripremazakolokvijum.viewModels.CounterViewModel;

public class CounterViewModelActivity extends AppCompatActivity {

    private CounterViewModel counterViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_view_model);

        // create / get ViewModel
        counterViewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        // show current value
        textView.setText(String.valueOf(counterViewModel.getCounter()));

        button.setOnClickListener(v -> {
            counterViewModel.increment();
            textView.setText(String.valueOf(counterViewModel.getCounter()));
        });
    }
}