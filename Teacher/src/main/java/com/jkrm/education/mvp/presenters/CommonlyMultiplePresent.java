package com.jkrm.education.mvp.presenters;

import com.hzw.baselib.interfaces.AwApiCallback;
import com.hzw.baselib.interfaces.AwApiSubscriber;
import com.hzw.baselib.presenters.AwCommonPresenter;
import com.jkrm.education.api.APIService;
import com.jkrm.education.api.RetrofitClient;
import com.jkrm.education.bean.common.ResponseBean;
import com.jkrm.education.bean.exam.ExamCourseBean;
import com.jkrm.education.bean.exam.ExamReadHeaderBean;
import com.jkrm.education.bean.exam.MultipleAchievementBean;
import com.jkrm.education.mvp.views.CommonlyMultipleView;

import java.util.List;

import okhttp3.RequestBody;
import rx.Observable;
import rx.Subscriber;

/**
 * @Author: Zhoujing
 * Createdate: 2020/9/1 18:35
 * Description:
 */
public class CommonlyMultiplePresent extends AwCommonPresenter implements CommonlyMultipleView.Presenter {


    private CommonlyMultipleView.View mView;

    public CommonlyMultiplePresent(CommonlyMultipleView.View view) {
        this.mView = view;
    }

    @Override
    public void getMultipleAchievementList(RequestBody requestBody) {
        //接口访问逻辑
        Observable<MultipleAchievementBean> observable = RetrofitClient.builderRetrofit()
                .create(APIService.class)
                .getMultipleTable(requestBody);
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
                    MultipleAchievementBean data = (MultipleAchievementBean) o;
                    if (data.getCode().equals("200"))
                        mView.getMultipleAchievementSuccess(data);
                    else
                        mView.getMultipleAchievementListFail(data.getMsg());
                } else
                    mView.getMultipleAchievementListFail("数据异常！！");
            }
        });
    }



    @Override
    public void getExamCourse(RequestBody requestBody) {
        Observable<ResponseBean<List<ExamCourseBean>>> observable = RetrofitClient.builderRetrofit()
                .create(APIService.class)
                .getExamCourse(requestBody);
        addIOSubscription(observable, new AwApiSubscriber(new AwApiCallback<List<ExamCourseBean>>() {
            @Override
            public void onStart() {
                mView.showLoadingDialog();
            }

            @Override
            public void onSuccess(List<ExamCourseBean> data) {
                mView.getExamCourseSuccess(data);
            }



            @Override
            public void onFailure(int code, String msg) {
                mView.getExamCourseFail(msg);
            }

            @Override
            public void onCompleted() {
                mView.dismissLoadingDialog();
            }
        }));
    }
}
