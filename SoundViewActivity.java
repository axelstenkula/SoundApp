package com.example.axst.soundapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import android.content.Intent;

public class SoundViewActivity extends AppCompatActivity {

    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button1Play = (Button) findViewById(R.id.buttonPlayClip1);
        button1Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    button1Play(view);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button button1Stop = (Button) findViewById(R.id.buttonStopClip1);
        button1Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1Stop(view);
            }
        });

        Button button1Pause = (Button) findViewById(R.id.buttonPauseClip1);
        button1Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1Pause(view);
            }
        });

    }

    private void button1Pause(View view) {
        if (mp != null) {
            mp.pause();
        }
    }

    private void button1Play(View view) throws IOException {
        Intent intent = getIntent();
        String clip = intent.getStringExtra(MainActivity.SOUND_FILE);
        int uri = intent.getIntExtra(MainActivity.SOUND_URI, 0);

        String path = "res/raw/" + clip;
        Snackbar.make(view, "Playing..." + path, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();


        if (mp == null && uri != 0) {
            mp = MediaPlayer.create(getApplicationContext(), uri);
        }
        //  mp = new MediaPlayer();
        //mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //mp.setDataSource(getApplicationContext(), R.raw.sound1);
        //mp.prepare();
        mp.start();

        // Uri myUri = ....; // initialize Uri here
        //MediaPlayer mediaPlayer = new MediaPlayer();
        //mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //mediaPlayer.setDataSource(getApplicationContext(), myUri);
        //mediaPlayer.prepare();
        //mediaPlayer.start();
        //mp.start();

    }

    private void button1Stop(View view) {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }

    }

}
