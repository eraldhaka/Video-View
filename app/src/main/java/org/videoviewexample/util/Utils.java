package org.videoviewexample.util;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import org.videoviewexample.ui.preview_activity.PreviewActivity;
import static org.videoviewexample.util.Constants.URL_PARAMETER;

public class Utils {

    public static void loadImage(Context mContext, String url, ImageView image){
        Glide.with(mContext)
                .load(url)
                .into(image);
    }


    public static String getValue(PreviewActivity activity, Bundle savedInstanceState){
        String value;
        if (savedInstanceState == null) {
            Bundle extras = activity.getIntent().getExtras();
            if(extras == null) {
                value= null;
            } else {
                value= extras.getString(URL_PARAMETER);
            }
        } else {
            value= (String) savedInstanceState.getSerializable(URL_PARAMETER);
        }
        return value;
    }
}
