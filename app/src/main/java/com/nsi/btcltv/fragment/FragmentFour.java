package com.nsi.btcltv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nsi.btcltv.R;


public class FragmentFour extends Fragment 
{

	View rootView;
	private String streamUrl;
	private io.vov.vitamio.widget.VideoView mVideoView;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{

		if(!io.vov.vitamio.LibsChecker.checkVitamioLibs(getActivity()))
			return null;

		rootView = inflater.inflate(R.layout.fragment_four ,container, false);


		mVideoView = (io.vov.vitamio.widget.VideoView)rootView.findViewById(R.id.vitamio_videoView);
		streamUrl = "rtmp://nextstep.srfms.com:2185/live//livestream";

		mVideoView.setVideoPath(streamUrl);
		mVideoView.setMediaController(new io.vov.vitamio.widget.MediaController(getActivity()));
		mVideoView.requestFocus();

		mVideoView.setOnPreparedListener(new io.vov.vitamio.MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(io.vov.vitamio.MediaPlayer mediaPlayer)
			{
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