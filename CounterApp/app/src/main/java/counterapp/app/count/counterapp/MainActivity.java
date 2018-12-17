package counterapp.app.count.counterapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewCount;
    private Button mButtonAdd, mButtonReset, mButtonMultiple, mButtonAnimate;
    private int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeViewsAndVariables();

        //On click button add
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                mTextViewCount.setText("Count : "+count);
            }
        });

        //On click button reset
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                mTextViewCount.setText("Count : "+count);
            }
        });

        //On click button multiple
        mButtonMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count + 10;
                mTextViewCount.setText("Count : "+count);
            }
        });

        //On click button multiple
        mButtonAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count + 1;
                mTextViewCount.setText("Count : "+count);
               RunAnimation();
            }
        });

    }

    private void RunAnimation()
    {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.scale);
        a.reset();
       // TextView tv = (TextView) findViewById(R.id.firstTextView);
        mTextViewCount.clearAnimation();
        mTextViewCount.startAnimation(a);
    }

    private void initializeViewsAndVariables() {
        mTextViewCount = findViewById(R.id.tv_count);
        mButtonAdd = findViewById(R.id.button_count);
        mButtonReset = findViewById(R.id.button_reset);
        mButtonMultiple = findViewById(R.id.button_count_multiple);
        mButtonAnimate = findViewById(R.id.button_animate);

        mTextViewCount.setText("Count : "+count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
