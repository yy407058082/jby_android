package com.jkrm.education.mvp.presenters;

import com.hzw.baselib.interfaces.AwApiCallback;
import com.hzw.baselib.interfaces.AwApiSubscriber;
import com.hzw.baselib.presenters.AwCommonPresenter;
import com.hzw.baselib.util.AwDataUtil;
import com.jkrm.education.api.APIService;
import com.jkrm.education.api.RetrofitClient;
import com.jkrm.education.bean.common.ResponseBean;
import com.jkrm.education.bean.result.TeacherClassBean;
import com.jkrm.education.mvp.views.ClassesChoiceView;

import java.util.List;

import rx.Observable;

public class ClassesChoicePresent extends AwCommonPresenter implements ClassesChoiceView.Presenter {

    private ClassesChoiceView.View mView;

    public ClassesChoicePresent(ClassesChoiceView.View view) {
        this.mView = view;
    }

    @Override
    public void getTeacherClassList(String teacherId) {
        Observable<ResponseBean<List<TeacherClassBean>>> observable = RetrofitClient.builderRetrofit()
                .create(APIService.class)
                .getTeacherClassList(teacherId);
        addIOSubscription(observable, new AwApiSubscriber(new AwApiCallback<List<TeacherClassBean>>() {
            @Override
            public void onStart() {
                mView.showLoadingDialog();
            }

            @Override
            public void onSuccess(List<TeacherClassBean> model) {
                mView.getTeacherClassListSuccess(model);
            }

            @Override
            public void onFailure(int code, String msg) {
                if(AwDataUtil.isEmpty(msg)) {
                    mView.getTeacherClassListFail(msg);
                    return;
                }
                if(msg.contains("Unterminated string at line") || msg.contains("Unexpected status")) {
                    getTeacherClassList(teacherId);
                } else {
                    mView.getTeacherClassListFail(msg);
                }
            }

            @Override
            public void onCompleted() {
                mView.dismissLoadingDialog();
            }
        }));
    }

}
