package com.nsi.btcltv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;

import com.nsi.btcltv.MainActivity;
import com.nsi.btcltv.MyApplication;
import com.nsi.btcltv.R;
import com.nsi.btcltv.adapter.GridViewCustomAdapter;
import com.nsi.btcltv.helper.Item;
import com.nsi.btcltv.helper.TvHelper;


public class FragmentContentV2 extends Fragment
{

    View rootView;

    GridView grid;
    private List<Item> contentList = new ArrayList<Item>();
    private GridViewCustomAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_content_v2 , container, false);

        grid = (GridView)rootView.findViewById(R.id.gridView);
        adapter = new GridViewCustomAdapter((MainActivity)getActivity(),contentList);
        grid.setAdapter(adapter);

        vod_contents_load();


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = contentList.get(position);
                switchScreen(item.getImageUrl() , item.getVdoUrl());

                Log.d("title:", item.getTitle() + " , image:" + item.getImageUrl());
            }
        });

        return rootView;
    }


    public void vod_contents_load()
    {
        JsonArrayRequest movieReq = new JsonArrayRequest(
                "http://cream-netca.com/spa/stream/three.php" ,
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
                                Item movie = new Item();
                                movie.setImageUrl(TvHelper.baseImageUrl() + obj.getString("image_link"));
                                movie.setTitle(obj.getString("title"));
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
