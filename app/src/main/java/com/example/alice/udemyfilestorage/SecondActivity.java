package com.example.alice.udemyfilestorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    public static final int END_STRING = -1;
    TextView tvUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvUserName = (TextView) findViewById(R.id.tvUserName);
    }

    /**
     * FileInputStream to read Data
     * Read byte by byte and safe into StringBuffer
     * Show StringBuffer content into TextView
     * @param view
     */
    public void loadUserName(View view) {

        FileInputStream fileInputStream = null;
        try {
             fileInputStream = openFileInput("Users.txt");

            int read =  END_STRING;
            StringBuffer buffer = new StringBuffer();
            while ( (read = fileInputStream.read()) != END_STRING){
                buffer.append((char) read);
            }

            tvUserName.setText(buffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
