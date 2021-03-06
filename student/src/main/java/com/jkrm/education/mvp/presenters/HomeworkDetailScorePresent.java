package com.jkrm.education.mvp.presenters;

import com.hzw.baselib.interfaces.AwApiCallback;
import com.hzw.baselib.interfaces.AwApiSubscriber;
import com.hzw.baselib.presenters.AwCommonPresenter;
import com.hzw.baselib.util.AwDataUtil;
import com.jkrm.education.api.APIService;
import com.jkrm.education.api.RetrofitClient;
import com.jkrm.education.bean.common.ResponseBean;
import com.jkrm.education.bean.result.ReportQuestionScoreResultBean;
import com.jkrm.education.mvp.views.HomeworkDetailScoreView;

import java.util.List;

import rx.Observable;

public class HomeworkDetailScorePresent extends AwCommonPresenter implements HomeworkDetailScoreView.Presenter {

    private HomeworkDetailScoreView.View mView;

    public HomeworkDetailScorePresent(HomeworkDetailScoreView.View view) {
        this.mView = view;
    }

    @Override
    public void report_question(String homeworkId, String studentId) {
        Observable<ResponseBean<List<ReportQuestionScoreResultBean>>> observable = RetrofitClient.builderRetrofit()
                .create(APIService.class)
                .report_question(homeworkId, studentId);
        addIOSubscription(observable, new AwApiSubscriber(new AwApiCallback<List<ReportQuestionScoreResultBean>>() {
            @Override
            public void onStart() {
                mView.showLoadingDialog();
            }

            @Override
            public void onSuccess(List<ReportQuestionScoreResultBean> model) {
                mView.report_questionSuccess(model);
            }

            @Override
            public void onFailure(int code, String msg) {
                if(AwDataUtil.isEmpty(msg)) {
                    mView.report_questionFail(msg);
                    return;
                }
                if(msg.contains("Unterminated string at line") || msg.contains("Unexpected status")) {
                    report_question(homeworkId, studentId);
                } else {
                    mView.report_questionFail(msg);
                }
            }

            @Override
            public void onCompleted() {
                mView.dismissLoadingDialog();
            }
        }));
    }

}
