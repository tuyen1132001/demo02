package com.example.httpdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet();
        try{
            httpGet.setURI(new URI("http://192.168.0.108:1234/testandroid/nhanget.php?name=VanLangUniversity"));
            HttpResponse response = httpClient.execute(httpGet);
            InputStreamReader is = new InputStreamReader(response.getEntity().getContent());
            BufferedReader bufferedReader = new BufferedReader(is);
            String line;
        while ((line = bufferedReader.readLine()) != null) {
            Log.d("dulieu", ""+line);
        }
        }catch (Exception e){
            Log.d("loi", "loi: "+e.toString());
        }

    }
}