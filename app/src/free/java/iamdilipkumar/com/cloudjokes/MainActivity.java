package iamdilipkumar.com.cloudjokes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.iamdilipkumar.cloudjokes.backend.myApi.MyApi;

import java.io.IOException;

import iamdilipkumar.com.jokedisplayer.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getString(R.string.admob_id));

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        Button btnJoke = (Button) findViewById(R.id.btn_joke);
        btnJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask().execute();
            }
        });
    }

    private class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
        private MyApi myApiService = null;
        ProgressDialog progress;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress=new ProgressDialog(MainActivity.this);
            progress.setMessage("Loading the joke");
            progress.setCanceledOnTouchOutside(false);
            progress.show();
        }

        @Override
        protected String doInBackground(Void... params) {
            if (myApiService == null) {
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("https://cloud-jokes.appspot.com/_ah/api/");

                myApiService = builder.build();
            }

            try {
                return myApiService.getJoke().execute().getJoke();
            } catch (IOException e) {
                Log.d("error", e.getMessage());
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            progress.dismiss();
            Intent showJokeIntent = new Intent(MainActivity.this,JokeDisplayActivity.class);
            showJokeIntent.putExtra(JokeDisplayActivity.JOKE_INFORMATION,result);
            startActivity(showJokeIntent);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        }
    }
}
