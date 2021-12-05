package com.example.worldskills_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_main);

        valuesSetUp();
    }

    private void valuesSetUp() {
        getCurrentDate();
    }

    private void getCurrentDate() {
        TextView textView = findViewById(R.id.launcherMainContentBox_2_currentDate);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = sdf.format(new Date());
        textView.setText(currentDate);
    }
}