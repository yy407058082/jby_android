package com.jkrm.education.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jkrm.education.R;
import com.jkrm.education.bean.exam.ExamReadHeaderBean;
import com.jkrm.education.bean.test.TestMarkKindsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 选择题号
 * @Author: xiangqian
 * @CreateDate: 2020/7/8 15:08
 */

public class ChooseQuestionNumlAdapter extends BaseQuickAdapter<ExamReadHeaderBean, BaseViewHolder> {
    private List<ExamReadHeaderBean> mList = new ArrayList<>();

    public ChooseQuestionNumlAdapter() {
        super(R.layout.adapter_item_choose_a_school_item_layout);
    }

    public void addAllData(List<ExamReadHeaderBean> dataList) {
        this.mList = dataList;
        this.setNewData(mList);
        notifyDataSetChanged();
    }

    public void clearData() {
        if (mList != null) {
            int startPosition = 0;//hasHeader is 1
            int preSize = this.mList.size();
            if (preSize > 0) {
                this.mList.clear();
                notifyItemRangeRemoved(startPosition, preSize);
            }
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, ExamReadHeaderBean item) {
        TextView tv_name = helper.getView(R.id.tv_name);
        if(item.isChecked()) {
            tv_name.setSelected(true);
            tv_name.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.aw_bg_blue_radius_5));
        } else {
            tv_name.setSelected(false);
            tv_name.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.aw_bg_gray_f4f4f4_radius4));
        }
        helper.setText(R.id.tv_name,"题号"+ item.getQuestionNum())
                .addOnClickListener(R.id.tv_name);
    }
}
