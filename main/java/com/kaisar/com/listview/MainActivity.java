package com.kaisar.com.listview;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private SearchView search;


    String [] name = {"Jobaer Ahmed","Abu Kaisar","Rakib Hossain","Ashraful Islam","Fowjael Ahamed","Md Monjur"};
    Integer[] Image={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};
    String[] id ={"161-15-6735","161-15-6759","161-15-6802","161-15-7100","161-15-7045","131-15-6812"};
    String[] section={"F","F","F","F","F","F"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyList adapter = new MyList(this,name,Image,id,section);
        final ListView listview=(ListView)findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setTextFilterEnabled(true);
        search=(SearchView) findViewById(R.id.search);

        listview.setTextFilterEnabled(true);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = listview.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "selected "+item, Toast.LENGTH_SHORT).show();
            }
        });



        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                adapter.notifyDataSetChanged();
                return false;
            }
        });




    }
}


