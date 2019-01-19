package org.videoviewexample.ui.main_activity;

import org.videoviewexample.data.model.RssModel;
import org.videoviewexample.data.network.ApiHelper;
import org.videoviewexample.data.network.AppApiHelper;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainModel implements MainMvp.MainModel {
    private MainMvp.MainPresenter mainPresenter;
    private ApiHelper apiHelper;

    public MainModel(MainMvp.MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
        this.apiHelper = new AppApiHelper();
    }

    @Override
    public void getDataFromXml() {
        mainPresenter.showProgressDialog();
        apiHelper.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RssModel>() {
                    @Override
                    public void onCompleted() {
                        //
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainPresenter.disableProgressDialog();
                    }

                    @Override
                    public void onNext(RssModel rssModel) {
                        mainPresenter.disableProgressDialog();
                        mainPresenter.displayData(rssModel);
                    }
                });
    }
}
