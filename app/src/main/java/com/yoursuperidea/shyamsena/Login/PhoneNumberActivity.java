package com.yoursuperidea.shyamsena.Login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.yoursuperidea.shyamsena.R;

public class PhoneNumberActivity extends AppCompatActivity {

    VideoView simpleVideoView;
    MediaController mediaControls;
    EditText etxPhoneNumber, etxName;
    Button loginBtn;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);
        etxPhoneNumber = findViewById(R.id.phone_number_etxt);
        etxName = findViewById(R.id.name_etxt);
        loginBtn = findViewById(R.id.btnLogin);

        firebaseFirestore = FirebaseFirestore.getInstance();

        if (mediaControls == null) {
            // create an object of media controller class
            mediaControls = new MediaController(PhoneNumberActivity.this);
            mediaControls.setAnchorView(simpleVideoView);
        }
        // set the media controller for video view
        simpleVideoView.setMediaController(mediaControls);
        // set the uri for the video view
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash));
        // start a video
        simpleVideoView.start();

        // implement on completion listener on video view
        simpleVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                Toast.makeText(getApplicationContext(), "Thank You...!!!", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etxPhoneNumber.getText().toString().isEmpty())
                {
                    etxPhoneNumber.setError("कृपया फ़ोन नंबर दर्ज करें");
                }
                else if (etxName.getText().toString().isEmpty())
                {
                    etxName.setError("कृप्या अपना नाम दर्ज करें");
                }
                else
                {
                    Intent i = new Intent(PhoneNumberActivity.this, OTPVerifyActivity.class);
                            i.putExtra("phone", etxPhoneNumber.getText().toString());
                            i.putExtra("name", etxName.getText().toString());
                            startActivity(i);
                }
            }
        });
    }



    @Override
    protected void onPause() {
        super.onPause();
        simpleVideoView.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        simpleVideoView.start();
        mediaControls.setVisibility(View.INVISIBLE);
    }
}