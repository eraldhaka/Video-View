package org.videoviewexample.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.videoviewexample.R;
import org.videoviewexample.data.model.ItemsModel;
import org.videoviewexample.ui.preview_activity.PreviewActivity;
import org.videoviewexample.util.ItemClickListener;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import static org.videoviewexample.util.Constants.URL_PARAMETER;
import static org.videoviewexample.util.Utils.loadImage;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<ItemsModel> feedItemList;
    private Context mContext;

    public MainAdapter(Context mContext, List<ItemsModel> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.adapter_main, parent, false);
        return new MainAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, final int position) {
        final ItemsModel feedItem = feedItemList.get(position);

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(mContext,PreviewActivity.class);
                intent.putExtra(URL_PARAMETER, feedItem.getMediaContentModel().getUrl());
                mContext.startActivity(intent);
            }
        });

        holder.txtTitle.setText(String.format(mContext.getString(R.string.video_title),feedItem.getTitle()));
        holder.txtDuration.setText(String.format(mContext.getString(R.string.video_duration),feedItem.getMediaContentModel().getDuration()));
        loadImage(mContext,feedItem.getMediaContentModel().getThumbnailModel().getUrl(),holder.imgThumbnail);
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.image_view_thumbnail)
        ImageView imgThumbnail;
        @BindView(R.id.text_view_duration)
        TextView txtDuration;
        @BindView(R.id.text_view_title)
        TextView txtTitle;

        private ItemClickListener clickListener;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }
}




