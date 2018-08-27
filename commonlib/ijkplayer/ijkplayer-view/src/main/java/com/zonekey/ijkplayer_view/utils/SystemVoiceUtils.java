package com.zonekey.ijkplayer_view.utils;

import android.content.Context;
import android.media.AudioManager;

/**
 * Created by xu.wang
 * Date on  2017/10/26 14:05:50.
 *
 * @Desc 获取当前的音量值
 */

public class SystemVoiceUtils {
    public static int getCurrentMusicVolume(Context context) {
        AudioManager am = (AudioManager) context.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

//        max = am.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL);// 0
//        current= am.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
//        Log.e("SystemVoiceUtils", "通话音量值：" + max + "-" + current);

//        max = am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);// 1
//        current = am.getStreamVolume(AudioManager.STREAM_SYSTEM);
//        Log.e("SystemVoiceUtils", "系统音量值：" + max + "-" + current);

//        max = am.getStreamMaxVolume(AudioManager.STREAM_RING);// 2
//        current = am.getStreamVolume(AudioManager.STREAM_RING);
//        Log.e("SystemVoiceUtils", "系统铃声值：" + max + "-" + current);

//        max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);// 3
        return am.getStreamVolume(AudioManager.STREAM_MUSIC);
//        Log.e("SystemVoiceUtils", "音乐音量值：" + max + "-" + current);

//        max = am.getStreamMaxVolume(AudioManager.STREAM_ALARM);// 4
//        current = am.getStreamVolume(AudioManager.STREAM_ALARM);
//        Log.e("SystemVoiceUtils", "闹铃音量值：" + max + "-" + current);
    }
}
