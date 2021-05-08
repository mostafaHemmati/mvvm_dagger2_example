package com.hemmati.mvvmrxjavadagger2example.ui.list;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hemmati.mvvmrxjavadagger2example.R;
import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideo;

import java.util.ArrayList;
import java.util.List;

public class VideoListAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private final AparatItemSelectedListener aparatItemSelectedListener;
    private final List<MostViewedVideo> data = new ArrayList<>();

    VideoListAdapter(AparatItemSelectedListener aparatItemSelectedListener) {
        this.aparatItemSelectedListener = aparatItemSelectedListener;

    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_video_list_item, parent, false);
        return new VideoViewHolder(view, aparatItemSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.bind(data.get(position));

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateList(List<MostViewedVideo> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();

    }

}
