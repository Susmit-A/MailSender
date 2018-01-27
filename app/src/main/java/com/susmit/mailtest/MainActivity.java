package com.susmit.mailtest;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.susmit.mailsender.MailSender;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String url = "https://www.google.com/settings/security/lesssecureapps";

        final EditText email = findViewById(R.id.email);
        final EditText pass = findViewById(R.id.passwd);
        final EditText to = findViewById(R.id.remail);
        final EditText sub = findViewById(R.id.subject);
        final EditText content = findViewById(R.id.content);

        Button allow = findViewById(R.id.allow);
        final Button send = findViewById(R.id.send);

        allow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            String passw;
            String senderAddr;
            String recv;
            String subj;
            String cont;
            @Override
            public void onClick(View v) {
                senderAddr = email.getText().toString();
                recv = to.getText().toString();
                subj = sub.getText().toString();
                cont = content.getText().toString();
                passw = pass.getText().toString();
                new MailSender(senderAddr, passw).sendMailAsync(senderAddr,subj, cont);
            }
        });
    }
}
