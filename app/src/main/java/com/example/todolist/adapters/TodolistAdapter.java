package com.example.todolist.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.entities.TodoEntity;
import com.example.todolist.entities.TodolistEntity;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TodolistAdapter extends RecyclerView.Adapter<TodolistAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;
        private final CheckBox checkBox;
        private final TextView date;
        private final Button btnDelete;
        private TodoEntity todoEntity = null;

        public ViewHolder(View itemView, TodolistEntity model) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.todoTitle);
            description = (TextView) itemView.findViewById(R.id.todoDescription);
            date = (TextView) itemView.findViewById(R.id.todoDate);
            checkBox = (CheckBox) itemView.findViewById(R.id.todoCheckBox);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);

            checkBox.setOnClickListener(new View.OnClickListener() {
                private TodolistEntity model;

                @Override
                public void onClick(View view) {
                    boolean checked = ((CheckBox) view).isChecked();

                    if (todoEntity != null)
                        this.model.setTodoChecked(todoEntity, checked);
                }

                public View.OnClickListener init(TodolistEntity model) {
                    this.model = model;

                    return this;
                }
            }.init(model));

            btnDelete.setOnClickListener(new View.OnClickListener() {
                private TodolistEntity model;

                @Override
                public void onClick(View view) {
                    if (todoEntity != null)
                        this.model.removeTask(todoEntity);
                }

                public View.OnClickListener init(TodolistEntity model) {
                    this.model = model;

                    return this;
                }
            }.init(model));
        }

        public TextView getTitleTextView() {
            return title;
        }

        public TextView getDateTextView() {
            return date;
        }

        public TextView getDescriptionTextView() {
            return description;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public void setTask(TodoEntity todoEntity) {
            this.todoEntity = todoEntity;
        }
    }

    private final List<TodoEntity> todoEntityList;

    public TodolistAdapter(List<TodoEntity> todoEntityList) {
        this.todoEntityList = todoEntityList;
    }

    @Override
    public int getItemCount() {
        return todoEntityList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.task, viewGroup, false);

        return new ViewHolder(view, new TodolistEntity().setAdapter(this));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTitleTextView().setText(todoEntityList.get(position).getTitle());
        viewHolder.getDescriptionTextView().setText(todoEntityList.get(position).getDescription());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
        String dateFormatter = formatter.format(todoEntityList.get(position).getDate().getTime());

        viewHolder.getDateTextView().setText(dateFormatter);
        viewHolder.getCheckBox().setChecked(todoEntityList.get(position).isChecked());
        viewHolder.setTask(todoEntityList.get(position));
    }
}
