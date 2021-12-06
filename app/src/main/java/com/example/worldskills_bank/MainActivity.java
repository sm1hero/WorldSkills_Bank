package com.example.worldskills_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.worldskills_bank.NetworkUtils.generateURL;
import static com.example.worldskills_bank.NetworkUtils.getResponseFromURL;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_main);

        textView = findViewById(R.id.launcherMainContentBox_2_text);

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

        generatedURL = generateURL(currentDate);
        new CpQueryTask().execute(generatedURL);

    }

    public class CpQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {

            String response = null;

            try {
                response = getResponseFromURL(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String response) {
            textView.setText(response);
        }
    }
}