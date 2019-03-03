package com.example.musicrater;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

import static android.media.MediaPlayer.create;

public class MainActivity extends AppCompatActivity {

    Button btnJimi, btnSRV, btnClapton, btnSubmit;
    MediaPlayer mpJimi, mpSRV, mpClapton;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJimi = (Button)findViewById(R.id.btnJimi);
        btnClapton = (Button) findViewById(R.id.btnClapton);
        btnSRV = (Button) findViewById(R.id.btnSRV);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnJimi.setOnClickListener(bJimi);
        btnClapton.setOnClickListener(bClapton);
        btnSRV.setOnClickListener(bSRV);
        btnSubmit.setOnClickListener(bSubmit);


        mpClapton = new MediaPlayer();
        mpClapton = MediaPlayer.create(this, R.raw.clapton);

        mpJimi = new MediaPlayer();
        mpJimi = MediaPlayer.create(this,R.raw.jimi);

        mpSRV = new MediaPlayer();
        mpSRV = MediaPlayer.create(this,R.raw.srv);



        playing = 0;

//        EditText etClapton = (EditText)findViewById(R.id.etClapton);
//        EditText etJimi = (EditText)findViewById(R.id.etJimi);
//        EditText etSRV = (EditText)findViewById(R.id.etSRV);

//        String claptonRate = etClapton.getText().toString();
//        String jimiRate = etJimi.getText().toString();
//        String srvRate = etSRV.getText().toString();


    }
    Button.OnClickListener bClapton = new Button.OnClickListener(){
        public void onClick(View v){
            switch (playing){
                case 0:
                    mpClapton.start();
                    playing = 1;
                    btnClapton.setText("Pause Eric Clapton");
                    btnSRV.setVisibility(View.INVISIBLE);
                    btnJimi.setVisibility(View.INVISIBLE);
                    break;

                case 1:
                    mpClapton.pause();
                    playing = 0;
                    btnClapton.setText("Play Eric Clapton");
                    btnClapton.setVisibility(View.VISIBLE);
                    btnJimi.setVisibility(View.VISIBLE);
                    btnSRV.setVisibility(View.VISIBLE);

                    break;


            }
        }
    };
    Button.OnClickListener bJimi= new Button.OnClickListener(){
        public void onClick(View v){
            switch (playing){
                case 0:
                    mpJimi.start();
                    playing = 1;
                    btnJimi.setText("Pause Jimi Hendrix");
                    btnSRV.setVisibility(View.INVISIBLE);
                    btnClapton.setVisibility(View.INVISIBLE);
                    break;

                case 1:
                    mpJimi.pause();
                    playing = 0;
                    btnClapton.setText("Play Jimi Hendrix");
                    btnClapton.setVisibility(View.VISIBLE);
                    btnJimi.setVisibility(View.VISIBLE);
                    btnSRV.setVisibility(View.VISIBLE);

                    break;


            }
        }
    };
    Button.OnClickListener bSRV = new Button.OnClickListener(){
        public void onClick(View v){
            switch (playing){
                case 0:
                    mpSRV.start();
                    playing = 1;
                    btnSRV.setText("Pause S.R.V.");
                    btnClapton.setVisibility(View.INVISIBLE);
                    btnJimi.setVisibility(View.INVISIBLE);
                    break;

                case 1:
                    mpSRV.pause();
                    playing = 0;
                    btnSRV.setText("Play Stevie Ray Vaughn");
                    btnClapton.setVisibility(View.VISIBLE);
                    btnJimi.setVisibility(View.VISIBLE);
                    btnSRV.setVisibility(View.VISIBLE);

                    break;


            }
        }
    };

    Button.OnClickListener bSubmit = new Button.OnClickListener(){
            public void onClick(View v) {
                EditText etClapton = (EditText) findViewById(R.id.etClapton);
                EditText etJimi = (EditText) findViewById(R.id.etJimi);
                EditText etSRV = (EditText) findViewById(R.id.etSRV);
                String claptonRate = etClapton.getText().toString();
                String jimiRate = etJimi.getText().toString();
                String srvRate = etSRV.getText().toString();
                Integer finalClapton;
                Integer finalSRV;
                Integer finalJimi;


                try {
                    finalClapton = Integer.parseInt(claptonRate);
                    finalJimi = Integer.parseInt(jimiRate);
                    finalSRV = Integer.parseInt(srvRate);
                    if (finalClapton != null && finalSRV != null && finalJimi != null) {
                        if ((finalClapton > 0 && finalClapton < 4) && (finalJimi > 0 && finalJimi < 4) && (finalSRV > 0 && finalSRV < 4)) {
                            if ((finalClapton != finalSRV && finalClapton != finalJimi) && (finalSRV != finalJimi)) {
                                Toast.makeText(MainActivity.this, "Rating Submitted Sucessfully", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Ratings cannot be the Same!", Toast.LENGTH_LONG).show();
                            }
                        }
                            else {
                                // IM NOT GETTING HERE
                                Toast.makeText(MainActivity.this, "Error, Make sure the ratings are unique, 1-3", Toast.LENGTH_LONG).show();
                            }

                    }

                } catch (NumberFormatException e) {

                    Toast.makeText(MainActivity.this, "Error, Ratings must be made to all songs in order to submit", Toast.LENGTH_LONG).show();

                }


                }

    };
};
