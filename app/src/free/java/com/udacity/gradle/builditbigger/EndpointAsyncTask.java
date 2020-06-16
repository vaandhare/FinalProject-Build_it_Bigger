package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.vaibhavandhare.jokeslibrary.JokeDisplayActivity;

import java.io.IOException;

import static com.google.api.client.extensions.android.http.AndroidHttp.newCompatibleTransport;

public class EndpointAsyncTask extends AsyncTask<com.udacity.gradle.builditbigger.MainActivityFragment, Void, String> {
    private static MyApi myApiService = null;
    @SuppressLint("StaticFieldLeak")
    private Context context;

    @Override
    protected String doInBackground(MainActivityFragment... params) {

        MainActivityFragment mainActivityFragment = params[0];
        context = mainActivityFragment.getActivity();
        if (myApiService == null) { // Only do this once
            MyApi.Builder builder = new MyApi.Builder(newCompatibleTransport(), new AndroidJsonFactory(), null)
                            .setRootUrl("https://10.0.2.2/_ah/api/")
                            .setGoogleClientRequestInitializer(abstractGoogleClientRequest -> abstractGoogleClientRequest.setDisableGZipContent(true));
            myApiService = builder.build();
        }

        try {
            return myApiService.getJokes().execute().getData();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result == null) {
            Toast.makeText(context, "something wrong with the server", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra("jokes", result);
        context.startActivity(intent);
    }
}

