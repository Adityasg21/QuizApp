package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class JavaQuiz extends AppCompatActivity {

    private TextView optionA,optionB,optionC,optionD;
    private TextView questionnumber,question,score;
    private TextView chechkout1,checkout2;
    int currentIndex;
    int mscore=0;
    int qn=1;
    ProgressBar progressBar;

    int CurrentQuestion,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;



    private answerclass[] questionBank= new answerclass[]
            {
                    new answerclass(R.string.question_11,R.string.question11_A,R.string.question11_B,R.string.question11_C,R.string.question11_D,R.string.answer_11),
                    new answerclass(R.string.question_21,R.string.question_21A,R.string.question_21B,R.string.question_21C,R.string.question_21D,R.string.answer_21),
                    new answerclass(R.string.question_31,R.string.question_31A,R.string.question_31B,R.string.question_31C,R.string.question_31D,R.string.answer_31),
                    new answerclass(R.string.question_41,R.string.question_41A,R.string.question_41B,R.string.question_41C,R.string.question_41D,R.string.answer_41),
                    new answerclass(R.string.question_51,R.string.question_51A,R.string.question_51B,R.string.question_51C,R.string.question_51D,R.string.answer_51),
                    new answerclass(R.string.question_61,R.string.question_61A,R.string.question_61B,R.string.question_61C,R.string.question_61D,R.string.answer_61),
                    new answerclass(R.string.question_71,R.string.question_71A,R.string.question_71B,R.string.question_71C,R.string.question_71D,R.string.answer_71),
                    new answerclass(R.string.question_81,R.string.question_81A,R.string.question_81B,R.string.question_81C,R.string.question_81D,R.string.answer_81),
                    new answerclass(R.string.question_91,R.string.question_91A,R.string.question_91B,R.string.question_91C,R.string.question_91D,R.string.answer_91),
                    new answerclass(R.string.question_101,R.string.question_101A,R.string.question_101B,R.string.question_101C,R.string.question_101D,R.string.answer_101),




            };

    final int PROGRESS_BAR = (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);

        question = findViewById(R.id.question);
        score=findViewById(R.id.score);
        questionnumber=findViewById(R.id.QuestionNumber);

        chechkout1=findViewById(R.id.selectoption);
        checkout2=findViewById(R.id.CorrectAnswer);
        progressBar=findViewById(R.id.progress_bar);

        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionA);
                updateQuestion();

            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionB);
                updateQuestion();


            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionC);
                updateQuestion();


            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(CurrentOptionD);
                updateQuestion();

            }
        });

    }

    private void checkAnswer(int userSelection) {

        int correctanswer=questionBank[currentIndex].getAnswerid();

        chechkout1.setText(userSelection);
        checkout2.setText(correctanswer);

        String m= chechkout1.getText().toString().trim();
        String n=checkout2.getText().toString().trim();

        if(m.equals(n))
        {
            Toast.makeText(getApplicationContext(),"Right",Toast.LENGTH_SHORT).show();
            mscore=mscore+1;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
        }




    }

    @SuppressLint("SetTextI18n")
    private void updateQuestion() {

        currentIndex=(currentIndex+1)%questionBank.length;

        if(currentIndex==0)
        {

            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score " + mscore +" points");
            alert.setPositiveButton((Html.fromHtml("<font color='#FF7F27'>close quiz</font>")), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alert.setNegativeButton((Html.fromHtml("<font color='#FF7F27'>restart quiz</font>")), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Score" + mscore +"/" +questionBank.length);
                    questionnumber.setText(qn + "/" + questionBank.length +"Question");
                }
            });

            alert.show();
        }



        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        qn=qn+1;

        if(qn<=questionBank.length)

        {
            questionnumber.setText(qn + "/" + questionBank.length +"Question");
        }
        score.setText("Score" + mscore +"/" +questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);


    }

}