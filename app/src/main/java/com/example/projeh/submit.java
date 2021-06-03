package com.example.projeh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class submit extends AppCompatActivity {
    FirebaseAuth auth;
EditText emailbox,passwordbox,passwordbox1,namebox;
Button loginbtn,createbtn;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        auth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();
        emailbox =findViewById(R.id.emailbox);
        passwordbox = findViewById(R.id.passwordbox);
        passwordbox1=findViewById(R.id.passwordbox2);
        namebox=findViewById(R.id.namebox);
        loginbtn=findViewById(R.id.loginbtn);
        createbtn=findViewById(R.id.createbtn);

    }
    public void onclick(View v) {
        String email, pass,pass1 ,name;
        pass = passwordbox.getText().toString();
        email = emailbox.getText().toString();
        name = namebox.getText().toString();
        pass1=passwordbox1.getText().toString();
        Member member=new Member();
        member.setEmail(email);
        member.setPass(pass);
        member.setName(name);
        if (pass.equals(pass1)) {
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        db.collection("members").document().set(member).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(submit.this, MainActivity.class));

                            }
                        });
                        Toast.makeText(submit.this, "your account is cteated", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(submit.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
       }else {
            Toast.makeText(submit.this, "the password not match", Toast.LENGTH_SHORT).show();
        }
        }
    public void onclick1(View v) {
        startActivity(new Intent(submit.this, MainActivity.class));

    }

}


