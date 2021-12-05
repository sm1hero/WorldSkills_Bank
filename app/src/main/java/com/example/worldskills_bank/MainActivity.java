package com.example.worldskills_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.worldskills_bank.NetworkUtils.generateURL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_main);

        valuesSetUp();
    }

    private void valuesSetUp() {
        getCurrentDate();
        getCurrentCourses();
    }

    private void getCurrentDate() {
        TextView textView = findViewById(R.id.launcherMainContentBox_2_currentDate);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = sdf.format(new Date());
        textView.setText(currentDate);
    }

    private void getCurrentCourses() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = sdf.format(new Date());

        URL generatedURL = null;

        try {
            generatedURL = generateURL(currentDate);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        new CpQueryTask().execute(generatedURL);

        String response = null;
    }
}