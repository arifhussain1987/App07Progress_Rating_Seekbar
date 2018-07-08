package com.example.arifa.app07_progress_rating_seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar, progressBar1;
    Button btnsubmit;
    SeekBar seekBar;
    TextView textView, txtshowratingbar_normal, txtshowratingbar_custom;
    RatingBar ratingBar_normal, ratingBar_custom;

    SmileRating smileRating;


    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress1);
        seekBar = findViewById(R.id.seekbar1);
        progressBar1 = findViewById(R.id.progress2);
        textView = findViewById(R.id.txtshowseekvalue);

        ratingBar_normal = findViewById(R.id.ratingbarnormal);
        txtshowratingbar_normal = findViewById(R.id.txtshowratingvalue_normal);

        smileRating = findViewById(R.id.smile_rating);
        txtshowratingbar_custom = findViewById(R.id.txtshowratingvalue_custom);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressBar1.setProgress(i);
                textView.setText(Integer.toString(i) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // this is for normal ratingbar

        ratingBar_normal.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                txtshowratingbar_normal.setText("Your rate result : "+ String.valueOf(v));
            }
        });

        // this is for custom smile rating

        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(getApplicationContext(), "Thankyou for your feedback. we will try to improve our app", Toast.LENGTH_LONG).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(getApplicationContext(), "Thankyou for your feedback. It boost our effort", Toast.LENGTH_LONG).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(getApplicationContext(), "Thankyou for your feedback and select Great ", Toast.LENGTH_LONG).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(getApplicationContext(), "Thankyou for your feedback. Ofcourse Okay is not enough", Toast.LENGTH_LONG).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(getApplicationContext(), "Thankyou for your feedback. Good to hear Terrible", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });


        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {
                txtshowratingbar_custom.setText(String.valueOf(level));

            }
        });


    }

    public void increase(View view)
    {
        if(i >= 100)
        {
            Toast.makeText(this, "You have reached the maximum limit", Toast.LENGTH_SHORT).show();
        }
        else
        {
            i+=10;
            progressBar.setProgress(i);
        }
    }

    public void decrease(View view)
    {
        if(i <= 0)
        {
            Toast.makeText(this, "You have reached the minimum limit", Toast.LENGTH_SHORT).show();
        }
        else
        {
            i-= 10;
            progressBar.setProgress(i);
        }
    }



}
