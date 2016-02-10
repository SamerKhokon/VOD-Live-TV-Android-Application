package com.nsi.btcltv;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.content.res.Configuration;
import android.os.Build;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.ListView;

import com.nsi.btcltv.adapter.DrawerItemCustomAdapter;

import com.nsi.btcltv.fragment.FragmentContentV2;
import com.nsi.btcltv.fragment.FragmentGrid;
import com.nsi.btcltv.helper.ObjectDrawerItem;

import com.nsi.btcltv.fragment.FragmentOne;
import com.nsi.btcltv.fragment.FragmentTwo;
import com.nsi.btcltv.fragment.FragmentThree;
import com.nsi.btcltv.fragment.FragmentFour;
import com.nsi.btcltv.fragment.FragmentFive;
import com.nsi.btcltv.fragment.FragmentSix;
import com.nsi.btcltv.fragment.FragmentSample;
import com.nsi.btcltv.fragment.FragmentTab;
import com.nsi.btcltv.fragment.FragmentTabContents;
import com.nsi.btcltv.fragment.FragmentTabTv;
import com.nsi.btcltv.fragment.FragmentTabVod;






public class MainActivity extends ActionBarActivity {

    private String[] mOptionMenu;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout mDrawerRelativeLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mTitleSection;
    private CharSequence mTitleApp ;
    private Fragment mFragment = null;

    FragmentTabHost mTabHost;

    Build bl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#010101")));
        //getSupportActionBar().setCustomView(R.layout.custom_header);
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        mOptionMenu = new String[] { getString(R.string.first_fragment),
                getString(R.string.second_fragment),
                getString(R.string.third_fragment),
                getString(R.string.fourth_fragment),
                getString(R.string.fifth_fragment)
               //getString(R.string.sample_fragment)
                };

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerRelativeLayout = (RelativeLayout) findViewById(R.id.left_drawer);

        mDrawerList = (ListView) findViewById(R.id.list_view_drawer);

        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[5];
        drawerItem[0] = new ObjectDrawerItem(R.drawable.tv, getString(R.string.first_fragment));
        drawerItem[1] = new ObjectDrawerItem(R.drawable.tv, getString(R.string.second_fragment));
        drawerItem[2] = new ObjectDrawerItem(R.drawable.tv, getString(R.string.third_fragment));
        drawerItem[3] = new ObjectDrawerItem(R.drawable.tv, getString(R.string.fourth_fragment));
        drawerItem[4] = new ObjectDrawerItem(R.drawable.tv, getString(R.string.fifth_fragment));
       // drawerItem[5] = new ObjectDrawerItem(R.drawable.btcltvlogo, getString(R.string.sample_fragment));

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this , R.layout.drawer_list_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        initContentWithFirstFragment();

        mDrawerList.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    //home
                    case 0:
                        mFragment = new FragmentSample();
                        break;

                    //contents
                    case 1:
                        mFragment = new FragmentOne();
                        break;

                    //vod
                    case 2:
                        mFragment = new FragmentContentV2();
                        break;
                    //tv
                    case 3:
                        mFragment = new FragmentFour();
                        break;

                    //epg
                    case 4:
                        mFragment = new FragmentFive();
                        break;



                    default:
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, mFragment).commit();

                mDrawerList.setItemChecked(position, true);
                mTitleSection = mOptionMenu[position];

                getSupportActionBar().setTitle(mTitleSection);
                mDrawerLayout.closeDrawer(mDrawerRelativeLayout);
            }
        });


        mDrawerList.setItemChecked(0, true);
        mTitleSection = getString(R.string.first_fragment);



        mTitleApp = getTitle();

        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            public void onDrawerClosed(View view)
            {
                getSupportActionBar().setTitle(mTitleSection);
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
            }

            public void onDrawerOpened(View drawerView)
            {
                getSupportActionBar().setTitle(R.string.app_name);
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setCustomView(R.layout.custom_header);

    }

    public void initContentWithFirstFragment()
    {
        mTitleSection = getString(R.string.first_fragment);
        getSupportActionBar().setTitle( mTitleSection);

        mFragment = new FragmentSample();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, mFragment).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

  			/*switch (item.getItemId())
  			{
  				case R.id.action_settings:
  					Toast.makeText(this, R.string.action_settings, Toast.LENGTH_SHORT).show();
  					break;
  				default:
  					return super.onOptionsItemSelected(item);
  			}*/
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}
