package com.group5.fap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ActivityResultsScreen extends AppCompatActivity {

    private ArrayList<ListViewElements> listViewElements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        listViewElements.add(new ListViewElements(ThreadLocalRandom.current().nextInt(2000,8000),"Fishing"));
        listViewElements.add(new ListViewElements(ThreadLocalRandom.current().nextInt(1000,5000),"Football"));
        listViewElements.add(new ListViewElements(ThreadLocalRandom.current().nextInt(6000,9500),"Petanque"));
        listViewElements.add(new ListViewElements(ThreadLocalRandom.current().nextInt(3500,5000),"Live Action Role Playing"));

        ListAdapter listAdapter = new ListAdapter(this, R.layout.list_view_elements, listViewElements);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(listAdapter);


    }

    public void onClick(View view) {
        startActivity(new Intent(view.getContext(), HomeScreen.class));
    }
}
