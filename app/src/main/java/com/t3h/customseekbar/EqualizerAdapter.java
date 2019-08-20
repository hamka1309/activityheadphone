package com.t3h.customseekbar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EqualizerAdapter extends RecyclerView.Adapter<EqualizerAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Equalizer> data;

    public EqualizerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<Equalizer> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.item_equalizer, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Equalizer item = data.get(i);
        viewHolder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ivImage;
        private TextView tvTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_equalizer);
            tvTitle = itemView.findViewById(R.id.tv_equalizer);

        }

        public void bindData(Equalizer s) {

        }
    }

}
