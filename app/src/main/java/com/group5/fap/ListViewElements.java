package com.group5.fap;

public class ListViewElements {
    private double progressBarValue;
    private String textViewString;

    public ListViewElements(double progressBarValue, String textViewString){
        this.progressBarValue = progressBarValue;
        this.textViewString = textViewString;
    }

    public double getProgressBarValue() {
        return progressBarValue;
    }

    public String getTextViewString() {
        return textViewString;
    }

    public void setProgressBarValue(double progressBarValue) { this.progressBarValue = progressBarValue; }

    public void setTextViewString(String textViewString) {
        this.textViewString = textViewString;
    }

}
