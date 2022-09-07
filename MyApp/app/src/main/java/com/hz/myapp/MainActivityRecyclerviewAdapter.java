package com.hz.myapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityRecyclerviewAdapter extends RecyclerView.Adapter<MainActivityRecyclerviewAdapter.ViewHolder> {

    private ArrayList<String> dataSource;
    private OnItemClickListener myClickListener;

    public MainActivityRecyclerviewAdapter(ArrayList<String>  list){
        dataSource = list;
    }


    public void setOnItemClickListener(OnItemClickListener myClickListener){
        this.myClickListener = myClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_recyclerview_item_layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String text = dataSource.get(position);
        viewHolder.textView.setText(text);
        final  int index = position;
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 myClickListener.onClick(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.main_text_view);
        }

    }
}
