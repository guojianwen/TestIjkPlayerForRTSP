package com.zonekey.ijkplayer_view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zonekey.ijkplayer_view.R;

/**
 * Created by xu.wang
 * Date on  2017/9/29 18:02:42.
 *
 * @des
 */

public class IjkDefinViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_definition;

    public IjkDefinViewHolder(View itemView) {
        super(itemView);
        tv_definition = (TextView) itemView.findViewById(R.id.tv_item_ijk_definition);
    }
}
