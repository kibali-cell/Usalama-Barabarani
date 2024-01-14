package com.example.usalamabarabarani;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

public class ClipsFragment extends Fragment {

    private VideoView videoView1, videoView2, videoView3, videoView4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clips, container, false);

        TextView headingTextView = view.findViewById(R.id.headingTextView);
        headingTextView.setText("Clips");  // Optional: Set heading text dynamically

        videoView1 = view.findViewById(R.id.videoView1);
        videoView2 = view.findViewById(R.id.videoView2);
        videoView3 = view.findViewById(R.id.videoView3);
        videoView4 = view.findViewById(R.id.videoView4);

        playVideo();

        return view;
    }

    private void playVideo() {
        // Set video resource IDs (replace with your video file names without extension)
        int video1ResourceId = R.raw.mstelingi;
        int video2ResourceId = R.raw.ajali;
        int video3ResourceId = R.raw.manualcar;
        int video4ResourceId = R.raw.automatic;

        // Set video URIs for VideoViews
        Uri video1Uri = getRawResourceUri(video1ResourceId);
        Uri video2Uri = getRawResourceUri(video2ResourceId);
        Uri video3Uri = getRawResourceUri(video3ResourceId);
        Uri video4Uri = getRawResourceUri(video4ResourceId);

        // Set MediaController for each VideoView
        MediaController mediaController1 = new MediaController(requireContext());
        MediaController mediaController2 = new MediaController(requireContext());
        MediaController mediaController3 = new MediaController(requireContext());
        MediaController mediaController4 = new MediaController(requireContext());

        videoView1.setMediaController(mediaController1);
        videoView2.setMediaController(mediaController2);
        videoView3.setMediaController(mediaController3);
        videoView4.setMediaController(mediaController4);

        // Set anchor views for proper positioning
        mediaController1.setAnchorView(videoView1);
        mediaController2.setAnchorView(videoView2);
        mediaController3.setAnchorView(videoView3);
        mediaController4.setAnchorView(videoView4);

        // Set video URIs for VideoViews
        videoView1.setVideoURI(video1Uri);
        videoView2.setVideoURI(video2Uri);
        videoView3.setVideoURI(video3Uri);
        videoView4.setVideoURI(video4Uri);

        // Set OnClickListener for each VideoView
        videoView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideoPlayback(videoView1);
            }
        });

        videoView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideoPlayback(videoView2);
            }
        });

        videoView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideoPlayback(videoView3);
            }
        });

        videoView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideoPlayback(videoView3);
            }
        });
    }

    private void startVideoPlayback(VideoView videoView) {
        // Start playing the video associated with the clicked VideoView
        videoView.start();
    }


    private Uri getRawResourceUri(int resourceId) {
        return new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(getResources().getResourcePackageName(resourceId))
                .appendPath(getResources().getResourceTypeName(resourceId))
                .appendPath(getResources().getResourceEntryName(resourceId))
                .build();
    }

}


