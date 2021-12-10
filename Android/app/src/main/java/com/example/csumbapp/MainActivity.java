package com.example.csumbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);

        ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add("CST 300: Major ProSeminar");
        arrayList.add("CST 338: Software Design");
        arrayList.add("CST 363: Database Management");
        arrayList.add("CST 334: Operating Systems");
        arrayList.add("CST 311: Introduction to Computer Networking");
        arrayList.add("CST 336: Internet Programming");
        arrayList.add("CST 462S: Race, Gender, Class in the Digital World");
        arrayList.add("CST 370: Algorithms");
        arrayList.add("CST 383: Introduction to Data Science");
        arrayList.add("CST 438: Software Engineering");
        arrayList.add("CST 489: Capstone Project Planning ");
        arrayList.add("CST 499: Directed Group Capstone");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

    }
}