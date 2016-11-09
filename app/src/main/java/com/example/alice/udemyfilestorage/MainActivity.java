package com.example.alice.udemyfilestorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = (EditText) findViewById(R.id.etUserName);
    }

    /**
     * Create a File to safe data into it.
     * OutPutString
     *
     * @param view
     */
    public void saveUserOnFile(View view) {
        String strUserName = etUserName.getText().toString();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("Users.txt", MODE_PRIVATE);
            //write bytes
            fileOutputStream.write(strUserName.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //File path
        Toast.makeText(this, getFilesDir().toString() + "/Users.txt",Toast.LENGTH_SHORT).show();
    }

    /**
     * @param view
     */
    public void goToSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
