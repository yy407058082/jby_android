package com.jkrm.education.adapter.exam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jkrm.education.R;
import com.jkrm.education.bean.exam.ClassAchievementBean;
import com.jkrm.education.constants.Extras;
import com.jkrm.education.receivers.event.MessageEvent;
import com.jkrm.education.ui.activity.exam.StuInfoTableActivity;
import com.jkrm.education.widget.SynScrollerLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: Zhoujing
 * Createdate: 2020/9/7 10:05
 * Description: 班级成绩对比表adapter
 */
public class TableClassAdapter extends RecyclerView.Adapter<TableClassAdapter.ScrollViewHolder> {


    private final SynScrollerLayout mSynScrollerView;
    private final Map<String, List<String>> mDataMap;
    private List<String> mList;
    private boolean isMiss;
    private int index,tag;


    public TableClassAdapter(@Nullable Map<String, List<String>> data, SynScrollerLayout synScrollerView, int tag,boolean miss) {
        mSynScrollerView = synScrollerView;
        mDataMap = data;
        isMiss = miss;
        this.tag = tag;
        if (mDataMap != null) {
            mList = new ArrayList<>(mDataMap.keySet());
        }
    }

    @NonNull
    @Override
    public ScrollViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_scroll_layout, null);
        return new ScrollViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ScrollViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //列头
        mSynScrollerView.setOnScrollListener(new SynScrollerLayout.OnItemScrollView() {
            @Override
            public void OnScroll(int l, int t, int old1, int old2) {
                holder.mSynScrollerLayout.smoothScrollTo(l, 0);
            }
        });

        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mSynScrollerView.onTouchEvent(v, position, event);
                return false;
            }
        });

        if (position % 2 == 0)
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        else
            holder.itemView.setBackgroundColor(Color.parseColor("#F9FAFB"));

        index = position;
        //表头固定，直接填数据
        if (mDataMap != null && !mDataMap.isEmpty()) {
            holder.mView.setText(mList.get(position));
            List<String> values = mDataMap.get(mList.get(position));
            if (values != null) {
                for (int i = 0; i < values.size(); i++) {
                    initText(holder.itemView.getContext(), holder.mChildRoot, mDataMap.get(mList.get(position)).get(i), i);
                }
            } else {
                Toast.makeText(holder.itemView.getContext(), "Map数据异常！", Toast.LENGTH_SHORT).show();
            }
        }


    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    private void initText(Context context, LinearLayout linearLayout, String text, int num) {
        View inflate = View.inflate(context, R.layout.item_table_child_layout, null);
        TextView name = inflate.findViewById(R.id.item_table_child_tv);
        name.setText(text);
        if (!isMiss) {//未选缺考
            if (num == 6 || num == 9 || num == 12 || num == 15) {
                setTextTv(context, name,num);
            }
        } else {
            if (num == 5 || num == 8 || num == 11 || num == 14) {
                setTextTv(context, name,num);
            }
        }
        linearLayout.addView(inflate);
    }

    private void setTextTv(Context context, TextView textTv,int num) {
        textTv.setTextColor(context.getResources().getColor(R.color.blue));
        textTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textTv.getText().equals("0"))
                    Toast.makeText(context, "人数为0，无法查看！", Toast.LENGTH_SHORT).show();
                else {
                    //进入学生名单
                    EventBus.getDefault().post(new MessageEvent(2, num+"" ,tag));
                }
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    static class ScrollViewHolder extends RecyclerView.ViewHolder {

        public final TextView mView;
        public final SynScrollerLayout mSynScrollerLayout;
        public final LinearLayout mChildRoot;

        public ScrollViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView.findViewById(R.id.item_title_tv);
            mSynScrollerLayout = itemView.findViewById(R.id.item_ssl);
            mChildRoot = itemView.findViewById(R.id.item_ll_child_root);
////            ll_view = itemView.findViewById(R.id.ll_view);
//            for (int i = 0; i < 18; i++) {
//                View inflate = View.inflate(itemView.getContext(), R.layout.item_table_child_layout, null);
//                TextView name = inflate.findViewById(R.id.item_table_child_tv);
//                name.setText("内容" + i);
//                mChildRoot.addView(inflate);
//            }

        }
    }


}

