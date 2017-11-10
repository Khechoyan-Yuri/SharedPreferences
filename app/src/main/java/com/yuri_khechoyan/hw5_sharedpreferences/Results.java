package com.yuri_khechoyan.hw5_sharedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    SharedPreferences perfs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        perfs = PreferenceManager.getDefaultSharedPreferences(this);
        double sum1 = 0;
        double sum2 = 0;
        for(int i = 0; i < 12; i++){
            int temp = perfs.getInt("Q"+i, 0);
            sum1 += temp;
        }
        for(int i = 12; i < 19; i++){
            double temp = (double) perfs.getInt("Q"+i, 0);
            sum2 += temp;
        }
        double avg1 = sum1/12;
        double avg2 = sum2/7;

        //Be able to see what the Averages are for both Instructor & Course based Questions
        TextView instr = (TextView) findViewById(R.id.tv_instr_avg);
        TextView course = (TextView) findViewById(R.id.tv_course_avg);
        instr.setText("" + avg1);
        course.setText("" +avg2);
    }

    public void Back (View v){
        setContentView(R.layout.activity_main);
    }
}
