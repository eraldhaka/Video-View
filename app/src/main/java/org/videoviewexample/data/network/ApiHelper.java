package org.videoviewexample.data.network;

import org.videoviewexample.data.model.RssModel;
import rx.Observable;

public interface ApiHelper {
    Observable<RssModel> getData();
}
