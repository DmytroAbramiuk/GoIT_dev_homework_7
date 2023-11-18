package org.example.http;

import org.example.utils.Constants;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws Exception {
        String url = Constants.START_URL + code + Constants.FORMAT;
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        int responseValue = con.getResponseCode();
        if(responseValue == 404){
            throw new FileNotFoundException(String.format(Constants.NOT_FOUND, code));
        } else {
            return url;
        }
    }
}
