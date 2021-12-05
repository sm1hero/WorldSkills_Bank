package com.example.worldskills_bank;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    private static final String CP_API_BASE_URL   = "https://www.cbr.ru/";
    private static final String CP_DAILY_GET      = "scripts/XML_daily.asp";
    private static final String CP_PARAM_DATE_REQ = "date_req";

    public static URL generateURL(String date) throws MalformedURLException {
        Uri buildUri = Uri.parse(CP_API_BASE_URL + CP_DAILY_GET).buildUpon()
                .appendQueryParameter(CP_PARAM_DATE_REQ, date).build();

        URL url = null;
        url = new URL(buildUri.toString());
        return url;
    }

    public static String getResponseFromURL(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("//A");

            boolean hasInput = scanner.hasNext();

            if(hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
