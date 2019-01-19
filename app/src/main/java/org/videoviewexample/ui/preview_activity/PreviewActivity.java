package org.videoviewexample.ui.preview_activity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;
import org.videoviewexample.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import static org.videoviewexample.util.Utils.getValue;

public class PreviewActivity extends AppCompatActivity {

    @BindView(R.id.video_view)
    VideoView videoView;
    private int position = 0;
    private ProgressDialog progressDialog;
    private MediaController mediaControls;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);

        String videoUrl = getValue(this, savedInstanceState);

        //media controller buttons
        if (mediaControls == null) {
            mediaControls = new MediaController(PreviewActivity.this);
        }

        progressDialog = new ProgressDialog(PreviewActivity.this);
        progressDialog.setMessage(getString(R.string.progress_dialog_message));
        progressDialog.setCancelable(false);
        progressDialog.show();
        try {
            videoView.setMediaController(mediaControls);
            videoView.setVideoURI(Uri.parse(videoUrl));
        } catch (Exception e) {
            Log.e(getString(R.string.error_message), e.getMessage());
            e.printStackTrace();
        }

        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                progressDialog.dismiss();
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                } else {
                    videoView.pause();
                }
            }
        });
    }
}
