package com.example.bhoomi.retrofitgetexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bhoomi.retrofitgetexample.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {

    private List<Item> items;
    private Context mContext;
    private PostItemListener mPostListener;

    public AnswersAdapter(Context items, List<Item> mContext) {
        this.items = mContext;
        this.mContext = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postview =  inflater.inflate(R.layout.lisst_item,parent,false);

        return new ViewHolder(postview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Item item = items.get(position);
        TextView textView = holder.titleTv;
        textView.setText(item.getOwner().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleTv;
        PostItemListener mItemListener;


        public ViewHolder(View itemView) {
            super(itemView);

            titleTv = (TextView) itemView.findViewById(R.id.tv);

            this.mItemListener = mPostListener;

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

        }
    }

    public void updateAnswers(List<Item> item) {
        items = item;
        notifyDataSetChanged();
    }

    private Item getItem(int adapterPosition) {
        return items.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }
}
