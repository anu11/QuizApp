package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    boolean isQuestion1Correct;
    boolean isQuestion4Correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is going to be called when user submits answers
      */
     public void submitAnswer(View view){
         score = 0;

         score = isQuestion1Correct ? ++score : score;
         score = isQuizQuestion2Correct() ? ++score : score;
         score = isQuizQuestion3Correct() ? ++score : score;
         score = isQuestion4Correct ? ++score : score;
         score = isQuizQuestion5Correct() ? ++score : score;

         Toast.makeText(this,"Your Score for the quiz: " + score,Toast.LENGTH_SHORT).show();

     }

    /**
     * quiz question 3
     */
    public boolean isQuizQuestion3Correct(){
        EditText textInput = (EditText) findViewById(R.id.question3_edittext);
        boolean answerEntered = textInput.getText().toString().equalsIgnoreCase("Mumbai");
        if(answerEntered){
            return true;
        }else{
            return false;
        }
    }

    /**
     * quiz question 2
     */

    public boolean isQuizQuestion2Correct() {
        CheckBox isChinese = (CheckBox) findViewById(R.id.checkbox_chinese);
        boolean isChineseChecked = isChinese.isChecked();

        CheckBox isBengali = (CheckBox) findViewById(R.id.checkbox_bengali);
        boolean isBengaliChecked = isBengali.isChecked();

        CheckBox isMarathi = (CheckBox) findViewById(R.id.checkbox_marathi);
        boolean isMarathiChecked = isMarathi.isChecked();

        if (isChineseChecked) {
            return false;
        }
        if (isBengaliChecked && isMarathiChecked) {
            return true;
        }

        return false;
    }

    /**
     * quiz question 1
     */


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        isQuestion1Correct = false;
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioOption1:
                if (checked)
                    isQuestion1Correct = true;
                    break;
            case R.id.radioOption2:
                if (checked)
                    break;
            case R.id.radioOption3:
                if (checked)
                    break;
        }
    }

    /**
     * quiz question 4
     */

    public void onRadioButtonClickedQues4(View view) {
        isQuestion4Correct = false;
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio2Option1:
                if (checked)
                break;
            case R.id.radio2Option2:
                if (checked)
                    isQuestion4Correct = true;
                    break;
            case R.id.radio2Option3:
                if (checked)
                    break;
        }
    }

    /**
     * quiz question 5
     */
    public boolean isQuizQuestion5Correct(){
        EditText textInputQ5 = (EditText) findViewById(R.id.editTextQuestion5);
        boolean isAnswereCorrect = textInputQ5.getText().toString().equalsIgnoreCase("Pichola");
        return isAnswereCorrect;
    }

}
