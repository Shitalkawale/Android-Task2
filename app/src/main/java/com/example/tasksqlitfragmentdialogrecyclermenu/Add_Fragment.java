package com.example.tasksqlitfragmentdialogrecyclermenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class Add_Fragment extends Fragment
{

    CircleImageView profile;
    EditText edtusername,edtemail,edtmobile,edtaddress;
    Button btnadd;

    SqliteDatabaseHelper sqliteDatabaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.addfragment,container,false);
        edtusername=view.findViewById(R.id.addUsername);
        edtemail=view.findViewById(R.id.addEmail);
        edtmobile=view.findViewById(R.id.addMobile);
        edtaddress=view.findViewById(R.id.addAddress);
        btnadd=view.findViewById(R.id.addbtn);

        sqliteDatabaseHelper=new SqliteDatabaseHelper(getContext());

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Information information=new Information();
                information.setUsername(edtusername.getText().toString());
                information.setEmail(edtemail.getText().toString());
                information.setMobile(edtmobile.getText().toString());
                information.setAddress(edtaddress.getText().toString());


                sqliteDatabaseHelper.add(information);
                Toast.makeText(getContext(),"Register Successfull...",Toast.LENGTH_LONG).show();

                edtusername.setText("");
                edtemail.setText("");
                edtmobile.setText("");
                edtaddress.setText("");

            }
        });

        return view;
    }
}
