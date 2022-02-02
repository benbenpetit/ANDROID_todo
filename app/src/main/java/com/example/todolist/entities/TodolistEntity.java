package com.example.todolist.entities;

import android.util.Log;

import com.example.todolist.adapters.TodolistAdapter;

import java.util.ArrayList;
import java.util.List;

public class TodolistEntity {

    private static final List<TodoEntity> TaskEntityList = new ArrayList<>();
    private static TodolistAdapter TodolistAdapter;

    public TodolistEntity() {
        super();
    }

    public void addTask(TodoEntity todoEntity) {
        TaskEntityList.add(todoEntity);

        if (TodolistAdapter != null)
            TodolistAdapter.notifyItemInserted(TaskEntityList.size() - 1);
    }

    public void removeTask(TodoEntity todoEntity) {
        int index = TaskEntityList.indexOf(todoEntity);
        TaskEntityList.remove(todoEntity);

        if (TodolistAdapter != null)
            TodolistAdapter.notifyItemRemoved(index);
    }

    public void setTodoChecked(TodoEntity todoEntity, boolean isChecked) {
        int index = TaskEntityList.indexOf(todoEntity);
        TaskEntityList.get(index).setChecked(isChecked);
    }

    public List<TodoEntity> getTodolist() {
        return TaskEntityList;
    }

    public TodolistEntity setAdapter(TodolistAdapter todolistAdapter) {
        TodolistAdapter = todolistAdapter;

        return this;
    }
}
