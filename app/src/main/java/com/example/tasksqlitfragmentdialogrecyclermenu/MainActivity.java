package com.example.tasksqlitfragmentdialogrecyclermenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Information> student;
    ViewAdapter viewAdapter;
    SqliteDatabaseHelper sqliteDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqliteDatabaseHelper=new SqliteDatabaseHelper(this);

        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Add_Fragment()).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.addmenu:
                Toast.makeText(MainActivity.this, "Clicked on Add", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Add_Fragment()).commit();
                break;

            case R.id.viewmenu:
                Toast.makeText(MainActivity.this, "Clicked on View", Toast.LENGTH_SHORT).show();
                List<Information> studentList=new ArrayList<>();
                studentList=sqliteDatabaseHelper.view();
                for (Information student:studentList)
                {
                    Log.d("Student details"," Name:"+student.getUsername()+" Email:"+student.getEmail()+" Phone:"+student.getMobile()+" Address:"+student.getAddress());
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new View_Fragment()).commit();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}