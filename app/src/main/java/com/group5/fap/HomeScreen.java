package com.group5.fap;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(this); //Here we are defining the Imageadapter object
        viewPager.setAdapter(adapter); // Here we are passing and setting the adapter for the images

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityPromoterScreen.class);
                startActivity(intent);
            }
        });

        UsageStatsTranslator usageStatsTranslator = new UsageStatsTranslator(this);
        if (!usageStatsTranslator.checkForPermission()){
            startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
        }

        UserStatsManager userStatsManager = new UserStatsManager(usageStatsTranslator);

        ListAdapter listAdapter = new ListAdapter(this, R.layout.list_view_elements, userStatsManager.createUserList());
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), ActivityStatsScreen.class);
                    startActivityForResult(intent, 0);
                }
            }
        });

    }
}
