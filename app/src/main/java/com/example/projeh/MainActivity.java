package com.example.projeh;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView login;
     EditText emailbox,passwordbox;
     Button loginB,submit;
     FirebaseAuth auth;
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        dialog=new ProgressDialog(this);
        dialog.setMessage("please waite...");
        login = findViewById(R.id.login);
        login.playAnimation();

         emailbox = findViewById(R.id.emailbox);
        passwordbox = findViewById(R.id.passwordbox);
        loginB = findViewById(R.id.loginbtn);
        submit=findViewById(R.id.createbtn);

    }
    public void onclickl(View v) {
        dialog.show();
     String email,password;
     email=emailbox.getText().toString();
     password=passwordbox.getText().toString();
     auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
if(task.isSuccessful())
{
dialog.dismiss();
    startActivity(new Intent(MainActivity.this, submit.class));
}
else{
    Toast.makeText(MainActivity.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
}
         }
     });

    }
    public void onclicke(View v) {
        startActivity(new Intent(MainActivity.this, dashboard.class));

    }
}