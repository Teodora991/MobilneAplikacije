package com.example.pripremazakolokvijum;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pripremazakolokvijum.fragments.FirstFragment;
import com.example.pripremazakolokvijum.fragments.SecondFragment;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        FirstFragment firstFragment = new FirstFragment();

        SecondFragment secondFragment = new SecondFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.firstFragmentContainer, firstFragment)
                .replace(R.id.secondFragmentContainer, secondFragment)
                .commit();
    }


}