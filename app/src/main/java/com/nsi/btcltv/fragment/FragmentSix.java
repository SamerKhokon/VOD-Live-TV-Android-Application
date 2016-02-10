package com.nsi.btcltv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;

import com.nsi.btcltv.MainActivity;
import com.nsi.btcltv.MyApplication;
import com.nsi.btcltv.R;
import com.nsi.btcltv.adapter.ContentsListAdapter;
import com.nsi.btcltv.helper.Video;
import com.nsi.btcltv.helper.TvHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

public class FragmentSix extends Fragment
{
    ListView my_list;
    private List<Video> contentList = new ArrayList<Video>();
    private ContentsListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_test, container, false);

        my_list = (ListView)rootView.findViewById(R.id.listView3);
        adapter = new ContentsListAdapter((MainActivity)getActivity() , contentList);
        my_list.setAdapter(adapter);

        loadRecords();

        return rootView;
    }

    public void loadRecords()
    {
        JsonArrayRequest movieReq = new JsonArrayRequest(
                "http://cream-netca.com/spa/stream/two.php" ,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        Log.d("Length:",   response.length()+"");
                        Log.d("Response:", response.toString());

                        //Parsing json
                        for (int i = 0; i < response.length(); i++)
                        {
                            try
                            {
                                JSONObject obj = response.getJSONObject(i);

                                Video movie = new Video();
                                movie.setImageUrl(TvHelper.baseImageUrl() + obj.getString("image_link"));
                                movie.setTitle(obj.getString("title"));
                                movie.setDuration(obj.getString("duration"));
                                movie.setCategory(obj.getString("directory"));
                                movie.setSize(obj.getString("size"));
                                movie.setDescription(obj.getString("details"));

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

    public void onDestroy()
    {
        super.onDestroy();
    }
}