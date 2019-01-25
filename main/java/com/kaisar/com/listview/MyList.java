package com.kaisar.com.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyList extends ArrayAdapter<String>
{

   private final Activity context;
    private final String[] name;
    private final String[] id;
    private final String[] section;
    private final Integer[] Image;
    public MyList(Activity context, String[] name, Integer[] Image, String[] id, String[] section) {
        super(context, R.layout.custom_layout, name);

        this.context=context;
        this.name=name;
        this.id=id;
        this.Image=Image;
        this.section=section;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_layout, null,true);
        TextView t1=(TextView)rowView.findViewById(R.id.textView);
        TextView t2=(TextView)rowView.findViewById(R.id.textView2);
        TextView t3=(TextView)rowView.findViewById(R.id.textView3);
        ImageView Ima=(ImageView)rowView.findViewById(R.id.imageView);
        t1.setText(name[position]);
        t2.setText(id[position]);
        t3.setText(section[position]);
        Ima.setImageResource(Image[position]);

        return rowView;
    }
}
