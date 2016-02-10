package com.nsi.btcltv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.nsi.btcltv.MainActivity;
import com.nsi.btcltv.MyApplication;
import com.nsi.btcltv.R;
import com.nsi.btcltv.helper.Item;

import java.util.ArrayList;
import java.util.List;

public class GridViewCustomAdapter extends BaseAdapter
{
    Context context;
    private static LayoutInflater inflater = null;
    private List<Item> contentList = new ArrayList<Item>();

    ImageLoader imageLoader = MyApplication.getInstance().getImageLoader();



    public GridViewCustomAdapter(MainActivity mainActivity, List<Item> contentList)
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
        rootView = inflater.inflate(R.layout.grid_row, null);

        Item movie = contentList.get(position);

        if(imageLoader == null)
            imageLoader = MyApplication.getInstance().getImageLoader();

        NetworkImageView thumbImage = (NetworkImageView)rootView.findViewById(R.id.imageView1);
        thumbImage.setImageUrl(movie.getImageUrl() , imageLoader);

        TextView title        = (TextView)rootView.findViewById(R.id.text1);
        title.setText(movie.getTitle());


        return rootView;
    }
}
