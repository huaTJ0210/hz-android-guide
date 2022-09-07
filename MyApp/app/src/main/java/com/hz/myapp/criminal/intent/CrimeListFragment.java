package com.hz.myapp.criminal.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hz.myapp.OnItemClickListener;
import com.hz.myapp.R;

import java.util.List;
import java.util.UUID;

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private  CrimeAdapter mCrimeAdapter;
    private static  final  int REQUEST_CRIME = 1;
    private static  final  String TAG = "CrimeListFragment";
    private UUID mSelectedUUID  = null;

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void  updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> list = crimeLab.getCrimeList();

        if(mCrimeAdapter == null){
            mCrimeAdapter = new CrimeAdapter(list);
            mCrimeRecyclerView.setAdapter(mCrimeAdapter);
        }else{
            mCrimeAdapter.notifyDataSetChanged();
//            if(mSelectedUUID == null){
//                mCrimeAdapter.notifyDataSetChanged();
//            }else{
//                int index = 0;
//                for (Crime m :list){
//                    if(m.getId().equals(mSelectedUUID)){
//                        index = list.indexOf(m);
//                        break;
//                    }
//                }
//                // 高效更新list
//                Log.d(TAG, "updateUI: "+ index);
//                mCrimeAdapter.notifyItemChanged(index);
//            }

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list,container,false);
        // 列表配置
        mCrimeRecyclerView = view.findViewById(R.id.crime_recycle_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        final List<Crime> crimes = CrimeLab.get(getActivity()).getCrimeList();
//        CrimeAdapter adapter =  new CrimeAdapter(crimes);
//        adapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onClick(int position) {
//                Crime crime = crimes.get(position);
//                Toast.makeText(getActivity(),crime.getTitle(),Toast.LENGTH_SHORT).show();
//            }
//        });
//        mCrimeRecyclerView.setAdapter(adapter);
        updateUI();
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CRIME){
//            UUID uuid = (UUID)data.getSerializableExtra("crime_id");
//            mSelectedUUID = uuid;
//            Log.d(TAG, "onActivityResult: "+uuid);
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimeList;
        private OnItemClickListener mOnItemClickListener;

        public CrimeAdapter(List<Crime> crimes){
            mCrimeList = crimes;
        }

        public void  setOnItemClickListener(OnItemClickListener onItemClickListener){
            this.mOnItemClickListener = onItemClickListener;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            // i: 可以根据此标识符决定返回的ViewHolder的类型
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_crime,viewGroup,false);
            return new CrimeHolder(view);
        }

        @Override
        public int getItemViewType(int position) {
            // 可以根据模型对象中的view标识决定返回的int类型；默认是0；
            return super.getItemViewType(position);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder crimeHolder, int i) {
            final Crime crime = mCrimeList.get(i);
            crimeHolder.mTitleTextView.setText(crime.getTitle());
            crimeHolder.mDateTextView.setText(crime.getDate());
            // 视图的显示与隐藏
            crimeHolder.mImageView.setVisibility(crime.isSolved()? View.VISIBLE:View.GONE);
            crimeHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //mOnItemClickListener.onClick(position);
                    // 在Frame中启动activity
                  //  Intent intent = CrimeActivity.newIntent(getActivity(),crime.getId());
                    // startActivity(intent);
                    Intent intent = CrimePagerActivity.newIntent(getActivity(),crime.getId());
                    startActivityForResult(intent,REQUEST_CRIME);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mCrimeList.size();
        }


    }

    private static class CrimeHolder extends RecyclerView.ViewHolder{
        public TextView mTitleTextView;
        public TextView mDateTextView;
        public ImageView mImageView;

        public CrimeHolder(View itemView){
            super(itemView);
            mTitleTextView = itemView.findViewById(R.id.crime_title);
            mDateTextView = itemView.findViewById(R.id.crime_date);
            // id的命名必须全局唯一  模型_描述_组件名称
            mImageView =  itemView.findViewById(R.id.crime_solved_imageView);
        }
    }

}
