package com.nsi.btcltv.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nsi.btcltv.MainActivity;
import com.nsi.btcltv.R;

public class CustomAdapter extends BaseAdapter
{
	String [] result;
	String [] durations;
	String [] sizes;
	String [] categories;
	String [] descs;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    
    
    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList,String[] durationList,String[] sizeList,String[] categoryList,String[] descList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result    = prgmNameList;
        durations = durationList;
        sizes     = sizeList;
        categories = categoryList;
        descs 	   = descList;
        context	   = mainActivity;
        imageId	   = prgmImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
      
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return result.length;
	}
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		 return position;
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	 public class Holder
	 {
	      TextView fileName;
	      TextView duration;
	      TextView size;
	      TextView category;
	      TextView description;
	      ImageView img;
	 }
	
	@SuppressLint({ "ViewHolder", "InflateParams" }) 
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// 	TODO Auto-generated method stub

			Holder holder=new Holder();
	        View rowView;       
	        
	        rowView = inflater.inflate(R.layout.list_row, null);
	             
	        holder.fileName = (TextView)rowView.findViewById(R.id.title);
	        holder.duration = (TextView)rowView.findViewById(R.id.artist);
	        holder.size 	= (TextView)rowView.findViewById(R.id.duration);
	        holder.category = (TextView)rowView.findViewById(R.id.category);
	        holder.description = (TextView)rowView.findViewById(R.id.description);	        

	        holder.img = (ImageView)rowView.findViewById(R.id.list_image);
	        
	        holder.fileName.setText(result[position]);
	        holder.duration.setText(durations[position]);
	        holder.size.setText(sizes[position]);
	        holder.category.setText(categories[position]);
	        holder.description.setText(descs[position]);
	        
	        holder.img.setImageResource(imageId[position]);   
	        
	       
	        return rowView;
	}
}
