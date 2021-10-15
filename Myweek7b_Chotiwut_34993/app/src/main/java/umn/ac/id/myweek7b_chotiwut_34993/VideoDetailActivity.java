package umn.ac.id.myweek7b_chotiwut_34993;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoDetailActivity extends AppCompatActivity {
    private VideoView vvDetail;
    private EditText etTitle;
    private EditText etDetail;
    private EditText etUri;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        vvDetail = (VideoView) findViewById(R.id.vvDetail);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etDetail = (EditText) findViewById(R.id.etDetail);
        etUri = (EditText) findViewById(R.id.etUri);
        btnBack = (Button) findViewById(R.id.btnBack);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberVideo sv = (SumberVideo) bundle.getSerializable("VideoDetail");
        etTitle.setText(sv.getJudul());
        etDetail.setText(sv.getKeterangan());
        etUri.setText(sv.getVideoURI());
        vvDetail.setVideoURI(Uri.parse(sv.getVideoURI()));
        vvDetail.seekTo(100);
        vvDetail.start();

        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(vvDetail);
        vvDetail.setMediaController(controller);

        btnBack.setOnClickListener(v -> finish());
    }
}