package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView questionsTextView, trueAnswerTextView, falseAnswerTextView;
    Button trueButton, falseButton, nextQuestionButton;

    private ArrayList<String> questions = new ArrayList();
    private ArrayList<Boolean> answers = new ArrayList();

    private static int questionIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialzeViews();
        setupQuestionsAndAnswers();
        displayQuestion();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNextQuestion();
            }

        });
    }

    private void displayNextQuestion() {
        if (questionIndex < questions.size() - 1)
        {questionIndex++;
        displayQuestion();}

    }

    private void initialzeViews() {
        questionsTextView = findViewById(R.id.questionsTextView);
        trueAnswerTextView = findViewById(R.id.trueAnswerTextView);
        falseAnswerTextView = findViewById(R.id.falseAnswerTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
    }

    private void setupQuestionsAndAnswers() {
        questions.add("Android is an operating system.");
        answers.add(true);
        questions.add("Java is a programming language.");
        answers.add(true);
        questions.add("Swift is the programming for creating Android applications");
        answers.add(false);
    }

    private void displayQuestion() {
        String currentQuestion = questions.get(questionIndex);
        questionsTextView.setText(currentQuestion);

        nextQuestionButton.setVisibility(View.INVISIBLE);
        trueAnswerTextView.setVisibility(View.INVISIBLE);
        falseAnswerTextView.setVisibility(View.INVISIBLE);

        falseButton.setVisibility(View.VISIBLE);
        trueButton.setVisibility(View.VISIBLE);
    }

    private void checkAnswer(boolean answer) {
        boolean currentAnswer = answers.get(questionIndex);
        if (currentAnswer != answer) {
            showWrongAnswer();
        } else {
            showCorrectAnswer();
        }
    }

    private void showCorrectAnswer() {
        nextQuestionButton.setVisibility(View.VISIBLE);
        trueAnswerTextView.setVisibility(View.VISIBLE);
        falseAnswerTextView.setVisibility(View.INVISIBLE);
        falseButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.INVISIBLE);
    }

    private void showWrongAnswer() {
        nextQuestionButton.setVisibility(View.INVISIBLE);
        trueAnswerTextView.setVisibility(View.INVISIBLE);
        falseButton.setVisibility(View.VISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseAnswerTextView.setVisibility(View.VISIBLE);

    }
}