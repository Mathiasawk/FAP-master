package com.group5.fap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class ActivityPromoterScreen extends AppCompatActivity {

    private int[] activityImages = new int[] {
            R.drawable.fish,
            R.drawable.football,
            R.drawable.petanque,
            R.drawable.rollespil
    };

    private String[] activityNames = new String[] {
            "Fishing",
            "Football",
            "Petanque",
            "Live Action Role Playing"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoter_screen);

        SwipePlaceHolderView swipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        Context context = getApplicationContext();

        swipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
//                        .setPaddingTop(5)
//                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        boolean goToResults = false;
        for (int i = 0; i < activityNames.length; i++) {
            if (i == activityNames.length-1)
                goToResults = true;
            swipeView.addView(new TinderCard(context, activityImages[i], activityNames[i], swipeView, goToResults));
        }


        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CHECK", "NO");
                swipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CHECK", "YES");
                swipeView.doSwipe(true);
            }
        });
    }

    public void onClick(View view) {
        startActivity(new Intent(view.getContext(), HomeScreen.class));
    }
}
