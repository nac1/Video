package com.example.upam.video;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        video=(VideoView) findViewById(R.id.vid1);
        //Uri ruta= Uri.parse("android.resource://com.example.upam.video" + R.raw.BigBuckBunny_640x360);
        //video.setVideoURI(ruta);

       video.setVideoPath(
               "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov");

       /* File path=new File(getFilesDir(),"DCMI/Camera");
        File mypath=new File(path,"VID_20140905_151507.3gp");
        video.setVideoPath(String.valueOf(mypath));*/

      //  mVideoView.setVideoPath("/mnt/sdcard/video.mp4");

        MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);

        video.start();


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
