package com.example.ac_twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtName,edtPunchSpeed,edtPunchPower,edtKickSpeed,edtKickPower;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        edtName = findViewById(R.id.edtName);
        edtPunchSpeed = findViewById(R.id.edtPunchSpeed);
        edtPunchPower = findViewById(R.id.edtPunchPower);
        edtKickPower = findViewById(R.id.edtKickPower);
        edtKickSpeed = findViewById(R.id.edtKickSpeed);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            final ParseObject kickBoxer = new ParseObject("KickBoxer");
            kickBoxer.put("name",edtName.getText().toString());
            kickBoxer.put("punchSpeed",Integer.parseInt(edtPunchSpeed.getText().toString()));
            kickBoxer.put("punchPower",Integer.parseInt(edtPunchPower.getText().toString()));
            kickBoxer.put("kickSpeed",Integer.parseInt(edtKickSpeed.getText().toString()));
            kickBoxer.put("kickPower",Integer.parseInt(edtKickPower.getText().toString()));
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null){
                        FancyToast.makeText(getApplicationContext(),kickBoxer.
                                get("name")+" is saved successfully!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                    }else {
                        FancyToast.makeText(getApplicationContext(),
                                e.getMessage()+" ",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
                    }
                }
            });


        }catch (Exception e){
            FancyToast.makeText(getApplicationContext(),
                    e.getMessage()+" ",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
        }
    }
    /* public void pushDataIntoServer(View v){

        ParseObject boxer = new ParseObject("Boxer");
        boxer.put("punchSpeed",200);
        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    Toast.makeText(getApplicationContext(),
                            "Data is successfully saved in parse server",Toast.LENGTH_SHORT).show();
                }
            }
        });

        final ParseObject kickBoxer = new ParseObject("KickBoxer");
        kickBoxer.put("name","John");
        kickBoxer.put("punchSpeed",300);
        kickBoxer.put("punchPower","500");
        kickBoxer.put("kickSpeed",600);
        kickBoxer.put("kickPower",700);
        kickBoxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    Toast.makeText(getApplicationContext(),
                            kickBoxer.get("name")+" is successfully saved in parse server",Toast.LENGTH_SHORT).show();
                }
            }
        });*/
}