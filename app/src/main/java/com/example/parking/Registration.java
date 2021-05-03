package com.example.parking;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
EditText name,email,pass,passConf;
Button SignUp ;
TextView Login;
String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
FirebaseAuth auth;
FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
// Declare every variable that use in layout
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass1);
        passConf = findViewById(R.id.pass2);
        SignUp = findViewById(R.id.singup);

        SignUp.setOnClickListener(v -> {
            String Name = name.getText().toString();
           String mail = email.getText().toString().trim();
           String Password = pass.getText().toString();
           String PasswordConfirm = passConf.getText().toString().trim();

           // Add some conditions to check before registration
            if(TextUtils.isEmpty(Name)||TextUtils.isEmpty(mail)||TextUtils.isEmpty(Password)||TextUtils.isEmpty(PasswordConfirm)){
                Toast.makeText(this, "Enter Valid Information", Toast.LENGTH_SHORT).show();
            }else if(!mail.matches(emailPattern)){
                Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
            }else if(!Password.matches(PasswordConfirm)){
                Toast.makeText(this, "Confirm Password Should be same as Password", Toast.LENGTH_SHORT).show();
            }else if(Password.length()<6){
                Toast.makeText(this, "Password Should be Greater than 6 characters", Toast.LENGTH_SHORT).show();
            }else {

                auth.createUserWithEmailAndPassword(mail,Password).addOnCompleteListener(task -> {

                    if (task.isSuccessful()){
                        //Toast.makeText(Registration.this, "Registration done", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(Registration.this,Dashboard.class));

                        DatabaseReference reference = database.getReference().child("users").child(auth.getUid());

                        Users users = new Users(auth.getUid(),Name,mail);
                        reference.setValue(users);
                        name.setText(" ");
                        email.setText(" ");
                        pass.setText(" ");
                        passConf.setText(" ");
                    }
                    else{
                        Toast.makeText(Registration.this, "Error In Registration", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




        // Back to Login Page Through this Link
        Login = findViewById(R.id.logIn);

    Login.setOnClickListener(v -> startActivity(new Intent(Registration.this,Login.class)));
    }
}