package com.example.tasksqlitfragmentdialogrecyclermenu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>
{
    Context context;
    List<Information> studentList;

    SqliteDatabaseHelper sqliteDatabaseHelper;


    public ViewAdapter(Context context, List<Information> studentList) {
        this.context = context;
        this.studentList = studentList;

        sqliteDatabaseHelper=new SqliteDatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cv= LayoutInflater.from(parent.getContext()).inflate(R.layout.name_add,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.ViewHolder holder, int position) {
        Information information=studentList.get(position);
        holder.txtname.setText(information.getUsername());

        holder.txtname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Information information1=new Information();
                Intent intent=new Intent(context,ViewActivity.class);

                intent.putExtra("name1",information.getUsername());
                intent.putExtra("email1",information.getEmail());
                intent.putExtra("phone1",information.getMobile());
                intent.putExtra("address1",information.getAddress());

                List<Information> informationList=new ArrayList<>();
                informationList=sqliteDatabaseHelper.viewInfo();
                for (Information student:informationList)
                {
                    Log.d("Student details"," Name:"+student.getUsername()+" Email:"+student.getEmail()+" Phone:"+student.getMobile()+" Address:"+student.getAddress());

                }

                context.startActivity(intent);
            }
        });

        holder.deleteimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqliteDatabaseHelper.delete(information.getUsername());
                Toast.makeText(context,"Data deleted sucessfully...."+information.getUsername(),Toast.LENGTH_LONG).show();

                notifyDataSetChanged();
            }
        });

        holder.updateimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();

                intent.putExtra("name1",information.getUsername());
                intent.putExtra("email1",information.getEmail());
                intent.putExtra("phone1",information.getMobile());
                intent.putExtra("address1",information.getAddress());

                context.startActivity(intent);
            }

        });



    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtname,txtemail,txtmobile,txtaddress;
        ImageView deleteimg1,updateimg1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.name);
            txtemail=itemView.findViewById(R.id.addEmail);
            txtmobile=itemView.findViewById(R.id.addMobile);
            txtaddress=itemView.findViewById(R.id.addAddress);
            deleteimg1=itemView.findViewById(R.id.deleteimg);
            updateimg1=itemView.findViewById(R.id.updateimg);
        }
    }
}
