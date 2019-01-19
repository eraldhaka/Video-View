package org.videoviewexample.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import static org.videoviewexample.util.Constants.CONTENT_KEY;
import static org.videoviewexample.util.Constants.ITEM_KEY;
import static org.videoviewexample.util.Constants.TITLE_KEY;


@Root(name = ITEM_KEY, strict = false)
public class ItemsModel {

    @Element(name = TITLE_KEY)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


   @Element(name= CONTENT_KEY)
    private MediaContentModel mediaContentModel;

    public MediaContentModel getMediaContentModel() {
        return mediaContentModel;
    }

}
