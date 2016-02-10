package com.nsi.btcltv;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;


public class MyApplication extends Application
{
	    private RequestQueue mRequestQueue;
	    private ImageLoader mImageLoader;
	    private static MyApplication mInstance;
	    public static final String TAG = MyApplication.class.getSimpleName();

	    @Override
	    public void onCreate() 
	    {
	        super.onCreate();
	        mInstance = this;
	    }

	    public static synchronized MyApplication getInstance()
	    {
	        return mInstance;
	    }

	    public RequestQueue getReqQueue() 
	    {
	        if (mRequestQueue == null) 
	        {
	            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
	        }
	        return mRequestQueue;
	    }

	    public ImageLoader getImageLoader() 
	    {
	        getReqQueue();
	        if (mImageLoader == null) 
	        {
	            mImageLoader = new ImageLoader(this.mRequestQueue,
	                    new BitmapLruCache());
	        }
	        return this.mImageLoader;
	    }
	    
	    public <T> void addToRequestQueue(Request<T> req, String tag)
		{
	        // set the default tag if tag is empty
	        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
	        getReqQueue().add(req);
	    }
	 
	    public <T> void addToRequestQueue(Request<T> req)
		{
	        req.setTag(TAG);
	        getReqQueue().add(req);
	    }
	 
	    public void cancelPendingRequests(Object tag)
		{
	        if (mRequestQueue != null)
			{
	            mRequestQueue.cancelAll(tag);
	        }
	    }
}
