package com.intprog.araneta_sharedprefernces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userInput, passInput;
    Button regIn;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_USER = "user";
    private  static final String KEY_PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.userin);
        passInput = findViewById(R.id.passin);
        regIn = findViewById(R.id.regbtn);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String user = sharedPreferences.getString(KEY_USER, null);
        String pass = sharedPreferences.getString(KEY_PASS, null);

        if (user!= null && pass != null){
            Intent logs = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(logs);
        }

        regIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_USER, userInput.getText().toString());
                    editor.putString(KEY_PASS, passInput.getText().toString());
                    editor.apply();

                Intent navtoHome = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(navtoHome);

                Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_LONG).show();
            }
        });
    }
}