package umn.ac.id.myweek7b_chotiwut_34993;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarVideoAdapter extends RecyclerView.Adapter<DaftarVideoAdapter.ItemVideoViewHolder> {
    private LinkedList<SumberVideo> mDaftarVideo;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarVideoAdapter(Context context, LinkedList<SumberVideo> daftarVideo) {
        this.mContext = context;
        this.mDaftarVideo = daftarVideo;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.video_item_layout, parent, false);
        return new ItemVideoViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarVideoAdapter.ItemVideoViewHolder holder, int position) {
        SumberVideo mSumberVideo = mDaftarVideo.get(position);
        holder.tvTitle.setText(mSumberVideo.getJudul());
        holder.tvDetail.setText(mSumberVideo.getKeterangan());
        holder.tvUri.setText(mSumberVideo.getVideoURI());
        holder.videoBox.setVideoURI(Uri.parse(mSumberVideo.getVideoURI()));
        holder.videoBox.seekTo(100);
    }

    @Override
    public int getItemCount() {
        return mDaftarVideo.size();
    }

    public class ItemVideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private VideoView videoBox;
        private TextView tvTitle;
        private TextView tvDetail;
        private TextView tvUri;
        private DaftarVideoAdapter mAdapter;
        private int mPosition;
        private SumberVideo mSumberVideo;

        public ItemVideoViewHolder(@NonNull View itemView, DaftarVideoAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            videoBox = (VideoView) itemView.findViewById(R.id.videoBox);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDetail = (TextView) itemView.findViewById(R.id.tvDetail);
            tvUri = (TextView) itemView.findViewById(R.id.tvUri);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mPosition = getLayoutPosition();
            mSumberVideo = mDaftarVideo.get(mPosition);
            Intent detailIntent = new Intent(mContext, VideoDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("VideoDetail", mSumberVideo);
            detailIntent.putExtras(bundle);
            mContext.startActivity(detailIntent);
        }
    }
}