package com.example.vinit.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private Button cheat_button;
    private TextView cheat_text;

    private boolean answer;
    private static final String INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        cheat_text = (TextView) findViewById(R.id.cheat_text);
        cheat_button = (Button) findViewById(R.id.cheat_button);
        answer = getIntent().getBooleanExtra(INDEX,false);

        cheat_text.setText(answer ? "True":"False");
//        cheat_text.setText(String.valueOf(answer));

        cheat_button = (Button) findViewById(R.id.cheat_button);
        cheat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 //               Intent data = new Intent();
                setResult(RESULT_OK);
                finish();
            }
        });



    }

}
