package secretballcom.example.zion.secretball;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private SecretBall secret = new SecretBall();
    private TextView mAnswerLabel;
    private Button mAetAnswerButton;
    private ImageView mCrystalBallImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Adding our view
        mAnswerLabel = (TextView) findViewById(R.id.editText);
        mAetAnswerButton = (Button) findViewById(R.id.button);
        mCrystalBallImage = (ImageView) findViewById(R.id.imageView);

        mAetAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answer = secret.getAnswer();

                mAnswerLabel.setText(answer);
                animateCrystalBall();
                animateAnswer();

            }
        });
    }

    private void animateCrystalBall() {
        mCrystalBallImage.setImageResource(R.drawable.ball_animation);
        AnimationDrawable ballAnimation = (AnimationDrawable) mCrystalBallImage.getDrawable();

        if (ballAnimation.isRunning()) {
            ballAnimation.stop();
        }
        ballAnimation.start();

    }

    private void animateAnswer(){
        AlphaAnimation fadeAnimation = new AlphaAnimation(0,1);
        fadeAnimation.setDuration(1500);
        fadeAnimation.setFillAfter(true);
        mAnswerLabel.setAnimation(fadeAnimation);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
