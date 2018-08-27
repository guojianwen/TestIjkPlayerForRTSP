package com.zonekey.ijkplayer_view.video;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zonekey.ijkplayer_view.R;
import com.zonekey.ijkplayer_view.utils.IjkAnimUtils;
import com.zonekey.ijkplayer_view.widget.IMediaController;

import java.util.Locale;

/**
 * Created by xu.wang
 * Date on  2018/8/13 10:22:44.
 *
 * @Desc 点播 MeidaController
 */

public class VideoMediaController implements IMediaController, View.OnClickListener {
    private static final String TAG = "VideoMediaController";
    private static final int UPDATE_PROGRESS = 110; //刷新进度
    private static final int DELAY_SHOW = 111;      //延时显示
    private static final int DELAY_HIDE = 112;      //延时隐藏

    public static final int FULL_SCREEN = 111;  //全屏
    public static final int SHRINK_SCREEN = 112;    //非全屏

    private View mMediaController;
    private ImageView iv_fullscreen;
    private LinearLayout ll_top, ll_bottom;
    private TextView tv_play_detail;

    private MediaController.MediaPlayerControl mPlayer;
    private boolean isRunning = true;    //点击后,过几秒自动隐藏
    private boolean isDrag = false;
    private long mDuration = -1;

    private int mCurScreen = SHRINK_SCREEN;
    private OnVideoControllerClickListener mListener;

    private Handler mHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_PROGRESS:
                    mHander.removeMessages(UPDATE_PROGRESS);
                    refreshState();
                    if (isRunning) mHander.sendEmptyMessageDelayed(UPDATE_PROGRESS, 1000);
                    break;
                case DELAY_SHOW:
                    mHander.removeMessages(DELAY_SHOW);
                    show();
                    break;
                case DELAY_HIDE:
                    mHander.removeMessages(DELAY_HIDE);
                    if (!isDrag) hide();
                    break;
            }
        }
    };
    private SeekBar sk_play;


    private void refreshState() {
        if (mPlayer == null) return;
        int position = mPlayer.getCurrentPosition();
        int duration = mPlayer.getDuration();
        if (sk_play != null) {
            if (duration > 0) {
                long pos = 1000L * position / duration;
                Log.e(TAG, "refreshState = " + pos);
                sk_play.setProgress((int) pos);
            }
            int percent = mPlayer.getBufferPercentage();
            sk_play.setSecondaryProgress(percent * 10);
        }
        mDuration = duration;
        tv_play_detail.setText(generateTime(position) + "/" + generateTime(mDuration));
    }

    private static String generateTime(long position) {
        int totalSeconds = (int) ((position / 1000.0) + 0.5);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        if (hours > 0) {
            return String.format(Locale.US, "%02d:%02d:%02d", hours, minutes,
                    seconds);
        } else {
            return String.format(Locale.US, "%02d:%02d", minutes, seconds);
        }
    }

    @Override
    public boolean isShowing() {
        return mMediaController == null ? false :
                (ll_top.getVisibility() == View.VISIBLE && ll_bottom.getVisibility() == View.VISIBLE);
    }

    @Override
    public void setAnchorView(View view) {
        if (mMediaController != null) return;
        Log.e(TAG, "setAnchorView");
        mMediaController = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_media_controller_player, (ViewGroup) view, false);
        iv_fullscreen = mMediaController.findViewById(R.id.iv_ijkview_mediacontroller_fullscreen);
        ll_top = mMediaController.findViewById(R.id.ll_media_controller_top);
        ll_bottom = mMediaController.findViewById(R.id.ll_media_controller_bottom);
        tv_play_detail = mMediaController.findViewById(R.id.tv_ijkview_play_detail);
        sk_play = mMediaController.findViewById(R.id.sk_ijkview_play);
        sk_play.setMax(1000);
        sk_play.setOnSeekBarChangeListener(new MySeekBarChangeListener());
        iv_fullscreen.setOnClickListener(this);
        ((ViewGroup) view).addView(mMediaController);
        mHander.sendEmptyMessageDelayed(DELAY_HIDE, 5000);
    }

    @Override
    public void setEnabled(boolean enabled) {

    }


    class MySeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (mDuration <= 0) return;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            isDrag = true;
            mHander.removeMessages(DELAY_HIDE);
            show();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            isDrag = false;
            mHander.sendEmptyMessageDelayed(DELAY_HIDE, 5000);
            Log.e(TAG, "onStopTrackingTouch");
            final long newposition = (mDuration * seekBar.getProgress()) / 1000;
            tv_play_detail.setText(generateTime(newposition) + "/" + generateTime(mDuration));
            mPlayer.seekTo((int) newposition);
        }
    }


    @Override
    public void setMediaPlayer(MediaController.MediaPlayerControl player) {
        Log.e(TAG, "setMediaPlayer");
        this.mPlayer = player;
        mHander.sendEmptyMessageDelayed(UPDATE_PROGRESS, 500);
    }

    @Override
    public void show(int timeout) {
        if (mMediaController != null) {
            mHander.sendEmptyMessageDelayed(DELAY_SHOW, timeout);
        }
    }

    @Override
    public void hide() {
        if (mMediaController != null && isShowing()) {
            ll_top.setVisibility(View.INVISIBLE);
            ll_bottom.setVisibility(View.INVISIBLE);
            IjkAnimUtils.menuAnim(0, -ll_top.getHeight(), 1.0f, 0.4f, ll_top, ll_top.getContext());
            IjkAnimUtils.menuAnim(0, ll_bottom.getHeight(), 1.0f, 0.4f, ll_bottom, ll_bottom.getContext());
        }
    }

    @Override
    public void show() {
        if (mMediaController != null && !isShowing()) {
            ll_top.setVisibility(View.VISIBLE);
            ll_bottom.setVisibility(View.VISIBLE);
            IjkAnimUtils.menuAnim(-ll_top.getHeight(), 0, 0.4f, 1.0f, ll_top, ll_top.getContext());
            IjkAnimUtils.menuAnim(ll_bottom.getHeight(), 0, 0.4f, 1.0f, ll_bottom, ll_bottom.getContext());
            if (isRunning) mHander.sendEmptyMessageDelayed(DELAY_HIDE, 5000);
        }
    }

    @Override
    public void showOnce(View view) {

    }

    @Override
    public void onClick(View v) {
        if (mMediaController == null) {
            return;
        }
        int id = v.getId();
        if (id == R.id.iv_ijkview_mediacontroller_fullscreen) {
            if (mCurScreen == SHRINK_SCREEN) {
                mCurScreen = FULL_SCREEN;
            } else if (mCurScreen == FULL_SCREEN) {
                mCurScreen = SHRINK_SCREEN;
            }

            if (mListener != null) mListener.clickScreenChange(mCurScreen);
        }
    }

    public void release() {
        isRunning = false;
        if (mHander != null) {
            mHander.removeMessages(DELAY_HIDE);
            mHander.removeMessages(DELAY_SHOW);
            mHander.removeMessages(UPDATE_PROGRESS);
        }
    }

    public void setOnVideoControllerClickListener(OnVideoControllerClickListener listener) {
        this.mListener = listener;
    }

    public interface OnVideoControllerClickListener {
        void clickScreenChange(int screenState);
    }
}
