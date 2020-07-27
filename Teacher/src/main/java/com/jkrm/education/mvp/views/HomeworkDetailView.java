package com.jkrm.education.mvp.views;

import com.hzw.baselib.base.AwBasePresenter;
import com.hzw.baselib.base.AwBaseView;
import com.jkrm.education.bean.result.AnswerSheetDataDetailResultBean;
import com.jkrm.education.bean.result.HomeworkDetailResultBean;
import com.jkrm.education.bean.result.HomeworkStudentAnswerWithSingleQuestionResultBean;
import com.jkrm.education.bean.result.MaxScoreResultBean;
import com.jkrm.education.bean.result.QuestionSpecialResultBean;
import com.jkrm.education.bean.result.VideoPointResultBean;
import com.jkrm.education.bean.result.VideoResultBean;

import java.util.List;

import retrofit2.http.Path;


/**
 * Created by hzw on 2018/11/13
 */
public interface HomeworkDetailView extends AwBaseView {

    interface Presenter extends AwBasePresenter {
        void getHomeworkDetail(String homeworkId, String classid);
        void getVideos(String params);
        void getHomeworkStudentScoreList(String homeworkId, String classid);
        void getHomeworkStudentScoreWithQuestionSingle(String rightResult, String homeworkId, String classId, String questionId);
        void getQuestionSpecial(String homeworkId, String questionId);
        void getVideoPointList(String homework_id);
        void getVideoPointListNew(String homework_id);
    }

    interface View extends AwBaseView {
        void getHomeworkDetailSuccess(HomeworkDetailResultBean bean);
        void getHomeworkDetailFail(String msg);

        void getVideosSuccess(VideoResultBean result);
        void getVideoFail(String msg);

        void getHomeworkStudentScoreWithQuestionSingleSuccess(String rightResult, List<HomeworkStudentAnswerWithSingleQuestionResultBean> list);
        void getHomeworkStudentScoreWithQuestionSingleFail(String msg);

        void getHomeworkStudentScoreListSuccess(String model);
        void getHomeworkStudentScoreListFail(String msg);

        void getQuestionSpecialSuccess(List<QuestionSpecialResultBean> list);
        void getQuestionSpecialFail(String msg);

        void getVideoPointListSuccess(List<VideoPointResultBean> list);
        void getVideoPointListFail(String msg);

        void getVideoPointListNewSuccess(List<VideoPointResultBean> list);
        void getVideoPointListNewFail(String msg);
    }

}