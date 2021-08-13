package com.example.tasksqlitfragmentdialogrecyclermenu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateView extends AppCompatActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void viewbox(View view) {

        EditText txtusername,txtemail,txtaddress,txtmobile;

        AlertDialog.Builder builder=new AlertDialog.Builder(UpdateView.this);
        View customView=getLayoutInflater().inflate(R.layout.custom_design,null);
        txtusername=customView.findViewById(R.id.designusername);
        txtemail=customView.findViewById(R.id.designemail);
        txtmobile=customView.findViewById(R.id.designmobile);
        txtaddress=customView.findViewById(R.id.designaddress);
        builder.setView(customView);
        builder.setTitle("UPDATE");
        builder.setCancelable(false);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });

        AlertDialog alertDialog=builder.create();

        alertDialog.show();

    }

}
