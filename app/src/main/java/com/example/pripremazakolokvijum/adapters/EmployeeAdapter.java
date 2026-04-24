package com.example.pripremazakolokvijum.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pripremazakolokvijum.R;
import com.example.pripremazakolokvijum.models.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private List<Employee> data;

    // konstruktor
    public EmployeeAdapter(List<Employee> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Employee emp = data.get(position);

        holder.txtId.setText("ID: " + emp.id);
        holder.txtName.setText("Name: " + emp.name);
        holder.txtJob.setText("Job: " + emp.job);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtName, txtJob;

        public ViewHolder(View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txtId);
            txtName = itemView.findViewById(R.id.txtName);
            txtJob = itemView.findViewById(R.id.txtJob);
        }
    }
}
