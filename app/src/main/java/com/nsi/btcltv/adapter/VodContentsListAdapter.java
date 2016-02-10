package com.nsi.btcltv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;


import com.nsi.btcltv.MainActivity;
import com.nsi.btcltv.MyApplication;
import com.nsi.btcltv.R;
import com.nsi.btcltv.helper.Video;


public class VodContentsListAdapter  extends BaseAdapter
{
    Context context;
    private static LayoutInflater inflater = null;
    private List<Video> contentList = new ArrayList<Video>();
    ImageLoader imageLoader = MyApplication.getInstance().getImageLoader();

    public VodContentsListAdapter(MainActivity mainActivity, List<Video> contentList)
    {
        this.context = mainActivity;
        this.contentList = contentList;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return contentList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return contentList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View rootView;
        rootView = inflater.inflate(R.layout.new_list_row_vod_contents, null);

        Video movie = contentList.get(position);

        if(imageLoader == null)
            imageLoader = MyApplication.getInstance().getImageLoader();

        NetworkImageView thumbImage = (NetworkImageView)rootView.findViewById(R.id.vod_list_image);

        TextView title        = (TextView)rootView.findViewById(R.id.vod_titleVideo);
        TextView timeDuration = (TextView)rootView.findViewById(R.id.vod_timeDuration);
        TextView category     = (TextView)rootView.findViewById(R.id.vod_categoryVideo);
        TextView size         = (TextView)rootView.findViewById(R.id.vod_durationSize);
        TextView desc         = (TextView)rootView.findViewById(R.id.vod_description);
        ImageView arrowImage  = (ImageView)rootView.findViewById(R.id.vod_arrowImage);

        thumbImage.setImageUrl(movie.getImageUrl() , imageLoader);

        title.setText(movie.getTitle());
        timeDuration.setText(movie.getDuration());
        category.setText(movie.getCategory());
        size.setText(movie.getSize());
        desc.setText(movie.getDescription());
        arrowImage.setImageResource(R.drawable.ic_arrow);

        return rootView;
    }
}
