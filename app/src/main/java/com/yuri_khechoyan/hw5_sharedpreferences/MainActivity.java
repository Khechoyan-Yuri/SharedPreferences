package com.yuri_khechoyan.hw5_sharedpreferences;

/* ========================================================================== */
/*	PROGRAM Shared Preference

    AUTHOR: Yuri Khechoyan
    COURSE NUMBER: CIS 472
    COURSE SECTION NUMBER: 01
    INSTRUCTOR NAME: Dr. Tian
    PROJECT NUMBER: 5
    DUE DATE: 4/6/2017

SUMMARY

    This program is designed to simulate a Survey
    that students at Fontbonne University take.
    Te survey is comprised of Multiple Choice and Keyboard text answers
    Student (user) would be progressing through the survey by swiping from Right to Left

    Once completed, student will be able to see their Results - Avg. for Instructor based questions
    & Avg. for Course based questions


INPUT

        -Tap - multiple choice answers
        -Text - user inputs text for questions that require extensive answers
        -Swipe - user would be able to progress through the survey and go back
        to double check their responses by swiping (Right to Left or Left to Right)


OUTPUT

    Avg. for both Instructor based & Course based questions

ASSUMPTIONS
- Users' know how to properly take a survey
*/

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //Method is called to take survey
    public void Survey(View v){
        //Create String variable for verification
        String temp = getIntent().getStringExtra("submission");
        if(temp == null){
            temp = "false";
        }
        //If the temp value does not equal true, launch the Activity
        if(!temp.equals(true)){
            Intent intent = new Intent (this, SurveyActivity1.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Already took the survey", Toast.LENGTH_LONG).show();
        }
    }
    //Method is called when user wants to View the Results
    public void Results(View v){
        String temp = getIntent().getStringExtra("submission");

        if(temp == null){
            temp = "false";
        }
        if(temp.equals("true")){
            Intent intent = new Intent(this, Results.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "You have to submit the survey first", Toast.LENGTH_LONG).show();
        }
    }
}
