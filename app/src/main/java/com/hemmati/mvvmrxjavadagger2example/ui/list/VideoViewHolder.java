package com.hemmati.mvvmrxjavadagger2example.ui.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hemmati.mvvmrxjavadagger2example.R;
import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideo;
import com.squareup.picasso.Picasso;

public class VideoViewHolder extends RecyclerView.ViewHolder  {
    private TextView titleTextView;
    private ImageView posterImageView;

    private MostViewedVideo mostViewedVideo;

    public VideoViewHolder(@NonNull View itemView,AparatItemSelectedListener aparatItemSelectedListener) {
        super(itemView);
        initView(itemView);
        itemView.setOnClickListener(v -> {
            if(mostViewedVideo != null) {
                aparatItemSelectedListener.onItemSelected(mostViewedVideo);
            }
        });
    }

    private void initView(View itemView) {
        titleTextView=itemView.findViewById(R.id.titleTextView);
        posterImageView=itemView.findViewById(R.id.posterImageView);
    }

    public void bind(MostViewedVideo mostViewedVideo) {
        this.mostViewedVideo=mostViewedVideo;
        titleTextView.setText(mostViewedVideo.getTitle());
        Picasso.get().load(mostViewedVideo.getSmallPoster()).fit().error(R.drawable.ic_baseline_terrain_24).into(posterImageView);
    }
}
