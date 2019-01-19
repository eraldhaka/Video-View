package org.videoviewexample.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import static org.videoviewexample.util.Constants.CHANNEL_KEY;
import static org.videoviewexample.util.Constants.RSS_KEY;


@Root(name = RSS_KEY, strict=false)
public class RssModel {

    public RssModel() {}

    @Element(name = CHANNEL_KEY)
    private ChannelModel channel;

    public ChannelModel getChannel() {
        return channel;
    }

    public void setChannel(ChannelModel channel) {
        this.channel = channel;
    }
}
