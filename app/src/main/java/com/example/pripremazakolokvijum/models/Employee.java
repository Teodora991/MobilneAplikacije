package com.example.pripremazakolokvijum.models;

public class Employee {

    public int id;
    public String name;
    public String job;

    public Employee(int id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return name + " (" + job + ")";
    }
}
