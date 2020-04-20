package com.example.smsmanagerapp.androidsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smsmanagerapp.R;

public class RegistrationActivity extends AppCompatActivity {
    RegistrationAdapter adapter;
    RegistrationOpenHelper helper;
    EditText fnameEdit, lnameEdit;
    Button submitBtn, resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fnameEdit = (EditText) findViewById(R.id.et_fname);
        lnameEdit = (EditText) findViewById(R.id.et_lname);
        submitBtn = (Button) findViewById(R.id.btn_submit);
        resetBtn = (Button) findViewById(R.id.btn_reset);
        adapter = new RegistrationAdapter(this);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                String fnameValue = fnameEdit.getText().toString();
                String lnameValue = lnameEdit.getText().toString();
                if (fnameValue.length() != 0 && lnameValue.length() != 0) {
                    long val = adapter.insertDetails(fnameValue, lnameValue);
// Toast.makeText(getApplicationContext(), Long.toString(val),
// 300).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Enter all fields.. ",Toast.LENGTH_LONG).show();
                }
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                fnameEdit.setText("");
                lnameEdit.setText("");
            }
        });
    }
}
