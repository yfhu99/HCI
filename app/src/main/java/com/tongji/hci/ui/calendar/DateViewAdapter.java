package com.tongji.hci.ui.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tongji.hci.R;

import java.util.ArrayList;
import java.util.List;

public class DateViewAdapter extends RecyclerView.Adapter<DateViewAdapter.DateViewHolder> {

    public DateViewAdapter(Context mContext, List<String> mMonth) {
        this.mContext=mContext;
        this.mMonth = mMonth;
    }

    private final List<String> mMonth;
    private final Context mContext;

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DateViewHolder(LayoutInflater.from(mContext).inflate(R.layout.date_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        List<String> mDays=new ArrayList<>();
        int preStart,preEnd,days,nextEnd;
        //如果是五月: 26-6
        if(position==0){
            preStart=26;
            preEnd=30;
            days=31;
            nextEnd=6;
        }else if(position==1){
            preStart=31;
            preEnd=31;
            days=30;
            nextEnd=11;
        }else{
            preStart=28;
            preEnd=30;
            days=31;
            nextEnd=8;
        }
        int startPos=0,endPos=0;
        //填入上个月剩下的天数
        for(int i=preStart;i<=preEnd;i++){
            mDays.add(String.valueOf(i));
            startPos++;
        }
        endPos=startPos;
        //填入本月天数
        for (int i = 1; i <= days; i++) {
            mDays.add(String.valueOf(i));
            endPos++;
        }
        endPos--;
        //填入下个月天数
        for (int i = 1; i <= nextEnd; i++) {
            mDays.add(String.valueOf(i));
        }
        //创建holder
        holder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,7));
        holder.mRecyclerView.setAdapter(new DateItemAdapter(mContext,mDays,startPos,endPos,position+5));
        if(position==1){
            holder.mButton_1.setVisibility(View.VISIBLE);
            holder.mButton_2.setVisibility(View.VISIBLE);
            holder.mButton_3.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mMonth.size();
    }

    public static class DateViewHolder extends RecyclerView.ViewHolder {
        public final RecyclerView mRecyclerView;
        public final Button mButton_1;
        public final Button mButton_2;
        public final Button mButton_3;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            mRecyclerView=itemView.findViewById(R.id.date_grid);
            mButton_1=itemView.findViewById(R.id.test_button_1);
            mButton_2=itemView.findViewById(R.id.test_button_2);
            mButton_3=itemView.findViewById(R.id.test_button_3);
        }
    }
}
