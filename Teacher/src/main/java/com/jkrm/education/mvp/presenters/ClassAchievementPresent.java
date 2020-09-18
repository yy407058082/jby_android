package com.jkrm.education.mvp.presenters;

import com.hzw.baselib.interfaces.AwApiCallback;
import com.hzw.baselib.interfaces.AwApiSubscriber;
import com.hzw.baselib.presenters.AwCommonPresenter;
import com.jkrm.education.api.APIService;
import com.jkrm.education.api.RetrofitClient;
import com.jkrm.education.bean.common.ResponseBean;
import com.jkrm.education.bean.exam.ClassAchievementBean;
import com.jkrm.education.bean.exam.MultipleAchievementBean;
import com.jkrm.education.mvp.views.ClassAchievementView;

import okhttp3.RequestBody;
import rx.Observable;
import rx.Subscriber;

public class ClassAchievementPresent extends AwCommonPresenter implements ClassAchievementView.Presenter {

    private ClassAchievementView.View mView;

    public ClassAchievementPresent(ClassAchievementView.View view) {
        this.mView = view;
    }


    @Override
    public void getTableList(RequestBody requestBody) {
        Observable<ClassAchievementBean> observable = RetrofitClient.builderRetrofit()
                .create(APIService.class)
                .getClassTable(requestBody);
        addIOSubscription(observable, new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                if (o != null) {
                    ClassAchievementBean data = (ClassAchievementBean) o;
                    if (data.getCode().equals("200"))
                        mView.getTableListSuccess(data);
                    else
                        mView.getTableListFail(data.getMsg());
                } else
                    mView.getTableListFail("数据异常！！");
            }
        });

    }


}
