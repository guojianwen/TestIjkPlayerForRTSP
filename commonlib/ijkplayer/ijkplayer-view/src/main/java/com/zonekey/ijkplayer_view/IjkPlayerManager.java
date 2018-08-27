package com.zonekey.ijkplayer_view;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by xu.wang
 * Date on  2018/5/4 17:07:23.
 *
 * @Desc
 */

public class IjkPlayerManager {
    public static void init(){
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
    }

    public static void end(){
        IjkMediaPlayer.native_profileEnd();
    }

}
