package com.zonekey.ijkplayer_view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.zonekey.ijkplayer_view.R;
import com.zonekey.ijkplayer_view.bean.VideoDefinition;
import com.zonekey.ijkplayer_view.holder.IjkDefinViewHolder;
import com.zonekey.ijkplayer_view.view.IjkPlayerView;

import java.util.ArrayList;

/**
 * Created by xu.wang
 * Date on  2017/9/29 18:01:21.
 *
 * @des IjkPlayView内部用来选择高清和流畅的adapter
 */

public class IjkDefinitionAdapter extends RecyclerView.Adapter<IjkDefinViewHolder> {
    private ArrayList<VideoDefinition> mDefinitionLists;
    private IjkPlayerView mIjkPlayerView;
    private int lightBlue;

    public IjkDefinitionAdapter(ArrayList<VideoDefinition> lists, IjkPlayerView ijkPlayerView) {
        this.mDefinitionLists = lists;
        this.mIjkPlayerView = ijkPlayerView;
        this.lightBlue = ijkPlayerView.getResources().getColor(R.color.ijkplayer_light_blue);
    }

    @Override
    public IjkDefinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IjkDefinViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ijk_definition, parent, false));
    }

    @Override
    public void onBindViewHolder(IjkDefinViewHolder holder, final int position) {
        VideoDefinition definition = mDefinitionLists.get(position);
        if (mIjkPlayerView.mDefinitionPos == position) {
            holder.tv_definition.setTextColor(lightBlue);
        } else {
            holder.tv_definition.setTextColor(Color.WHITE);
        }
        holder.tv_definition.setText("" + definition.getDescrption());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == mIjkPlayerView.mDefinitionPos) {
                    return;
                }
                mIjkPlayerView.mDefinitionPos = position;
                mIjkPlayerView.refreshDefinition();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDefinitionLists == null ? 0 : mDefinitionLists.size();
    }
}
