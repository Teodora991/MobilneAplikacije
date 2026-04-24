package com.example.pripremazakolokvijum.viewModels;

import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {
    // data that survives rotation
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void increment() {
        counter++;
    }
}
