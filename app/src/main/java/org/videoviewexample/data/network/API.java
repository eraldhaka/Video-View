package org.videoviewexample.data.network;

import org.videoviewexample.data.model.RssModel;
import retrofit2.http.GET;
import rx.Observable;


public interface API {
    @GET("feed_firetv.xml")
    Observable<RssModel> getData();
}
