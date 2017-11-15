package com.example.thaonguyenlp.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class ScoreActivity extends AppCompatActivity {

    DBManager dbManager;
    TextView scoreView;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent gameIntent = getIntent();
        name = gameIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        dbManager = new DBManager(ScoreActivity.this);
        scoreView = findViewById(R.id.scoreText);

        Cursor c = dbManager.getAllScore();
        String str="";
        if(c.moveToFirst())
        {
            do {
                str += c.getString(1) + "  ";
                str += c.getString(2) + "\n";
            }
            while(c.moveToNext());
        }
        scoreView.setText(str);

        Log.i("ScoreActivity tag", "now running score onCreate");
    }

    public void playGame(View view) {
        Intent intentGame = new Intent(this, GameActivity.class);
        intentGame.putExtra(MainActivity.EXTRA_MESSAGE, name);
        startActivity(intentGame);
        finish();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ScoreActivity tag", "now running score onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ScoreActivity tag", "now running score onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ScoreActivity tag", "now running score onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ScoreActivity tag", "now running score onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ScoreActivity tag", "now running score onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ScoreActivity tag", "now running score onDestroy");
    }

}
