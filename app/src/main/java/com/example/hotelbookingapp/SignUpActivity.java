package com.example.hotelbookingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    EditText emailID,password,password1;
    Button signUp;
    TextView login_if_member;
    FirebaseAuth mfirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//        Button signup=findViewById(R.id.sign_up_btn);
//        TextView login_if_member =findViewById(R.id.login_if_member);
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(SignUpActivity.this, "sign up", Toast.LENGTH_SHORT).show();
//            }
//        });
////        login_if_member.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Toast.makeText(SignUpActivity.this, "login", Toast.LENGTH_SHORT).show();
////            }
////        });
        mfirebaseAuth=FirebaseAuth.getInstance();
        emailID=findViewById(R.id.sign_up_email);
        password=findViewById(R.id.sign_up_password);
        password1=findViewById(R.id.sign_up_password1);
        signUp=findViewById(R.id.sign_up_btn);
        login_if_member=findViewById(R.id.login_if_member);
        //set what happens when user clicks signup button
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailID.getText().toString();
                String pass=password.getText().toString();
                String pass1=password1.getText().toString();
                if(email.isEmpty()){
                    emailID.setError("Please enter email");
                    emailID.requestFocus();
                }
                else if(pass.isEmpty()){
                   password.setError("please enter password");
                   password.requestFocus();
                }
                else if(pass1.isEmpty()){
                   password1.setError("please enter confirmation password");
                   password1.requestFocus();
                }
                else if(email.isEmpty() && pass.isEmpty() && pass1.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pass.isEmpty() && pass1.isEmpty())){
                    if(!(pass.equals(pass1))){
                        Toast.makeText(SignUpActivity.this, "passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        mfirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(!task.isSuccessful()){
                                    Toast.makeText(SignUpActivity.this, "Sign Up failed .Try again", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                                }
                            }
                        });
                    }
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        login_if_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }

}
