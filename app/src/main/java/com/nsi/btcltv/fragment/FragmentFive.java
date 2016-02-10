package com.nsi.btcltv.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.nsi.btcltv.R;

public class FragmentFive extends Fragment 
{

	
	WebView wb;
	
	private String webUrl = "http://nextstepbpo.com/tv/";

	@SuppressLint("SetJavaScriptEnabled") 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		
	    View rootView = inflater.inflate(R.layout.fragment_five,container, false);

	    wb = (WebView)rootView.findViewById(R.id.webView1);
	    wb.getSettings().setJavaScriptEnabled(true);
	    wb.loadUrl(webUrl);

	    return rootView;
	}


	public void onDestroy()
	{
		super.onDestroy();
	}

}
