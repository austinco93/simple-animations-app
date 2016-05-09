package com.example.shakabreaux.corotanassignment3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class InstructionsActivity extends AppCompatActivity {

    ImageButton ret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        ret = (ImageButton) findViewById(R.id.retBtn);

        ret.setOnClickListener(rClickListener);
    }

    private View.OnClickListener rClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
