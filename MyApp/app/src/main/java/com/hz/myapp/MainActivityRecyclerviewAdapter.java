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
    private Context context;
    public MainActivityRecyclerviewAdapter(ArrayList<String>  list, Context context){
        dataSource = list;
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.main_text_view);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_recyclerview_item_layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        // 增加点击事件
        final Context context = this.context;
        final int  index = i;
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).openActivity(index);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String text = dataSource.get(i);
        viewHolder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
