package org.videoviewexample.ui.main_activity;

import org.videoviewexample.data.model.RssModel;

public class MainPresenter implements MainMvp.MainPresenter {

    private MainMvp.MainView mainView;
    private MainMvp.MainModel mainModel;

    MainPresenter(MainMvp.MainView mainView) {
        this.mainView = mainView;
        this.mainModel = new MainModel(this);
    }

    @Override
    public void getDataFromPresenter() {
        mainModel.getDataFromXml();
    }

    @Override
    public void showProgressDialog() {
        mainView.showProgressDialog();
    }

    @Override
    public void disableProgressDialog() {
        mainView.disableProgressDialog();
    }

    @Override
    public void displayData(RssModel rssModel) {
        mainView.displayData(rssModel.getChannel().getItems());
    }
}
