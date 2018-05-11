package com.group5.fap;


import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UserStatsManager {

    private UsageStatsTranslator usageStatsTranslator;
    private ArrayList<ListViewElements> listViewElements;

    public UserStatsManager(UsageStatsTranslator usageStatsTranslator){
        this.usageStatsTranslator = usageStatsTranslator;
        this.listViewElements = new ArrayList<>();
    }

    //
    public ArrayList<ListViewElements> createUserList(){

        String[] userNames = {"Me", "Bob" , "Jane", "Tom"};
        double[] timeSpent = new double[userNames.length];

        timeSpent[0] = computeTotalTime();
        if (timeSpent[0] == 0)
            timeSpent[0] = (long)2;

        Log.d("check", String.valueOf(timeSpent[0]));
        for (int i = 1; i < userNames.length; i++) {
            timeSpent[i] = ThreadLocalRandom.current().nextDouble(timeSpent[0]/2,timeSpent[0]*2);
            Log.d("check",String.valueOf(timeSpent[i]));
        }

        //bubble sort - finding number with the highestValue
        double result = timeSpent[0];
        for (int i = 0; i < timeSpent.length; i++) {
            if (result < timeSpent[i])
                result = timeSpent[i];
        }
        //setting progress bar values
        for (int i = 0; i < timeSpent.length; i++) {
            timeSpent[i] = timeSpent[i] * 10000 / result;
        }

        for (int i = 0; i < timeSpent.length; i++) {
            listViewElements.add(new ListViewElements(timeSpent[i], userNames[i]));
        }

        return listViewElements;
    }

    //
    public double computeTotalTime() {
        double totalTime = 0;
        for (ListViewElements il: usageStatsTranslator.getTranslatedList()) {
            totalTime += il.getProgressBarValue();
        }
        return totalTime;
    }
}
