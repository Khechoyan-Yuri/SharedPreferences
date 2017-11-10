package com.yuri_khechoyan.hw5_sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SurveyActivity1 extends AppCompatActivity implements GestureDetector.OnGestureListener{

    //Array of Questions
    String [] questions = {"This is for the Instructor 1.1 Created an academic environment that supported the learning process.",
            "1.2 Modeled respect to others and the values of Fontbonne University.",
            "1.3 Demonstrated enthusiasm for teaching and learning",
            "1.4 Followed the policies outlined in the syllabus",
            "1.5 Presented the content in a logical and organizaed manner.",
            "1.6 Challenged me to think in new and different ways.",
            "1.7 Addressed the objectives stated in the syllabus.",
            "1.8 Encouraged my interest in the course",
            "1.9 Provided timely feedback",
            "1.10 Provided useful feedback",
            "1.11 Make her/his availability known",
            "1.12 Overall, tHe instructor effectively facilitated my learning",
            "This is for the Course 2.1 Syllabus clearly stated the learning objectives. ",
            "2.2 Syllabus clearly stated the overall grading policy. ",
            "2.3 Assignments were clearly stated. ",
            "2.4 Assignments/activities/tests helped me attain the learning objectives ",
            "2.5 Grading criteria for assignments were clearly stated ",
            "2.6 Textbook and/or materials were helpful in attaining the learning objectives",
            "2.7 Overall, I rate this course as excellent. "};
    //Variables
    int counter = 0;
    TextView phrase;
    RadioButton strAgree;
    RadioButton agree;
    RadioButton neutral;
    RadioButton disagree;
    RadioButton strDisgree;
    RadioButton yes33;
    RadioButton yes34;
    RadioButton yes35;
    RadioButton no33;
    RadioButton no34;
    RadioButton no35;
    RadioButton elective;
    RadioButton required;
    RadioButton freshman;
    RadioButton sophomore;
    RadioButton junior;
    RadioButton senior;
    RadioButton graduate;
    RadioButton certificate;
    RadioButton unclassfied;
    RadioButton other;
    EditText instructor;
    EditText course;
    SharedPreferences myPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey1);
        gDetector = new GestureDetectorCompat(this, this);
        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Created counter Variable that will increment & decrement based on user gestures
        counter = getIntent().getIntExtra("count", 0);
        if(counter<19 && counter>=0){
            phrase = (TextView) findViewById(R.id.tv_question);
            strAgree = (RadioButton) findViewById(R.id.rb_stragree);
            agree = (RadioButton) findViewById(R.id.rb_agree);
            neutral = (RadioButton) findViewById(R.id.rb_neutral);
            disagree = (RadioButton) findViewById(R.id.rb_disagree);
            strDisgree = (RadioButton) findViewById(R.id.rb_sdisagree);
            phrase.setText(questions[counter]);
            int temp = myPrefs.getInt("Q" + counter, 0);
            //Initialized Values for the responses (0-4 in computer | 1-5 in human)
            if (temp == 5) {
                strAgree.toggle();
            } else if (temp == 4) {
                agree.toggle();
            } else if (temp == 3) {
                neutral.toggle();
            } else if (temp == 2) {
                disagree.toggle();
            } else if (temp == 1) {
                strDisgree.toggle();
            }
        }
        //Record user input for what kind of class this was for student
        else if (counter == 19){
            setContentView(R.layout.student_info1);
            elective = (RadioButton) findViewById(R.id.rb_elective);
            required = (RadioButton) findViewById(R.id.rb_required);
            int temp = myPrefs.getInt("Q" + counter, 0);
            if(temp == 1){
                elective.toggle();
            }
            else  if(temp == 2){
                required.toggle();
            }
        }
        //Record student classification response (Fr., So., Jr., Sr.)
        else if(counter == 20){
            setContentView(R.layout.student_info2);
            freshman = (RadioButton) findViewById(R.id.rb_freshman);
            sophomore = (RadioButton) findViewById(R.id.rb_sophomore);
            junior = (RadioButton) findViewById(R.id.rb_junior);
            senior = (RadioButton) findViewById(R.id.rb_senior);
            graduate = (RadioButton) findViewById(R.id.rb_grad);
            certificate = (RadioButton) findViewById(R.id.rb_cert);
            unclassfied = (RadioButton) findViewById(R.id.rb_Unclassified);
            other = (RadioButton) findViewById(R.id.rb_other);
            int temp = myPrefs.getInt("Q" + counter, 0);
            if(temp == 1){
                freshman.toggle();
            }
            else  if(temp == 2){
                sophomore.toggle();
            }
            else  if(temp == 3){
                junior.toggle();
            }
            else  if(temp == 4){
                senior.toggle();
            }
            else  if(temp == 5){
                graduate.toggle();
            }
            else  if(temp == 6){
                certificate.toggle();
            }
            else  if(temp == 7){
                unclassfied.toggle();
            }
            else  if(temp == 8){
                other.toggle();
            }
        }
        //Record response for 1st Y/N question
        else if(counter == 21){
            setContentView(R.layout.student_info3);
            no33 = (RadioButton) findViewById(R.id.rb_no1);
            yes33 = (RadioButton) findViewById(R.id.rb_yes1);
            int temp = myPrefs.getInt("Q" + counter, 0);
            if(temp == 1){
                yes33.toggle();
            }
            else  if(temp == 2){
                no33.toggle();
            }
        }
        //Record response for 2nd Y/N question
        else if(counter == 22){
            setContentView(R.layout.student_info4);
            yes34 = (RadioButton) findViewById(R.id.rb_yes2);
            no34 = (RadioButton) findViewById(R.id.rb_no2);
            int temp = myPrefs.getInt("Q" + counter, 0);
            if(temp == 1){
                yes34.toggle();
            }
            else  if(temp == 2){
                no34.toggle();
            }
        }
        //Record response for 3rd Y/N question
        else if(counter == 23){
            setContentView(R.layout.student_info5);
            yes35 = (RadioButton) findViewById(R.id.rb_yes3);
            no35 = (RadioButton) findViewById(R.id.rb_no3);
            int temp = myPrefs.getInt("Q" + counter, 0);
            if(temp == 1){
                yes35.toggle();
            }
            else  if(temp == 2){
                no35.toggle();
            }
        }
        //Record EditText Response for "Comments about Instructor"
        else if(counter == 24){
            setContentView(R.layout.fourth_section);
            instructor = (EditText) findViewById(R.id.ev_comm_instructor);
            String temp = myPrefs.getString("Q" + counter, null);
            if(temp!=null) {
                instructor.setText(temp);
            }
            else{
                instructor.setText("");
            }
        }
        //Record response for "Comments about Course"
        else if(counter == 25){
            setContentView(R.layout.fifth_section);
            course = (EditText) findViewById(R.id.ev_comm_course);
            String temp = myPrefs.getString("Q" + counter, null);
            if(temp!=null) {
                course.setText(temp);
            }
            else{
                course.setText("");
            }
        }
    }
    //Detect Swipe Gesture
    private GestureDetectorCompat gDetector;
    @Override
    public void onBackPressed(){

    }
    //Handler for all Swipe Gestures
    @Override
    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float f1, float f2){
        SharedPreferences.Editor editor = myPrefs.edit();
        Intent intent = new Intent(this, SurveyActivity1.class);
        if(arg0.getRawX() < arg1.getRawX()){
            //Swipe motions for first 19 questions
            //Saves user entry to SharedPreference when Swipe motion is triggered
            if(counter < 19 && counter >= 0){
                //Strongly Agree
                if(strAgree.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 5);
                    editor.commit();
                }
                //Agree
                else if(agree.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 4);
                    editor.commit();
                }
                //Neutral
                else if(neutral.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 3);
                    editor.commit();
                }
                //Disagree
                else if(disagree.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }
                //Strongly Disagree
                else if(strDisgree.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }

            }
            //Log verification if elective selection is null
            else if (counter == 19){
                if(elective == null){
                    Log.d("HERE", "This is null" );
                }
                //Adds Elective to Shared Preference
                else if(elective.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                //Adds Required to Shared Preference
                else if(required.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }
                //If user moves in reverse
                counter--;
                intent.putExtra("count", counter);
                startActivity(intent);
            }
            //Add Fr to Shared Preference if selected
            else if (counter == 20){
                if(freshman.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                //Add So to Shared Preference if selected
                else if(sophomore.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }
                //Add Jr to Shared Preference if selected
                else if(junior.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 3);
                    editor.commit();
                }
                //Add Sr to Shared Preference if selected
                else if(senior.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 4);
                    editor.commit();
                }
                //Add Graduate to Shared Preference if selected
                else if(graduate.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 5);
                    editor.commit();
                }
                //Add Certificate to Shared Preference if selected
                else if(certificate.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 6);
                    editor.commit();
                }
                //Add Unclassified to Shared Preference if selected
                else if(unclassfied.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 7);
                    editor.commit();
                }
                //Add Other to Shared Preference if selected
                else if(other.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 8);
                    editor.commit();
                }

            }
            //Verifies if Yes is selected for question 3.3 and adds to Shared Preference
            else if (counter == 21){
                if(yes33.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                //Verifies if No is selected for question 3.3 and adds to Shared Preference
                else if(no33.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }

            }
            //Verifies if Yes is selected for question 3.4 and adds to Shared Preference
            else if (counter == 22){
                if(yes34.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                //Verifies if No is selected for question 3.4 and adds to Shared Preference
                else if(no34.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }
            }
            //Verifies if Yes is selected for question 3.5 and adds to Shared Preference
            else if (counter == 23){
                if(yes35.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                //Verifies if No is selected for question 3.5 and adds to Shared Preference
                else if(no35.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }

            }
            //Adds String value to Shared Preference
            else if (counter == 24){
                String temp = instructor.getText().toString();
                editor.remove("Q"+counter);
                editor.putString("Q"+counter, temp);
                editor.commit();

            }
            //Adds String value to Shared Preference
            else if (counter == 25){
                String temp = course.getText().toString();
                editor.remove("Q"+counter);
                editor.putString("Q"+counter, temp);
                editor.commit();
            }
            //Moves in reverse (if user swipe in opposite direction)
            counter--;
            if(counter == -1){
                Toast.makeText(getApplicationContext(), "Cannot swipe anymore!", Toast.LENGTH_LONG).show();
                counter++;
            }
            else {
                intent.putExtra("count", counter);
                startActivity(intent);
            }
        }
        //------------------------------------------------------------------------------------------
        //Verifying if these buttons are selected
        else if (arg0.getRawX() > arg1.getRawX()){
            if(counter < 19 && counter >= 0){
                //Strongly Agree
                if(strAgree.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 5);
                    editor.commit();
                }
                //Agree
                else if(agree.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 4);
                    editor.commit();
                }
                //Neutral
                else if(neutral.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 3);
                    editor.commit();
                }
                //Disagree
                else if(disagree.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }
                //Strongly Disagree
                else if(strDisgree.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }

            }
            //Log for Type of Course
            else if (counter == 19){
                if(elective == null){
                    Log.d("HERE", "This is null" );
                }
                //Add to Shared Preference
                if(elective.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                //Add to Shared Preference
                else if(required.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }

            }
            //Verifying user selection for Student Classification question
            else if (counter == 20){
                if(freshman.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                else if(sophomore.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }
                else if(junior.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 3);
                    editor.commit();
                }
                else if(senior.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 4);
                    editor.commit();
                }
                else if(graduate.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 5);
                    editor.commit();
                }
                else if(certificate.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 6);
                    editor.commit();
                }
                else if(unclassfied.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 7);
                    editor.commit();
                }
                else if(other.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 8);
                    editor.commit();
                }

            }
            else if (counter == 21){
                //Verifies if Yes is selected for question 3.3 and adds to Shared Preference
                if(yes33.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                //Verifies if No is selected for question 3.3 and adds to Shared Preference
                else if(no33.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }

            }
            else if (counter == 22){
                //Verifies if Yes is selected for question 3.4 and adds to Shared Preference
                if(yes34.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                //Verifies if No is selected for question 3.4 and adds to Shared Preference
                else if(no34.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }
            }
            //Verifies if Yes is selected for question 3.5 and adds to Shared Preference
            else if (counter == 23){
                if(yes35.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 1);
                    editor.commit();
                }
                //Verifies if No is selected for question 3.5 and adds to Shared Preference
                else if(no35.isChecked()){
                    editor.remove("Q"+counter);
                    editor.putInt("Q"+counter, 2);
                    editor.commit();
                }
            }
            else if (counter == 24){
                String temp = instructor.getText().toString();
                editor.remove("Q"+counter);
                editor.putString("Q"+counter, temp);
                editor.commit();
            }
            else if (counter == 25){
                String temp = course.getText().toString();
                editor.remove("Q"+counter);
                editor.putString("Q"+counter, temp);
                editor.commit();
            }

            counter++;
            if(counter == 26){
                Toast.makeText(getApplicationContext(), "Cannot Swipe that way!", Toast.LENGTH_LONG).show();
                counter--;
                intent.putExtra("count", counter);
                startActivity(intent);
            }
            intent.putExtra("count", counter);
            startActivity(intent);

        }
        return false;
    }

    //Submit method for submitting results
    public void Submit(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("submission", "true");
        startActivity(intent);

    }
    @Override
    public void onLongPress(MotionEvent arg0){

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0){

        return false;
    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float f1, float f2){
        return false;
    }

    @Override
    public boolean onDown(MotionEvent arg0){

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0){
        return gDetector.onTouchEvent(arg0);
    }
    @Override
    public void onShowPress(MotionEvent arg0){
    }


}
