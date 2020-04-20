package com.example.smsmanagerapp.savedatatomemory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smsmanagerapp.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SaveDataToMemoryActivity extends AppCompatActivity {
    EditText edittext;
    Button btnSave, btnLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data_to_memory);
        edittext = (EditText) findViewById(R.id.et_message);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnLoad = (Button) findViewById(R.id.btn_load);
        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String message = edittext.getText().toString();
                if (!message.isEmpty())
                {
                    try {
                        FileOutputStream fout = openFileOutput("textfile.txt",
                                MODE_PRIVATE);
                        OutputStreamWriter osw = new OutputStreamWriter(fout);
                        osw.write(message);
                        osw.flush();
                        osw.close();
                        Toast.makeText(getApplicationContext(), "File saved successfully",
                                Toast.LENGTH_LONG).show();
                        edittext.setText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Type some data to save..",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {

                    FileInputStream fin = openFileInput("textfile.txt");
                    InputStreamReader isr = new InputStreamReader(fin);
                    char[] inputBuffer = new char[100];
                    String s = "";
                    int charRead;
                    while ((charRead = isr.read(inputBuffer)) > 0) {
                        String readString = String.copyValueOf(inputBuffer, 0, charRead);
                        s += readString;
                        inputBuffer = new char[100];
                    }
                    edittext.setText(s);
                    Toast.makeText(getApplicationContext(), "File loaded successfully",
                            Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
