package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,subject,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.t1);
        subject = findViewById(R.id.t2);
        message = findViewById(R.id.t3);
    }


    public void SendTo(View view) {
        String mEmail = email.getText().toString();
        String mSubject = subject.getText().toString();
        String mMessage = message.getText().toString();


        JavaMailApi javaMailApi = new JavaMailApi(this, mEmail, mSubject, mMessage);

        javaMailApi.execute();

        Toast.makeText(this, "Mail Sent to " + mEmail, Toast.LENGTH_SHORT).show();
        email.setText("");
        subject.setText("");
        message.setText("");
        email.requestFocus();
    }

    public void ClearAll(View view) {
        email.setText("");
        subject.setText("");
        message.setText("");
        email.requestFocus();
        }

    public void Msg(View view) {

        startActivity(new Intent(this,Message.class));
    }
}