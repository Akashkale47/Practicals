package com.example.smsmanagerapp.sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smsmanagerapp.R;
import com.example.smsmanagerapp.androidsqlite.AndroidSqliteActivity;
import com.example.smsmanagerapp.savedatatomemory.SaveDataToMemoryActivity;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 111;
    private EditText mobileNo, message_text;
    private Button sendSMSManager;
    String phoneNum;
    String msgText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileNo = (EditText) findViewById(R.id.mobnileNoEditText);
        message_text = (EditText) findViewById(R.id.messageEditText);
        sendSMSManager = (Button) findViewById(R.id.btnSend);
        sendSMSManager.setEnabled(false);
        if (checkPermission(Manifest.permission.SEND_SMS)) {
            sendSMSManager.setEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
        }
        sendSMSManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgText = message_text.getText().toString();
                phoneNum = mobileNo.getText().toString();
                if (!TextUtils.isEmpty(msgText) && !TextUtils.isEmpty(phoneNum)) {
                    if (checkPermission(Manifest.permission.SEND_SMS)) {
                        SmsManager smsmgr = SmsManager.getDefault();
                        smsmgr.sendTextMessage(phoneNum, null, msgText, null, null);
                        Toast.makeText(MainActivity.this, "SMS Sent..",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Permission Denied",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Mobile no. and Message should no empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkPermission(String permission) {
        int checkPermission = ContextCompat.checkSelfPermission(this, permission);
        return checkPermission == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[]
            permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS:
                if (grantResults.length > 0 && (grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED)) {
                    sendSMSManager.setEnabled(true);
                }
                break;
        }
    }

    public void next(View view) {
        Intent intent = new Intent(MainActivity.this, SaveDataToMemoryActivity.class);
        startActivity(intent);
    }
}

