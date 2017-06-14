package iamdilipkumar.com.jokedisplayer;

import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_INFORMATION = "joke";
    String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        mJoke = getIntent().getStringExtra(JOKE_INFORMATION);

        if (mJoke != null) {
            if (!mJoke.isEmpty()) {
                TextView jokeText = (TextView) findViewById(R.id.tv_joke);
                jokeText.setText(mJoke);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            ShareCompat.IntentBuilder shareBuilder = ShareCompat.IntentBuilder.from(this);
            shareBuilder.setType(getString(R.string.share_type));
            shareBuilder.setText(getString(R.string.share_text));
            shareBuilder.setChooserTitle(mJoke);
            shareBuilder.startChooser();
        }
        return true;
    }

    public void tellJoke(View view) {
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }
}
