package org.videoviewexample.ui.main_activity;

import org.videoviewexample.data.model.ItemsModel;
import org.videoviewexample.data.model.RssModel;
import java.util.List;

public interface MainMvp {
    interface MainView {
        void showProgressDialog();

        void disableProgressDialog();

        void displayData(List<ItemsModel> itemsModels);
    }

    interface MainPresenter {
        void getDataFromPresenter();

        void showProgressDialog();

        void disableProgressDialog();

        void displayData(RssModel rssModel);
    }

    interface MainModel {
        void getDataFromXml();
    }
}
