package com.example.shakabreaux.corotanassignment3;

import android.app.ActivityManager;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class PlantActivity extends AppCompatActivity {

    //RelativeLayout bgAnim;
    FrameLayout area1, area2;
    ImageView initView, dragTo, fstView, secView, finalView;
    ImageButton retBtn;
    MediaPlayer soundEffect;
    MediaPlayer finalsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        retBtn = (ImageButton) findViewById(R.id.returnBtn);
        retBtn.setOnClickListener(rClickListener);

        soundEffect = MediaPlayer.create(this, R.raw.spring);
        finalsound = MediaPlayer.create(this,R.raw.chillplantsound);
        area1 = (FrameLayout) findViewById(R.id.area1);
        area2 = (FrameLayout) findViewById(R.id.area2);

        initView = (ImageView) findViewById(R.id.initView);
        initView.setTag(R.drawable.animplant);

        fstView = (ImageView) findViewById(R.id.fstView);
        secView = (ImageView) findViewById(R.id.secView);
        finalView = (ImageView) findViewById(R.id.finalView);

        dragTo = (ImageView) findViewById(R.id.dragTo);

        initView.setOnLongClickListener(myOnLongClickListener);
        initView.setOnClickListener(mClickListener);
        area1.setOnDragListener(myOnDragListener);
        area2.setOnDragListener(myOnDragListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finalsound.stop();
    }
    private View.OnClickListener rClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finalsound.stop();
            finish();
        }
    };

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getParent() == area1) {
                if ((Integer) v.getTag() == R.drawable.animplant) {
                    secView.setImageDrawable(null);
                    soundEffect.start();
                    v.getLayoutParams().height = 355;
                    v.getLayoutParams().width = 400;
                    v.requestLayout();
                    ((ImageView) v).setImageResource(R.drawable.animplant1);
                    v.setTag(R.drawable.animplant1);
                    v.setOnClickListener(m2ClickListener);
                }
            }
        }
    };

    private View.OnClickListener m2ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getParent() == area1) {
                if ((Integer) v.getTag() == R.drawable.animplant1) {
                    soundEffect.start();
                    v.getLayoutParams().height = 500;
                    v.getLayoutParams().width = 400;
                    v.requestLayout();
                    ((ImageView) v).setImageResource(R.drawable.animplant2);
                    v.setTag(R.drawable.animplant2);
                    v.setOnClickListener(m3ClickListener);
                }
            }
        }
    };

    private View.OnClickListener m3ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getParent() == area1) {
                if ((Integer) v.getTag() == R.drawable.animplant2) {
                    soundEffect.start();
                    v.getLayoutParams().height = 600;
                    v.getLayoutParams().width = 400;
                    v.requestLayout();
                    ((ImageView) v).setImageResource(R.drawable.animplant3);
                    v.setTag(R.drawable.animplant3);
                    v.setOnClickListener(m4ClickListener);
                }
            }
        }
    };

    private View.OnClickListener m4ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getParent() == area1) {
                if ((Integer) v.getTag() == R.drawable.animplant3) {
                    soundEffect.start();
                    v.getLayoutParams().height = 650;
                    v.getLayoutParams().width = 400;
                    v.requestLayout();
                    ((ImageView) v).setImageResource(R.drawable.animplant4);
                    v.setTag(R.drawable.animplant4);
                    v.setOnClickListener(m5ClickListener);

                }
            }
        }
    };

    private View.OnClickListener m5ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            if (v.getParent() == area1) {
                if ((Integer) v.getTag() == R.drawable.animplant4) {
                    soundEffect.start();
                    v.getLayoutParams().height = 700;
                    v.getLayoutParams().width = 400;
                    v.requestLayout();
                    ((ImageView) v).setImageDrawable(null);
                    ((ImageView) v).setBackgroundResource(R.drawable.plantbg_animation);
                    v.setTag(R.drawable.plantbg_animation);
                    finalsound.start();
                    finalView.setImageResource(R.drawable.finalmsg2);
                    Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hyperspace_jump);
                    finalView.startAnimation(hyperspaceJumpAnimation);
                    v.post(new Runnable() {
                        @Override
                        public void run() {
                            ((AnimationDrawable) v.getBackground()).start();
                        }
                    });
                }
            }
        }
    };

    View.OnLongClickListener myOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, shadowBuilder, v, 0);
            //v.setVisibility(View.INVISIBLE);
            return true;
        }
    };

    View.OnDragListener myOnDragListener = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            String area;
            if(v == area1){
                area = "area1";
            }else if(v == area2){
                area = "area2";
            }else{
                area = "unknown";
            }

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    View view = (View)event.getLocalState();
                    FrameLayout oldParent = (FrameLayout)view.getParent();
                    oldParent.removeView(view);
                    fstView.setImageDrawable(null);
                    FrameLayout newParent = (FrameLayout)v;
                    newParent.removeAllViews();
                    newParent.addView(view);
                    secView.setImageResource(R.drawable.secondmsg);
                    view.getLayoutParams().height = 300;
                    view.getLayoutParams().width = 400;
                    view.requestLayout();
                    view.setOnClickListener(mClickListener);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    };
}
