package com.example.modelpaper1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    EditText username,password;
    Button login,Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username =findViewById(R.id.txt1);
        password =findViewById(R.id.txt2);
        login=findViewById(R.id.btn1);
        Register=findViewById(R.id.btn2);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent (getApplicationContext(),ProfileMangement.class);
                startActivity(i);

            }
        });
    }
}