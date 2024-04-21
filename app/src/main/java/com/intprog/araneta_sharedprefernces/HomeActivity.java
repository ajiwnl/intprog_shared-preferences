package com.intprog.araneta_sharedprefernces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView userHome, passHome;
    Button logOut;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_USER = "user";
    private  static final String KEY_PASS = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userHome = findViewById(R.id.userhome);
        passHome = findViewById(R.id.passhome);
        logOut = findViewById(R.id.outbtn);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String sh_user = sharedPreferences.getString(KEY_USER, null);
        String sh_pass = sharedPreferences.getString(KEY_PASS, null);

        if (sh_user!= null || sh_pass != null){
            userHome.setText(" "+sh_user);
            passHome.setText(" "+sh_pass);
        }

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this,"Logout successful", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}