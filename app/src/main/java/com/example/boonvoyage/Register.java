package com.example.boonvoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    TextInputEditText firstName,lastName,age,phoneNumber,email,password,confirmPassword;
    Button confirm;
    MaterialAutoCompleteTextView genderField;
    TextInputLayout menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


//        initialization :
         genderField = findViewById(R.id.genderfield);
         menu = findViewById(R.id.menu);

         firstName = findViewById(R.id.firstnamefield);
         lastName = findViewById(R.id.lastnamefield);
         email = findViewById(R.id.emailfield);
         age = findViewById(R.id.agefield);
         password = findViewById(R.id.passwordfield);
         confirmPassword = findViewById(R.id.confirm_passwordfield);
         confirm = findViewById(R.id.confirmRegistration);
         phoneNumber = findViewById(R.id.phonefield);

         confirm.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (firstName.getText().toString().trim().isEmpty()) {
                     firstName.setError("First name is required");
                     firstName.requestFocus();
                     return;
                 }

                 if (lastName.getText().toString().trim().isEmpty()) {
                     lastName.setError("Last name is required");
                     lastName.requestFocus();
                     return;
                 }

                 // Validate age
                 if (age.getText().toString().trim().isEmpty()) {
                     age.setError("Age is required");
                     age.requestFocus();
                     return;
                 }

                 if (Integer.parseInt(age.getText().toString().trim()) <= 17) {
                     age.setError("Should be major");
                     age.requestFocus();
                     return;
                 }



                 if (genderField.getText().toString().trim().isEmpty()) {
                     // No gender selected
                     menu.setError("Gender Should be Selected");
                     menu.requestFocus();
                     return;
                 }
                 if (!Patterns.PHONE.matcher(phoneNumber.getText().toString().trim()).matches()) {
                     phoneNumber.setError("Phone Number is required");
                     phoneNumber.requestFocus();
                     return;
                 }

                 // Validate email
                 if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches() && email.getText().toString().trim().isEmpty()) {
                     email.setError("Invalid email address");
                     email.requestFocus();
                     return;
                 }

                 // Validate password
                 if (password.getText().toString().trim().isEmpty()) {
                     password.setError("Password is required");
                     password.requestFocus();
                     return;
                 }

                 // Validate confirm password
                 if (!password.getText().toString().trim().equals(confirmPassword.getText().toString().trim())) {
                     confirmPassword.setError("Passwords do not match");
                     confirmPassword.requestFocus();
                     return;
                 }

                 Toast.makeText(Register.this, "Hello there! You've successfully registered!", Toast.LENGTH_SHORT).show();
             }
         });
    }
}