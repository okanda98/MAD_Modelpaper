package com.example.modelpaper1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.modelpaper1.Database.DBhandler;

import java.util.List;

public class EditProfile extends AppCompatActivity {
    EditText username,password,dob;
    RadioButton male,female;
    Button edit,delete,search;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        username=findViewById(R.id.t1);
        password =findViewById(R.id.t3);
        dob =findViewById(R.id.t2);
        male =findViewById(R.id.r3);
        female=findViewById(R.id.r4);
        edit= findViewById(R.id.btn6);
        delete= findViewById(R.id.btn7);
        search=findViewById(R.id.btn5);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhandler dbhandler = new DBhandler(getApplicationContext());
                List user =dbhandler.readAllInfo(username.getText().toString());

                if(user.isEmpty()){
                    Toast.makeText(EditProfile.this, "no users", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                }
                else
                {
                    username.setText(user.get(0).toString());
                    dob.setText(user.get(1).toString());
                    password.setText(user.get(2).toString());
                    if((user.get(3).toString().equals("male"))){
                        male.setChecked(true);
                    }
                    else
                        female.setChecked(true);
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(male.isChecked()){
                    gender ="male";
                }
                else
                    gender="female";

                DBhandler dbhandler = new DBhandler(getApplicationContext());
                Boolean status= dbhandler.updateInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                if(status){
                    Toast.makeText(EditProfile.this, "updated sucessfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(EditProfile.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}