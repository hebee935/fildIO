package com.example.eunbee.fileio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    Button butOut, butIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butOut = (Button)findViewById(R.id.but_output);
        butIn = (Button)findViewById(R.id.but_input);
        butOut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    FileOutputStream out = openFileOutput("1017hong.txt", Context.MODE_WORLD_WRITEABLE);
                    String message = "미림정보고 학생들이 가장 카와이";
                    out.write(message.getBytes());
                    out.close();
                }catch(Exception e){}
            }
        });
        butIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try{
                    FileInputStream in = openFileInput("1017hong.txt");
                    byte[] readMessage = new byte[200];
                    in.read(readMessage);
                    Toast.makeText(getApplicationContext(),new String(readMessage),Toast.LENGTH_LONG).show();
                    in.close();
                }catch(Exception e){}
            }
        });
    }
}
