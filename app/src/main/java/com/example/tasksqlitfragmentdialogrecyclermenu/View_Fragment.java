package com.example.tasksqlitfragmentdialogrecyclermenu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class View_Fragment extends Fragment
{
    RecyclerView recyclerView;
    SqliteDatabaseHelper sqliteDatabaseHelper;
    List<Information> studentList;
    Information info;
    ViewAdapter viewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewfragment,container,false);
        sqliteDatabaseHelper=new SqliteDatabaseHelper(getContext());
        recyclerView=view.findViewById(R.id.recyclerview);
        studentList=new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        studentList=sqliteDatabaseHelper.view();
        viewAdapter=new ViewAdapter(getContext(),studentList);
        recyclerView.setAdapter(viewAdapter);
        viewAdapter.notifyDataSetChanged();

        return view;
    }
}
