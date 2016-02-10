package com.nsi.btcltv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nsi.btcltv.R;
import com.nsi.btcltv.MainActivity;
import com.nsi.btcltv.adapter.*;

public class FragmentTwo extends Fragment {

	ListView lv_two;	 
	View rootView;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		
	    rootView = inflater.inflate(R.layout.fragment_two,container, false);
	    
	    int [] prgmImages={R.drawable.pic9,R.drawable.pic9,
				R.drawable.pic9,R.drawable.pic9,R.drawable.pic9,R.drawable.pic9,
				R.drawable.pic9,R.drawable.pic9,R.drawable.pic9};
	        
		    String [] prgmNameList={"Let Us C","c++","JAVA","Jsp",
		    		"Microsoft .Net","Android","PHP","Jquery","JavaScript"};
		
		    String [] durationList = {"00:60:07 min","00:20:20 min","00:30:20 min",
		    		"00:45:17 min","00:22:05 min","00:34:00 min",
					"00:40:27 min","00:27:06 min","00:31:08 min"};
		
		    String[] sizeList = {"100MB","102MB","100MB","102MB",
		    		"100MB","102MB","100MB","102MB","50MB"};
		
		    String[] categoryList = {"Movie","Natok","Movie",
		    		"Natok","Movie","Natok","Movie","Natok","Movie"};
		
		    String[] descList = {"Test Desc1","Test Desc2",
		    		"Test Desc3","Test Desc4","Test Desc5",
		    		"Test Desc6","Test Desc7","Test Desc8","Test Desc9"};	
	
	    
	   
        lv_two = (ListView)rootView.findViewById(R.id.listView2);
        lv_two.setAdapter(new CustomAdapter((MainActivity)getActivity() , prgmNameList ,durationList,sizeList,categoryList,descList, prgmImages));  	    
	    
	   
	    return rootView;
	  }

	public void onDestroy()
	{
		super.onDestroy();
	}
	
}