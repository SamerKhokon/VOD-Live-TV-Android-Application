package com.nsi.btcltv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nsi.btcltv.R;



public class FragmentSample extends Fragment{

	
	FragmentTabHost tabHost;
	View rootView;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{		
	    rootView = inflater.inflate(R.layout.fragment_sample ,container, false);
	    
	    tabHost = new FragmentTabHost(getActivity());
	    tabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_layout);

		Bundle arg1 = new Bundle();
		arg1.putInt("Arg for Frag1", 1);
		tabHost.addTab(tabHost.newTabSpec("Tab1").setIndicator("VOD"),
				FragmentTabVod.class, arg1);


		Bundle arg2 = new Bundle();
	    arg2.putInt("Arg for Frag2", 2);
	    tabHost.addTab(tabHost.newTabSpec("Tab2").setIndicator("Content"),
				FragmentTabContents.class, arg2);

	    Bundle arg3 = new Bundle();
	    arg3.putInt("Arg for Frag3", 3);
	    tabHost.addTab(tabHost.newTabSpec("Tab3").setIndicator("LIVE"),
	    		FragmentTabTv.class, arg3);
	    
	    
	    rootView = tabHost;
	    
	    return rootView;
	}


	public void onDestroy()
	{
		super.onDestroy();
	}
	
}
