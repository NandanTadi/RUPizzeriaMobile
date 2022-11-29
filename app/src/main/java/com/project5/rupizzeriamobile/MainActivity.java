package com.project5.rupizzeriamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_int1, et_int2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_int1 = findViewById(R.id.et_int1);
        et_int2 = findViewById(R.id.et_int2);
        tv3 = findViewById(R.id.tv_3);
    }

    public void add(View view) {
        int result = Integer.parseInt(et_int1.getText().toString())
                + Integer.parseInt(et_int2.getText().toString());
        tv3.setText(String.valueOf(result));
    }
}