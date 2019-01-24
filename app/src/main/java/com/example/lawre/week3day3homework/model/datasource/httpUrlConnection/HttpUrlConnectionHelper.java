package com.example.lawre.week3day3homework.model.datasource.httpUrlConnection;

import android.util.Log;

import com.example.lawre.week3day3homework.events.UserEvent;
import com.example.lawre.week3day3homework.model.user.UserResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionHelper
{
    public static void makeApiCall()
    {
        HttpURLConnection connection = null;
        URL apiURL;
        String jsonResponse = "";

        try
        {
            apiURL = new URL("https://randomuser.me/api/?results=15");
            connection = (HttpURLConnection)apiURL.openConnection();
            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            int currAscii = reader.read();
            while(currAscii != -1)
            {
                char currChar = (char)currAscii;
                jsonResponse = jsonResponse + currChar;
                currAscii = reader.read();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(connection != null)
            {
                connection.disconnect();
                Gson gson = new Gson();
                UserResponse user = gson.fromJson(jsonResponse,UserResponse.class);
                EventBus.getDefault().post(new UserEvent(user));
            }
        }
    }
}
