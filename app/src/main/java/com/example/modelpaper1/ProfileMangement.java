package com.example.modelpaper1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.modelpaper1.Database.DBhandler;

public class ProfileMangement extends AppCompatActivity {
    EditText username,password,dob;
    RadioButton male,female;
    Button updateProfile,add;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_mangement);

        username=findViewById(R.id.t6);
        password =findViewById(R.id.txt8);
        dob =findViewById(R.id.t7);
        male =findViewById(R.id.r1);
        female=findViewById(R.id.r2);
        updateProfile= findViewById(R.id.btn3);
        add= findViewById(R.id.btn4);

        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    gender ="male";
                }
                else
                    gender="female";

                DBhandler dbhandler = new DBhandler(getApplicationContext());
              long newId=  dbhandler.addInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileMangement.this, "User Adede .User ID:"+newId, Toast.LENGTH_SHORT).show();

                Intent i=new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);
            }
        });
    }


}