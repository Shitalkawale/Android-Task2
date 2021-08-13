package com.example.tasksqlitfragmentdialogrecyclermenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterView extends BaseAdapter
{
    Context context;
    String[] name;

    public AdapterView(Context context, String[] name) {
        this.context = context;
        this.name = name;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View myview=null;
        if (myview==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            myview=layoutInflater.inflate(R.layout.name_add,null);

        }
        else
        {
            myview=view;
        }

        TextView myname=myview.findViewById(R.id.name);
        myname.setText(name[i]);

        return myview;
    }
}
