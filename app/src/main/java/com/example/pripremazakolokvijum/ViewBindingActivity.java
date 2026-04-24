package com.example.pripremazakolokvijum;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pripremazakolokvijum.databinding.ActivityViewBindingBinding;

public class ViewBindingActivity extends AppCompatActivity {

    private ActivityViewBindingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityViewBindingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewBindingBtn.setOnClickListener(v ->
                Log.i("BINDING", "Hello there!"));

    }
}