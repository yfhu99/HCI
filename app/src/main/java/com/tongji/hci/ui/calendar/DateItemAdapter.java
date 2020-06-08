package com.tongji.hci.ui.calendar;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tongji.hci.R;

import java.util.List;

public class DateItemAdapter extends RecyclerView.Adapter<DateItemAdapter.DateItemHolder> {

    private final List<String> mDays;
    private final int startPos;
    private final int endPos;
    private final int month;
    private final Context context;

    public DateItemAdapter(Context context, List<String> mDays, int startPos, int endPos, int month) {
        this.context = context;
        this.mDays = mDays;
        this.startPos = startPos;
        this.endPos = endPos;
        this.month = month;
    }

    @NonNull
    @Override
    public DateItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DateItemHolder(LayoutInflater.from(context).inflate(R.layout.date_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DateItemHolder holder, int position) {
        holder.mTextView.setText(mDays.get(position));
        if (position >= startPos && position <= endPos) {
            holder.mTextView.setTypeface(holder.mTextView.getTypeface(), Typeface.BOLD);
            if (month == 6 && mDays.get(position).equals("9")) {
                holder.mTextView.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDays.size();
    }

    public static class DateItemHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;

        public DateItemHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.date_grid_text);
        }
    }
}
