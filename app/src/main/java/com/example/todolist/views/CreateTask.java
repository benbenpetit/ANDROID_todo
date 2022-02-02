package com.example.todolist.views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.todolist.R;
import com.example.todolist.entities.TodoEntity;
import com.example.todolist.entities.TodolistEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CreateTask extends Fragment {

    private DatePicker datePicker;
    private EditText editTextTitle;
    private EditText editTextDesc;
    private TodolistEntity viewModel;

    public CreateTask() {
        viewModel = new TodolistEntity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.createtask_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.editTextTitle = getView().findViewById(R.id.editTitleTask);
        this.editTextDesc = getView().findViewById(R.id.editDescTask);
        this.datePicker = getView().findViewById(R.id.editDateTask);
        Button btnSubmit = getView().findViewById(R.id.validateButtonTask);
        this.viewModel = new TodolistEntity();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            private CreateTask createTask;

            @Override
            public void onClick(View view) {
                createTask.createTask();
                Toast.makeText(getContext(), "Todo '" + editTextTitle.getText().toString() + "' added to list !", Toast.LENGTH_LONG).show();
            }

            public View.OnClickListener init(CreateTask createTask) {
                this.createTask = createTask;

                return this;
            }
        }.init(this));
    }

    public void createTask() {
        Date date = CalendarDatePicker().getTime();
        String title = this.editTextTitle.getText().toString();
        String description = this.editTextDesc.getText().toString();

        viewModel.addTask(new TodoEntity(title, description, date));
    }

    private Calendar CalendarDatePicker() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar;
    }

}
