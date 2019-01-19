package org.videoviewexample.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import static org.videoviewexample.util.Constants.CONTENT_KEY;
import static org.videoviewexample.util.Constants.DURATION_KEY;
import static org.videoviewexample.util.Constants.THUMBNAIL_KEY;
import static org.videoviewexample.util.Constants.URL_KEY;

@Root(name = CONTENT_KEY, strict = false)
public class MediaContentModel {

    @Attribute(name = DURATION_KEY)
    private String duration;

    @Attribute(name = URL_KEY)
    private String url;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Element(name = THUMBNAIL_KEY)
    private ThumbnailModel thumbnailModel;

    public ThumbnailModel getThumbnailModel() {
        return thumbnailModel;
    }
}




//<media:thumbnail url="http://sample-firetv-web-app.s3-website-us-west-2.amazonaws.com/images/thumbs/perspective.jpg"/>