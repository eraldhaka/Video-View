package org.videoviewexample.data.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.util.List;
import static org.videoviewexample.util.Constants.CHANNEL_KEY;
import static org.videoviewexample.util.Constants.ITEM_KEY;

@Root(name = CHANNEL_KEY, strict = false)
public class ChannelModel {
    public ChannelModel() {}

    @ElementList(entry= ITEM_KEY, inline = true, required = false)
    private List<ItemsModel> modelList;

    public List<ItemsModel> getItems() {
        return modelList;
    }

    public void setArticles(List<ItemsModel> articles) {
        this.modelList = articles;
    }
}
