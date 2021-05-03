package com.example.parking;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    TextView signUp ;
    EditText Email , Password;
    Button signIn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUp = findViewById(R.id.signUp);
        signIn = findViewById(R.id.SignIn);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(v -> {
            startActivity(new Intent(Login.this,Registration.class));
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String pass = Password.getText().toString().trim();

                // check the details and validation
                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)){
                    Toast.makeText(Login.this, "Enter the Information", Toast.LENGTH_SHORT).show();
                }else  if(!email.matches(emailPattern)){
                    Toast.makeText(Login.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                }else if(pass.length()<6){
                    Toast.makeText(Login.this, "Password Should be Greater than 6 characters", Toast.LENGTH_SHORT).show();
                }else {
                    // check email address that user enters
                    auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(Login.this, Dashboard.class));
                        } else {
                            Toast.makeText(Login.this, "InValid Details", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}