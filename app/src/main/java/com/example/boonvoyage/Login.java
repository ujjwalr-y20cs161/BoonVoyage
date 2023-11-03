package com.example.boonvoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    TextInputEditText emailId,password;
    Button login,register,forgetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        theme

//        linking of UI

        emailId = findViewById(R.id.emailfield);
        password = findViewById(R.id.passwordfield);

        login = findViewById(R.id.sign_in);
        register = findViewById(R.id.sign_up);
        forgetPassword = findViewById(R.id.pswdfrgt);

//        Listeners of Buttons

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Login Button Action
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                register action
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//        forgetPassword
            }
        });



    }
}