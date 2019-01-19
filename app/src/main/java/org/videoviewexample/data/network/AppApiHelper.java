package org.videoviewexample.data.network;

import org.videoviewexample.data.model.RssModel;
import rx.Observable;

public class AppApiHelper implements ApiHelper {

    @Override
    public Observable<RssModel> getData() {
        return APIClient.getData().getData();
    }

}
