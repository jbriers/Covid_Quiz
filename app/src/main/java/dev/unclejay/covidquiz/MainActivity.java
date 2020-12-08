/*
    Copywrite (C) Jason Briers (UncleJay) - for Education purposes only.
    Android Basics Nanodegree : Project Three
    Task: Build a Quiz App
    Initial Release 9/12/2020
 */
package dev.unclejay.covidquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import dev.unclejay.covidquiz.R;

public class MainActivity extends AppCompatActivity {

    final int totalQuestions = 7;
    int totalCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /* Image Click for Q4 to check associated Radio Button */
    public void q4blobClick(View v) {
        RadioButton blobButton = (RadioButton) findViewById(R.id.q4blob);
        blobButton.setChecked(true);
    }

    public void q4coronaClick(View v) {
        RadioButton coronaButton = (RadioButton) findViewById(R.id.q4corona);
        coronaButton.setChecked(true);
    }

    public void q4roboClick(View v) {
        RadioButton roboButton = (RadioButton) findViewById(R.id.q4robo);
        roboButton.setChecked(true);
    }

    /* CHECK FOR CORRECT ANSWERS & TOAST THE RESULT */

    public void submitAnswers(View v) {

        /* Answer 1 : Radio Button : Toilet Paper */
        RadioButton answerOneRadio = (RadioButton) findViewById(R.id.q1_toiletpaper);
        if (answerOneRadio.isChecked()) {
            totalCorrect += 1;
        }

        /* Answer 2 : Edit Text : China */
        EditText answerTwoText = (EditText) findViewById(R.id.q2_userText);
        if (answerTwoText.getText().toString().trim().toUpperCase().equals("CHINA")) {
            totalCorrect += 1;
        }

        /* Answer 3 : Check Box : Checked - Elderly & Alcohol   Not Checked - Social Distance and Hand Wash */
        int q3tally = 0;
        CheckBox elderlyCheckTrue = (CheckBox) findViewById(R.id.q3_elderly);
        CheckBox socialdistanceCheckFalse = (CheckBox) findViewById(R.id.q3_socialdistance);
        CheckBox alcoholCheckTrue = (CheckBox) findViewById(R.id.q3_alcohol);
        CheckBox washhandsCheckFalse = (CheckBox) findViewById(R.id.q3_washhands);
        if (elderlyCheckTrue.isChecked()) {
            q3tally += 1;
        }
        if (alcoholCheckTrue.isChecked()) {
            q3tally += 1;
        }
        if (!socialdistanceCheckFalse.isChecked()) {
            q3tally += 1;
        }
        if (!washhandsCheckFalse.isChecked()) {
            q3tally += 1;
        }
        if (q3tally == 4) {
            totalCorrect += 1;
        }

        /* Answer 4 : Radio Button : Image Question - Corona Virus Image (Middle One)  */
        RadioButton answerFourRadio = (RadioButton) findViewById(R.id.q4corona);
        if (answerFourRadio.isChecked()) {
            totalCorrect += 1;
        }

        /* Answer 3 : Check Box : Checked - Elderly & Alcohol   Not Checked - Social Distance and Hand Wash */
        int q5tally = 0;
        CheckBox dryCoughCheckTrue = (CheckBox) findViewById(R.id.q5_drycough);
        CheckBox purpleCheckFalse = (CheckBox) findViewById(R.id.q5_purple);
        CheckBox flatearthCheckFalse = (CheckBox) findViewById(R.id.q5_flatearth);
        CheckBox feverChecTrue = (CheckBox) findViewById(R.id.q5_fever);
        CheckBox humorCheckFalse = (CheckBox) findViewById(R.id.q5_humor);
        if (dryCoughCheckTrue.isChecked()) {
            q5tally += 1;
        }
        if (!purpleCheckFalse.isChecked()) {
            q5tally += 1;
        }
        if (!flatearthCheckFalse.isChecked()) {
            q5tally += 1;
        }
        if (feverChecTrue.isChecked()) {
            q5tally += 1;
        }
        if (!humorCheckFalse.isChecked()) {
            q5tally += 1;
        }
        if (q5tally == 5) {
            totalCorrect += 1;
        }

        /* Answer 6 : Radio Button : Social Distance 1.5 Meters away */
        RadioButton answerSixRadio = (RadioButton) findViewById(R.id.q6_onepointfive);
        if (answerSixRadio.isChecked()) {
            totalCorrect += 1;
        }

        /* Answer 7 : Radio Button : Sign says Wear Mask */
        RadioButton answerSevenRadio = (RadioButton) findViewById(R.id.q7_wearmask);
        if (answerSevenRadio.isChecked()) {
            totalCorrect += 1;
        }

        /* DISPLAY THEN RESET SCORE */

        /* Show the result via Toast */

        String toastMessage;

        if (totalCorrect == totalQuestions) {
            toastMessage = "Congratulations you got 100%%\nYou are AWESOME!";
        } else if (totalCorrect > 0) {
            toastMessage = "You got " + totalCorrect + " out of " + totalQuestions + " correct!\nTry adjusting your answers and resubmit.";
        } else {
            toastMessage = "All your answers are incorrect\nTry adjusting your answers and resubmit";
        }

        Toast showToast = Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT);
        showToast.show();

        /* Reset the score */
        totalCorrect = 0;
    }
}