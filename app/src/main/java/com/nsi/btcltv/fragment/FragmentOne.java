package com.nsi.btcltv.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import android.graphics.Bitmap;
import android.graphics.Movie;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.koushikdutta.urlimageviewhelper.UrlImageViewCallback;


import com.nsi.btcltv.MyApplication;
import com.nsi.btcltv.R;
import com.nsi.btcltv.MainActivity;
import com.nsi.btcltv.adapter.CustomAdapter;
import com.nsi.btcltv.adapter.VodContentsListAdapter;
import com.nsi.btcltv.helper.TvHelper;
import com.nsi.btcltv.helper.Video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FragmentOne extends Fragment 
{	
	ListView lv_two;
	ViewFlipper mViewFlipper;
	
    private List<String> imageURLs = Arrays.asList(new String[]{
			"http://cream-netca.com/spa/stream/pic1.png",
			"http://cream-netca.com/spa/stream/pic2.png",
			"http://cream-netca.com/spa/stream/pic3.png",
			"http://cream-netca.com/spa/stream/pic5.png",
			"http://cream-netca.com/spa/stream/pic7.png",
			"http://cream-netca.com/spa/stream/pic9.png"});
    
    private int index = 0;  
    
    ImageView img;
    Bitmap bitmap;


	View rootView;
	ListView vod_content_listview;
	private List<Video> contentList = new ArrayList<Video>();
	private VodContentsListAdapter adapter;
	
	@Override
	  public View onCreateView(LayoutInflater inflater, final ViewGroup container,
	      Bundle savedInstanceState) {
	    rootView = inflater.inflate(R.layout.fragment_one,container, false);

		mViewFlipper = (ViewFlipper)rootView.findViewById(R.id.viewFlipper1);

		ImageView imageView = new ImageView(getActivity());
		UrlImageViewHelper.setUrlDrawable(imageView, getNextImage());
		//Ion.with(imageView).placeholder(R.drawable.pic9).load(getNextImage());
		mViewFlipper.addView(imageView);

		final Handler handler = new Handler();
		Runnable r = new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					//do your code here
					ImageView imageView = new ImageView(getActivity());
					UrlImageViewHelper.setUrlDrawable(imageView, getNextImage());

					Ion.with(imageView).placeholder(R.drawable.pic9).load(getNextImage());
					mViewFlipper.addView(imageView);
					mViewFlipper.showNext();
					// Adding the image to the flipper

					Log.e("Image No: ", "" + getNextImage());

					//also call the same runnable

				}
				catch (Exception e) {
					// TODO: handle exception
				}
				finally{
					//also call the same runnable

				}
			}
		};

		handler.postDelayed(r, 2000);


		mViewFlipper.setAutoStart(true);


		vod_content_listview = (ListView)rootView.findViewById(R.id.listView2);
		adapter = new VodContentsListAdapter((MainActivity)getActivity(),contentList);
		vod_content_listview.setAdapter(adapter);

		vod_contents_load();


		vod_content_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				Video item = contentList.get(position);
				switchScreen(item.getTitle(),item.getVdoUrl());
			}
		});

		return rootView;
	  }
	
	
	protected String getNextImage()
	{
		if (index == imageURLs.size())
			index = 0;
		return imageURLs.get(index++);
	}


	public void vod_contents_load()
	{
		//String old_url = "http://nextstepbpo.com/restApi/getContents/ALL/0/10/";
		JsonArrayRequest movieReq = new JsonArrayRequest(
				"http://cream-netca.com/spa/stream/two.php" ,
				new Response.Listener<JSONArray>()
				{
					@Override
					public void onResponse(JSONArray response)
					{
						Log.d("Length:", response.length() + "");
						Log.d("Response:", response.toString());

						//Parsing json
						for (int i = 0; i < response.length(); i++)
						{
							try
							{
								JSONObject obj = response.getJSONObject(i);

								Log.d("Image Link", TvHelper.baseImageUrl() + obj.getString("image_link"));
								Video movie = new Video();
								movie.setImageUrl(TvHelper.baseImageUrl() + obj.getString("image_link"));
								movie.setTitle(obj.getString("title"));
								movie.setDuration(obj.getString("duration"));
								movie.setCategory(obj.getString("directory"));
								movie.setSize(obj.getString("size"));
								movie.setDescription(obj.getString("details"));
								movie.setVdoUrl(obj.getString("filename"));

								// adding movie to movies array
								contentList.add(movie);
							}
							catch (JSONException e)
							{
								e.printStackTrace();
							}
						}

						// notifying list adapter about data changes
						// so that it renders the list view with updated data
						adapter.notifyDataSetChanged();
					}
				},
				new Response.ErrorListener()
				{
					@Override
					public void onErrorResponse(VolleyError error)
					{
						Log.d("Volley Error: ", error.getMessage());
					}
				});

		MyApplication.getInstance().addToRequestQueue(movieReq);
	}



	// screen switching and data transfer with key value pair
	public void switchScreen(String image_url,String vdo_url)
	{
		Fragment fragment = new BlankFragment();
		FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		Bundle b = new Bundle();
		b.putString("my_name" , image_url);
		b.putString("my_vdo" , vdo_url);
		fragment.setArguments(b);

		fragmentTransaction.replace(R.id.content_frame , fragment );
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}


	public void onDestroy()
	{
		super.onDestroy();
	}
}