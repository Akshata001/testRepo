package com.akshata.testapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akshata.testapplication.OnLoadMoreListener;
import com.akshata.testapplication.R;
import com.akshata.testapplication.bean.Videos;
import com.akshata.testapplication.util.SingletonUtil;
import com.bumptech.glide.Glide;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private final Context context;
    private OnLoadMoreListener onLoadMoreListener;
    private boolean isLoading;

    private List<Videos> videosList;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    public VideoAdapter(RecyclerView recyclerView, List<Videos> videosList, Context context) {
        this.videosList = videosList;
        this.context = context;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return videosList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            //show row_item for data
            View view = LayoutInflater.from(context).inflate(R.layout.row_item_videos, parent, false);
            return new UserViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            //show row_item for progressbar
            View view = LayoutInflater.from(context).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UserViewHolder) {
            Videos videos = videosList.get(position);
            UserViewHolder userViewHolder = (UserViewHolder) holder;
            userViewHolder.textViewVideoTitle.setText(videos.getTitle());
            userViewHolder.textViewVideoDesc.setText(Html.fromHtml(videos.getDescription()));
            userViewHolder.textViewUploadedDate.setText(SingletonUtil.getSingletonConfigInstance().setDateTimeFormat(videos.getUploadDate()));
            userViewHolder.textViewUsername.setText(videos.getUserName());

            Glide.with(context).load(videos.getThumbnailMedium()).into(userViewHolder.imageViewVideoThumbnail);
            Glide.with(context).load(videos.getUserPortraitMedium()).into(userViewHolder.imageViewUserThumbnailImg);

        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return videosList == null ? 0 : videosList.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {

        public ProgressBar progressBar;

        public LoadingViewHolder(View view) {
            super(view);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);
        }
    }

    private class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewUserThumbnailImg;
        private ImageView imageViewVideoThumbnail;
        private ImageView imageViewShowMore;
        private TextView textViewUsername;
        private TextView textViewUploadedDate;
        private TextView textViewVideoDesc;
        public TextView textViewVideoTitle;
        private boolean showDetail = false;


        public UserViewHolder(View view) {
            super(view);
            textViewVideoTitle = (TextView) view.findViewById(R.id.textViewVideoTitle);
            textViewVideoDesc = (TextView) view.findViewById(R.id.textViewVideoDesc);
            textViewUploadedDate = (TextView) view.findViewById(R.id.textViewUploadedDate);
            textViewUsername = (TextView) view.findViewById(R.id.textViewUsername);
            imageViewShowMore = (ImageView) view.findViewById(R.id.imageViewShowMore);
            imageViewVideoThumbnail = (ImageView) view.findViewById(R.id.imageViewVideoThumbnail);
            imageViewUserThumbnailImg = (ImageView) view.findViewById(R.id.imageViewUserThumbnailImg);

            imageViewShowMore.setBackgroundResource(R.drawable.ic_action_down);
            textViewVideoDesc.setVisibility(View.GONE);

            //handle to show/hide description text on clicking more button

            imageViewShowMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (showDetail) {
                        imageViewShowMore.setBackgroundResource(R.drawable.ic_action_down);

                        //move up animation
                        Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_up);
                        textViewVideoDesc.startAnimation(slideUp);
                        textViewVideoDesc.setVisibility(View.GONE);
                        showDetail = false;

                    } else {
                        imageViewShowMore.setBackgroundResource(R.drawable.ic_action_up);

                        textViewVideoDesc.setVisibility(View.VISIBLE);
                        //move down animation
                        Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
                        textViewVideoDesc.startAnimation(slideDown);
                        showDetail = true;

                    }
                }
            });
        }
    }


}