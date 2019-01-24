package com.example.lawre.week3day3homework.model.datasource.httpUrlConnection;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnTask extends AsyncTask<String, String, String>
{
    @Override
    protected String doInBackground(String... strings)
    {
        HttpUrlConnectionHelper.makeApiCall();
        return null;
    }
}
