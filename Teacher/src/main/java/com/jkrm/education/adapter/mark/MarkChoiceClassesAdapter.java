package com.jkrm.education.adapter.mark;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jkrm.education.R;
import com.jkrm.education.bean.result.TeacherClassCouresResultBean.ClassListBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 批阅筛选_班级
 * Created by hzw on 2019/5/9.
 */

public class MarkChoiceClassesAdapter extends BaseQuickAdapter<ClassListBean, BaseViewHolder> {

    private List<ClassListBean> mList = new ArrayList<>();

    public MarkChoiceClassesAdapter() {
        super(R.layout.adapter_mark_choice_common);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ClassListBean bean) {
        TextView tv_name = helper.getView(R.id.tv_name);
        if(bean.isSelect()) {
            tv_name.setSelected(true);
            tv_name.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.aw_bg_blue_c8eaff_radius4));
        } else {
            tv_name.setSelected(false);
            tv_name.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.aw_bg_gray_f4f4f4_radius4));
        }
        helper.setText(R.id.tv_name, bean.getClassName())
                .addOnClickListener(R.id.tv_name);
    }

    public void addAllData(List<ClassListBean> dataList) {
        this.mList = dataList;
        this.setNewData(mList);
        notifyDataSetChanged();
    }

    public void clearData() {
        if(mList != null) {
            int startPosition = 0;//hasHeader is 1
            int preSize = this.mList.size();
            if(preSize > 0) {
                this.mList.clear();
                notifyItemRangeRemoved(startPosition, preSize);
            }
        }
    }
}
