package com.udacity.gradle.builditbigger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Objects;

public class MainActivityFragment extends Fragment {

    private InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);

        Button btnTellJoke = view.findViewById(R.id.btnTellJoke);

        MobileAds.initialize(this.getContext(), initializationStatus -> {
        });
        AdView mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(Objects.requireNonNull(this.getContext()));
        //Demo testing id
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
//        mInterstitialAd.setAdUnitId(String.valueOf(R.string.interstitial_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                getJokes();
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        btnTellJoke.setOnClickListener(v -> {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
            getJokes();
        });

        return view;
    }

    private void getJokes(){
        new EndpointAsyncTask().execute(this);
    }
}
