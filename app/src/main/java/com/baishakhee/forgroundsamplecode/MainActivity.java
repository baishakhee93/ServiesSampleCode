package com.baishakhee.forgroundsamplecode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edittextInput);
    }

    public void startService(View view) {

        String input=editText.getText().toString();

        Intent intent=new Intent(this,SampleServices.class);
        intent.putExtra("inputData",input);

        ContextCompat.startForegroundService(this,intent);
      //  startService(intent);

    }

    public void stopService(View view) {

        Intent intent=new Intent(this,SampleServices.class);
        stopService(intent);

    }


}