package com.nsi.btcltv.fragment;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.MediaController;

import com.nsi.btcltv.R;


public class BlankFragment extends Fragment
{
    View rootView;
    VideoView vv;
    TextView txtv;

    VideoView video;
    private MediaController mediaControls;
    String path="http://cream-netca.com/spa/stream/";
   // String path1="http://commonsware.com/misc/test2.3gp";
   private int position = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_blank, container, false);


        if (mediaControls == null) {
            mediaControls = new MediaController(getActivity());
        }

        vv = (VideoView)rootView.findViewById(R.id.vod_single_item);
        txtv = (TextView)rootView.findViewById(R.id.blank_txt);

        savedInstanceState = getArguments();

        Log.d("Transfered Data:", savedInstanceState.getString("my_name").toString());
        txtv.setText(savedInstanceState.getString("my_name").toString());

        try {
            Uri uri = Uri.parse(path + savedInstanceState.getString("my_vdo").toString());

            video = (VideoView) rootView.findViewById(R.id.vod_single_item);
            video.setVideoURI(uri);
        }
        catch (Exception ex){

        }
        //video.start();
        video.requestFocus();

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video.seekTo(position);
                if(position == 0 ) {
                    video.start();
                }else{
                    video.pause();
                }
            }
        });

        return rootView;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

}
