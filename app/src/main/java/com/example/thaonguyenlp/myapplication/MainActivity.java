package com.example.thaonguyenlp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.thaonguyenlp.myapplication.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity tag", "now running main onCreate");
    }

    public void playGame(View view) {
        Intent intentGame = new Intent(this, GameActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString().trim();
        if(!message.equals("")){
            intentGame.putExtra(EXTRA_MESSAGE, message);
            startActivity(intentGame);
        }else{
            Toast.makeText(this, "Please input name", Toast.LENGTH_LONG).show();
        }
    }

    public void clickQuit(View view) {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity tag", "now running main onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity tag", "now running main onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity tag", "now running main onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity tag", "now running main onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity tag", "now running main onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity tag", "now running main onDestroy");
    }
}
