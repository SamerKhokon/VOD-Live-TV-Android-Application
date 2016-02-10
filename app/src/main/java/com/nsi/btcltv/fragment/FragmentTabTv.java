package com.nsi.btcltv.fragment;

import com.nsi.btcltv.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.vov.vitamio.widget.VideoView;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.MediaPlayer;


public class FragmentTabTv  extends Fragment{
	
	View rootView;
	//String VideoURL = "http://nextstepbpo.com/file/vdo.php";


	private String streamUrl;
	private VideoView mVideoView;


	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		if(!io.vov.vitamio.LibsChecker.checkVitamioLibs(getActivity()))
			return null;

		rootView = inflater.inflate(R.layout.fragment_tab_tv ,container, false);


		mVideoView = (VideoView)rootView.findViewById(R.id.vitamio_videoView);
		streamUrl = "rtmp://nextstep.srfms.com:2185/live//livestream";

		mVideoView.setVideoPath(streamUrl);
		mVideoView.setMediaController(new MediaController(getActivity()));
		mVideoView.requestFocus();

		mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mediaPlayer) {
				//mediaPlayer.setPlaybackSpeed(1.0f);
				mediaPlayer.setPlaybackSpeed(1.0f);
                mediaPlayer.prepareAsync();
				mediaPlayer.start();

			}
		});

		return rootView;
	}


	public void startPlay(View view) {
		if (!TextUtils.isEmpty("rtmp://nextstep.srfms.com:2185/live//livestream")) {
			mVideoView.setVideoPath("rtmp://nextstep.srfms.com:2185/live//livestream");
		}
	}

	public void openVideo(View View) {
		mVideoView.setVideoPath("rtmp://nextstep.srfms.com:2185/live//livestream");
	}

	public void onDestroy()
	{
		super.onDestroy();
	}

}
