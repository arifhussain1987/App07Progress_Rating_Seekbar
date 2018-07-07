package com.example.arifa.app07_progress_rating_seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar, progressBar1;
    Button btnsubmit;
    SeekBar seekBar;
    TextView textView;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress1);
        seekBar = findViewById(R.id.seekbar1);
        progressBar1 = findViewById(R.id.progress2);
        textView = findViewById(R.id.txtshowseekvalue);



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
