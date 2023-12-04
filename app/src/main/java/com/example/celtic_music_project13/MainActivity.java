package com.example.celtic_music_project13;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    MediaPlayer mpIrishjig, mpBagpipes;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.btIrishjig);
        button2 = findViewById(R.id.btBagpipes);
        button1.setOnClickListener(Irisihjig);
        button2.setOnClickListener(Bagpipes);
        mpIrishjig = new MediaPlayer();
        mpIrishjig = MediaPlayer.create(this, R.raw.irish_jig);
        mpBagpipes = new MediaPlayer();
        mpBagpipes = MediaPlayer.create(this, R.raw.bagpipes);
        playing = 0;
    }

    Button.OnClickListener Irisihjig = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpIrishjig.start();
                    playing = 1;
                    button1.setText("Pause Ukelele Song");
                    button2.setVisibility(View.INVISIBLE);
                    break;

                case 1:
                    mpIrishjig.pause();
                    playing = 0;
                    button1.setText("Play Ukelele Song");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener Bagpipes = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpBagpipes.start();
                    playing = 1;
                    button2.setText("Pause Drums Song");
                    button1.setVisibility(View.INVISIBLE);
                    break;

                case 1:
                    mpBagpipes.pause();
                    playing = 0;
                    button2.setText("Play Drums Song");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}
