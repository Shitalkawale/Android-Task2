package com.example.tasksqlitfragmentdialogrecyclermenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewActivity extends AppCompatActivity {

    TextView usernametxt,mobiletxt,emailtxt,addresstxt;
    CircleImageView profileimg;
    SqliteDatabaseHelper sqliteDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        usernametxt=findViewById(R.id.viewname);
        emailtxt=findViewById(R.id.viewemail);
        mobiletxt=findViewById(R.id.viewmobile);
        addresstxt=findViewById(R.id.viewaddress);

        sqliteDatabaseHelper=new SqliteDatabaseHelper(this);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name1");
        String email=intent.getStringExtra("email1");
        String phone=intent.getStringExtra("phone1");
        String address=intent.getStringExtra("address1");


        usernametxt.setText("Name:  "+name);
        emailtxt.setText("Email:  "+email);
        mobiletxt.setText("Mobile No:  "+phone);
        addresstxt.setText("Address:  "+address);

    }
}