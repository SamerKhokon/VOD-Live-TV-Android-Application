package com.nsi.btcltv.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

import com.nsi.btcltv.R;

public class FragmentThree extends Fragment {


	TextSwitcher switcher;
	Animation slide_in_left, slide_out_right;
	
	String[] TextToSwitched = { "Comming Soon" , "Comming Soon" };
	int curIndex;
	
	
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	     Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_three ,container, false);
	    
 		switcher = (TextSwitcher)rootView.findViewById(R.id.textSwitcher1);
	    
	    slide_in_left   = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
	    slide_out_right = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);
	    
	    
	    switcher.setInAnimation(slide_in_left);
	    switcher.setOutAnimation(slide_out_right);
	    
	    switcher.setFactory(new ViewFactory(){
			@Override
			public View makeView() 
			{
				TextView textView = new TextView(getActivity());
			    textView.setTextSize(15);
			    textView.setTextColor(Color.RED);
			    textView.setGravity(Gravity.CENTER_HORIZONTAL);
			    textView.setTypeface(Typeface.DEFAULT_BOLD);
			    textView.setShadowLayer(10, 10, 10, Color.BLACK);
			    return textView;				
			}	    	
	    });
	    
	    curIndex = 0;
	    switcher.setText(TextToSwitched[curIndex]);
	    
	    
	    return rootView;
	  }


	public void onDestroy()
	{
		super.onDestroy();
	}
}