package com.example.todolist.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.adapters.TodolistAdapter;
import com.example.todolist.entities.TodolistEntity;

public class List extends Fragment {

    private final TodolistEntity viewModel;

    public List() {
        viewModel = new TodolistEntity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView list = (RecyclerView) view.findViewById(R.id.todoList);

        TodolistAdapter adapter = new TodolistAdapter(viewModel.getTodolist());
        viewModel.setAdapter(adapter);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
