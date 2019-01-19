package org.videoviewexample.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import static org.videoviewexample.util.Constants.THUMBNAIL_KEY;
import static org.videoviewexample.util.Constants.URL_KEY;

@Root(name = THUMBNAIL_KEY, strict = false)
public class ThumbnailModel {

    @Attribute(name = URL_KEY)
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}