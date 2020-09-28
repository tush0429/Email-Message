package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Message extends AppCompatActivity {
        EditText a,b;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_message);

            a = findViewById(R.id.t1);
            b = findViewById(R.id.t2);

        }

        public void Msgkar(View view) {
            String phMo = a.getText().toString().trim();
            String Msg = b.getText().toString().trim();


            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                if(checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
                {
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phMo, null, Msg, null, null);
                        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        Toast.makeText(this, "Failed to Send", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                }
            }

        }

        public void ClearKar(View view) {
            a.setText("");
            b.setText("");
            a.requestFocus();

        }
}