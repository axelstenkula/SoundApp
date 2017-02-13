package com.example.axst.soundapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    public final static String ABOUT = "com.example.axst.soundapp.AboutActivity";
    public final static String SOUND_FILE = "com.example.axst.soundapp.SoundFile";
    public final static String SOUND_URI = "com.example.axst.soundapp.SoundUri";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
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

    public void openAbout(View view) {

        Intent intent = new Intent(this, AboutActivity.class);
        // https://developer.android.com/training/basics/firstapp/starting-activity.html
       // EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(ABOUT, message);
        startActivity(intent);

    }

    public void playClip1(View view) {
        Intent intent = new Intent(this, SoundViewActivity.class);
        // https://developer.android.com/training/basics/firstapp/starting-activity.html
        intent.putExtra(SOUND_FILE, "sound1.wav");
        intent.putExtra(SOUND_URI, R.raw.sound1);
        startActivity(intent);

    }

    public void playClip2(View view) {
        Intent intent = new Intent(this, SoundViewActivity.class);
        // https://developer.android.com/training/basics/firstapp/starting-activity.html
        intent.putExtra(SOUND_FILE, "sound2.wav");
        intent.putExtra(SOUND_URI, R.raw.sound2);
        startActivity(intent);

    }

    public void playClip3(View view) {
        Intent intent = new Intent(this, SoundViewActivity.class);
        // https://developer.android.com/training/basics/firstapp/starting-activity.html
        intent.putExtra(SOUND_FILE, "sound3.wav");
        intent.putExtra(SOUND_URI, R.raw.sound3);
        startActivity(intent);

    }


}
