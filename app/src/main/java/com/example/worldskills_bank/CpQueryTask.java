package com.example.worldskills_bank;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;

import static com.example.worldskills_bank.NetworkUtils.getResponseFromURL;


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

    }
}
