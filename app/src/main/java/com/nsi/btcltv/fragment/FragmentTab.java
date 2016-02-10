package com.nsi.btcltv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nsi.btcltv.R;

public class FragmentTab extends Fragment
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.fragment_layout, container, false);
		TextView tv = (TextView) v.findViewById(R.id.text);
		tv.setText(this.getTag() + " Content");
		return v;
	}

	public void onDestroy()
	{
		super.onDestroy();
	}
}
