package com.hc.homecenter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hc.homecenter.R;
import com.hc.homecenter.model.CardData;
import com.hc.homecenter.ui.fragment.home.IndexFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeRecycleViewAdapter extends RecyclerView.Adapter<HomeRecycleViewAdapter.HomeViewHolder> {

    private Context mContext;
    private List<CardData> mCardViewList;

    public HomeRecycleViewAdapter(Context mContext, List<CardData> mCardViewList) {
        this.mContext = mContext;
        this.mCardViewList = mCardViewList;
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recy_indexfragment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        int img = mCardViewList.get(position).getImage();
        String tv = mCardViewList.get(position).getText();
        holder.mImageView.setImageResource(R.drawable.pic_no_rob);
        holder.tv.setText("分享");
    }


    @Override
    public int getItemCount() {
        return mCardViewList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView tv;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img_recy);
            tv = itemView.findViewById(R.id.img_tv);
        }
    }
}
