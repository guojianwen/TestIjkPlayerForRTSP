package com.zonekey.ijkplayer_view.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by xu.wang
 * Date on  2018/6/19 14:18:09.
 *
 * @Desc
 */

public class NotDispatchLineLayout extends LinearLayout {
    public NotDispatchLineLayout(Context context) {
        super(context);
    }

    public NotDispatchLineLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NotDispatchLineLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
