package com.hzw.baselib.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzw.baselib.R;
import com.hzw.baselib.project.student.bean.MarkBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzw on 2018/03/29.
 */

public class CommonTopListWithIconAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {

    private List<? extends Object> mList = new ArrayList<>();

    public CommonTopListWithIconAdapter() {
        super(R.layout.view_item_common_pupupwidow_top_with_icon);
        if(mList == null)
            mList = new ArrayList<>();
    }

    @Override
    protected void convert(BaseViewHolder helper, final Object bean) {
        if(bean == null)
            return;
        if(bean instanceof String) {
            helper.setText(R.id.tv_name, (String) bean);
        }else if(bean instanceof MarkBean) {
            helper.setText(R.id.tv_name, ((MarkBean) bean).getTitle());
            helper.setVisible(R.id.image,((MarkBean)bean).isSelect());
        }
    }

    public void addAllData(List<? extends Object> dataList) {
        this.mList = dataList;
        this.setNewData((List<Object>) mList);
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
