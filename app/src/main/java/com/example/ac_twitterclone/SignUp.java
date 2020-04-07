package com.example.ac_twitterclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUserName, edtUserPassword, edtLoginUserName, edtLoginUserPassword;
    private Button btnSignUp, btnUserLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtUserName = findViewById(R.id.edtUserName);
        edtUserPassword = findViewById(R.id.edtUserPassword);
        edtLoginUserName = findViewById(R.id.edtLoginUserName);
        edtLoginUserPassword = findViewById(R.id.edtLoginUserPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnUserLogin = findViewById(R.id.btnUserLogin);
        btnSignUp.setOnClickListener(this);
        btnUserLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUp:
                final ParseUser appUser = new ParseUser();
                appUser.setUsername(edtUserName.getText().toString());
                appUser.setPassword(edtUserPassword.getText().toString());
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            FancyToast.makeText(getApplicationContext(), appUser.getUsername() + " is sign up successfully!"
                                    , Toast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                        }
                    }
                });
                break;
            case R.id.btnUserLogin:
                ParseUser.logInInBackground(edtLoginUserName.getText().toString(), edtLoginUserPassword.getText().toString(),
                        new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if (e == null) {

                                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                                    startActivity(intent);
                                    FancyToast.makeText(getApplicationContext(), user.getUsername() + " is logged up successfully!"
                                            , Toast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();

                                } else {
                                    FancyToast.makeText(getApplicationContext(), e.getMessage() + ""
                                            , Toast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                                }

                            }
                        });


        }
    }
}
