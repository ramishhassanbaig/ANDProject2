package com.example.ramish.popularmovies1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Network {

    public static String BASE_URL = "http://api.themoviedb.org/3/movie/";
    public static String API_KEY = "MY_API_KEY";
    public static String POPULAR_MOVIES = "popular";
    public static String TOP_RATED_MOVIES = "top_rated";



    public String getPopularMoviesUrl() {
        return (BASE_URL + POPULAR_MOVIES + "?api_key=" + API_KEY);
    }

    public String getTopRatedMoviesUrl() {
        return (BASE_URL + TOP_RATED_MOVIES + "?api_key=" + API_KEY);
    }

    public String callService(String serviceUrl){
        try {
            URL url = new URL(serviceUrl);

            String protocol = url.getProtocol();
            if (protocol.equals("http")) {


                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                con.setRequestProperty("Content-Type", "application/json");
                con.setReadTimeout(150000);
                con.setConnectTimeout(150000);
                con.connect();

                int resp = con.getResponseCode();

                if (resp == 200) {
//                        long elapsedTime = System.currentTimeMillis() - startTime;
                    long elapsedTime = System.currentTimeMillis();
//                        AppLog.d("resBeforeElaspedTime", String.valueOf(elapsedTime));
                    con.getInputStream();
                    String message = convertInputStreamToString(con.getInputStream());

                    return message;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "error";
    }

    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result = result.concat(line);
        inputStream.close();
        return result;

    }

}
