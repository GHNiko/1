package com.mezme.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    SeekBar timerBar;
    TextView timerTextView;
    Button startTimer;
    Boolean counterIsActive = false;
    CountDownTimer countDownTimer;
    MediaPlayer mplayer;


    public void resetTimer() {
        timerTextView.setText("0:30");
        timerBar.setProgress(30);
        countDownTimer.cancel();
        startTimer.setText("Start timer!");
        timerBar.setEnabled(true);
        counterIsActive = false;
    }

    public void updateTimer(int secondsLeft) {

        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        timerTextView.setText(Integer.toString(minutes) + ":" + Integer.toString(seconds));
    }

    public void startTimer(View view) {

        //Log.i("Button pressed!", "Pressed!");

        if (counterIsActive == false) {

            counterIsActive = true;
            timerBar.setEnabled(false);
            startTimer.setText("Stop");

            countDownTimer = new CountDownTimer(timerBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                    updateTimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {

                    resetTimer();
                    mplayer = MediaPlayer.create(getApplicationContext(), R.raw.eggmp3);
                    mplayer.start();
                    //Log.i("Fin.", "Finished!");
                }
            }.start();
        } else {
            resetTimer();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerBar = (SeekBar) findViewById(R.id.timerBar);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        startTimer = (Button)findViewById(R.id.startTimer);

        timerBar.setMax(600);
        timerBar.setProgress(30);

        timerBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
