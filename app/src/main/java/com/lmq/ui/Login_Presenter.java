package com.lmq.ui;

import com.lmq.base.BaseActivity;
import com.lmq.base.BasePresenter;
import com.lmq.common.Appservices;
import com.lmq.http.CommonAllHttpCallback;
import com.lmq.http.CommonHttpCallback;
import com.lmq.tool.LmqTool;
import com.r.http.cn.utils.LogUtils;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/12/25 0025.
 */

public class Login_Presenter extends BasePresenter<Login_View, LifecycleProvider> {
    private final String TAG = Login_Presenter.class.getSimpleName();
    private final String test="";

    public Login_Presenter(Login_View view, LifecycleProvider activity) {
        super(view, activity);
    }

    /**
     * 登录
     *
     * @author ZhongDaFeng
     */
    public void     login(String userName, String password) {

        if (getView() != null)
            // getView().showLoading();
            ((BaseActivity)getActivity()).showLoading();



        CommonHttpCallback httpCallback = new CommonHttpCallback<String>() {

            @Override
            public String convert(String data) {
                return data;
               // return new Gson().fromJson(data, String.class);
            }

            @Override
            public void onSuccess(String object) {
                if (getView() != null) {

                    ((BaseActivity)getActivity()).closeLoading();
                    if(object!=null) {

                        getView().loginresult(object);
                    }
                }
            }

            @Override
            public void onError(int code, String desc) {
                if (getView() != null) {

                    ((BaseActivity)getActivity()).showError(desc);
                }
            }

            @Override
            public void onCancel() {
                LogUtils.e("请求取消了");
                if (getView() != null) {

                    ((BaseActivity)getActivity()).closeLoading();
                }
            }
        };

        new Appservices().login(userName, password, getActivity(), httpCallback);


    }
    public void getContent() {

        if (getView() != null)
            // getView().showLoading();
            ((BaseActivity)getActivity()).showLoading();



        CommonAllHttpCallback httpCallback = new CommonAllHttpCallback<String>() {

            @Override
            public String convert(String data) {
                return data;
                // return new Gson().fromJson(data, String.class);
            }

            @Override
            public void onSuccess(String object) {
                if (getView() != null) {

                    ((BaseActivity)getActivity()).closeLoading();
                    if(object!=null) {

                        getView().loginresult(object);
                    }
                }
            }

            @Override
            public void onError(int code, String desc) {
                if (getView() != null) {

                    ((BaseActivity)getActivity()).showError(desc);
                }
            }

            @Override
            public void onCancel() {
                LogUtils.e("请求取消了");
                if (getView() != null) {

                    ((BaseActivity)getActivity()).closeLoading();
                }
            }
        };


        new Appservices().getinitContent(getActivity(), httpCallback);

    }

}
