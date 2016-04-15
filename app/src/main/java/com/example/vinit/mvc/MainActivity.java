package com.example.vinit.mvc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button isTrue;
    private Button isFalse;
    private Button next;
    private Button previous;
    private Button main_cheat;
    private TextView ques;
    private boolean cheat_done = false;

    private Question[] myQuestion = new Question[]{
            new Question(R.string.question1,true),
            new Question(R.string.question2,true),
            new Question(R.string.question3,true),
            new Question(R.string.question4,true),
            new Question(R.string.question5,false),
            new Question(R.string.question6,false),
            new Question(R.string.question7,true),
            new Question(R.string.question8,true),
            new Question(R.string.question9,false),
            new Question(R.string.question10,true),
    };
    int current = 0;
    private static final String TAG = "MainActivity";
    private static final String INDEX = "index";
    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isTrue = (Button) findViewById(R.id.isTrue);
        isFalse = (Button) findViewById(R.id.isFalse);
        main_cheat= (Button) findViewById(R.id.main_cheat_button);
        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);
        ques = (TextView) findViewById(R.id.text);
        ques.setText(R.string.question1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = (current + 1) % myQuestion.length;
                updateQuestion();
//                int cy = ques.getHeight()/2;
//                int cx = ques.getWidth()/2;
//                float radius = ques.getWidth();
//                Animator anim = ViewAnimationUtils
//                        .createCircularReveal(ques, cx, cy, radius, 0);
//                anim.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                        ques.setVisibility(View.VISIBLE);
//                        ques.setVisibility(View.INVISIBLE);
//                        ques.setVisibility(View.VISIBLE);
//                    }
//                });
//                anim.start();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                current = (current-1)% myQuestion.length;
                current = (current == 0 ? myQuestion.length-1: current-1 );
                updateQuestion();
            }
        });

        isTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(true);
            }
        });
        isFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(false);
            }
        });
        main_cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CheatActivity.class);
                i.putExtra(INDEX,myQuestion[current].getAns());
                startActivityForResult(i,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(REQUEST_CODE != requestCode){
            return;
        }else{
            if(resultCode != Activity.RESULT_OK){
                return;
            }
            else{
                cheat_done = true;
            }
        }
    }

    public void updateQuestion(){
        int ques1 = myQuestion[current].getQuestionId();
        ques.setText(ques1);
    }
    public void checkAns(boolean userAns){
        boolean actualAns = myQuestion[current].getAns();
        int res;
        if(cheat_done){
            res = R.string.cheat_toast;
            cheat_done=false;
        }
        else {
            if (actualAns == userAns) {
                res = R.string.correct;
            } else {
                res = R.string.incorrect;
            }
        }
        Toast.makeText(this,res,Toast.LENGTH_SHORT).show();
    }
}
