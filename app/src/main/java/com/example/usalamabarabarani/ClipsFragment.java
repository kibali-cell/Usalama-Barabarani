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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClipsFragment extends Fragment {

    private VideoView mainVideoView;
    private TextView currentTitleTextView;
    private MediaController mediaController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clips, container, false);

        TextView headingTextView = view.findViewById(R.id.headingTextView);
        headingTextView.setText("Clips");

        mainVideoView = view.findViewById(R.id.mainVideoView);
        currentTitleTextView = view.findViewById(R.id.currentClipTitle);
        RecyclerView recyclerView = view.findViewById(R.id.clipsRecyclerView);

        mediaController = new MediaController(requireContext());

        List<Clip> clips = buildClips();

        setupMainPlayer(clips.get(0));

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new ClipsAdapter(clips, new OnClipClickListener() {
            @Override
            public void onClipClick(Clip clip) {
                setupMainPlayer(clip);
            }
        }));

        return view;
    }

    private List<Clip> buildClips() {
        List<Clip> clips = new ArrayList<>();
        clips.add(new Clip(
                "Jinsi ya Kutumia Mstelingi wakati wa kuendesha",
                R.raw.mstelingi
        ));
        clips.add(new Clip(
                "Aina za ajali zitokeazo mara kwa mara",
                R.raw.ajali
        ));
        clips.add(new Clip(
                "Jinsi ya Kuendesha Gari la Manual",
                R.raw.manualcar
        ));
        clips.add(new Clip(
                "Jinsi ya Kuendesha Gari la Automatic",
                R.raw.automatic
        ));
        return clips;
    }

    private void setupMainPlayer(Clip clip) {
        mainVideoView.stopPlayback();
        Uri videoUri = getRawResourceUri(clip.videoResId);
        mainVideoView.setVideoURI(videoUri);
        mainVideoView.requestFocus();

        mainVideoView.setOnPreparedListener(mp -> {
            mainVideoView.setMediaController(mediaController);
            mediaController.setAnchorView(mainVideoView);
            mainVideoView.start();
        });

        currentTitleTextView.setText(clip.title);
    }

    private Uri getRawResourceUri(int resourceId) {
        return new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(getResources().getResourcePackageName(resourceId))
                .appendPath(getResources().getResourceTypeName(resourceId))
                .appendPath(getResources().getResourceEntryName(resourceId))
                .build();
    }

    private static class Clip {
        final String title;
        final int videoResId;

        Clip(String title, int videoResId) {
            this.title = title;
            this.videoResId = videoResId;
        }
    }

    private interface OnClipClickListener {
        void onClipClick(Clip clip);
    }

    private static class ClipsAdapter extends RecyclerView.Adapter<ClipsAdapter.ClipViewHolder> {

        private final List<Clip> clips;
        private final OnClipClickListener listener;

        ClipsAdapter(List<Clip> clips, OnClipClickListener listener) {
            this.clips = clips;
            this.listener = listener;
        }

        @NonNull
        @Override
        public ClipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_clip, parent, false);
            return new ClipViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ClipViewHolder holder, int position) {
            Clip clip = clips.get(position);
            holder.titleTextView.setText(clip.title);
            holder.itemView.setOnClickListener(v -> listener.onClipClick(clip));
        }

        @Override
        public int getItemCount() {
            return clips.size();
        }

        static class ClipViewHolder extends RecyclerView.ViewHolder {
            final TextView titleTextView;

            ClipViewHolder(@NonNull View itemView) {
                super(itemView);
                titleTextView = itemView.findViewById(R.id.clipTitle);
            }
        }
    }
}