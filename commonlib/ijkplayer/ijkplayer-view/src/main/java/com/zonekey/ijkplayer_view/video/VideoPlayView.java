package com.zonekey.ijkplayer_view.video;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by xu.wang
 * Date on  2018/8/13 14:31:32.
 *
 * @Desc
 */

public class VideoPlayView extends FrameLayout {
    public VideoPlayView(@NonNull Context context) {
        this(context,null);
    }

    public VideoPlayView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public VideoPlayView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialView();
    }

    private void initialView() {

    }
}
