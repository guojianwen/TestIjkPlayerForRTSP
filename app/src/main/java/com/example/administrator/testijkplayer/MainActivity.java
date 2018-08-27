package com.example.administrator.testijkplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zonekey.ijkplayer_view.IjkPlayerManager;
import com.zonekey.ijkplayer_view.widget.IjkVideoView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MainActivity extends AppCompatActivity {

    IjkVideoView ijkVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ijkVideoView = findViewById(R.id.ijkvideoview);
        IjkPlayerManager.init();
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

//        ijkVideoView.setVideoPath("rtmp://live.hkstv.hk.lxdns.com/live/hks");

        ijkVideoView.setVideoPath("rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov");
        ijkVideoView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IjkMediaPlayer.native_profileEnd();
    }
}
