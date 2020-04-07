package com.example.ac_twitterclone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    ParseUser mUser;
    private TextView txtWelcomeMessage;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txtWelcomeMessage = findViewById(R.id.txtWelcomeMessage);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);
        txtWelcomeMessage.setText("Welcome "+ParseUser.getCurrentUser().getUsername());
    }

    @Override
    public void onClick(View v) {
        ParseUser.logOut();
        finish();
    }
}
