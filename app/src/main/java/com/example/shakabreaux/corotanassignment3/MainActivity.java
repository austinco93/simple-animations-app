package com.example.shakabreaux.corotanassignment3;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivTitle;
    ImageButton ivStart;
    ImageButton ivIns;

    MediaPlayer introSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up title animation
        ivTitle = (ImageView) findViewById(R.id.ivTitle);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
        ivTitle.startAnimation(hyperspaceJumpAnimation);

        //set up intro sound
        introSound = MediaPlayer.create(this, R.raw.chillplantsound);
        introSound.start();

        //set up intro screen buttons
        ivStart = (ImageButton) findViewById(R.id.ivstart);
        ivStart.setOnClickListener(mClickListener);
        ivIns = (ImageButton) findViewById(R.id.ivinstructions);
        ivIns.setOnClickListener(mClickListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        introSound.stop();
    }
    @Override
    protected void onResume() {
        super.onResume();
        introSound.stop();
        introSound = MediaPlayer.create(this, R.raw.chillplantsound);
        introSound.start();
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
        ivTitle.startAnimation(hyperspaceJumpAnimation);
    }
    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == ivStart) {
                startActivity(new Intent(MainActivity.this, PlantActivity.class));
            } else {
                startActivity(new Intent(MainActivity.this, InstructionsActivity.class));
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
