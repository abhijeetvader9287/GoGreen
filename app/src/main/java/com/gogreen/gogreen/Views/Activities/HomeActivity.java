package com.gogreen.gogreen.Views.Activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.gogreen.gogreen.Controllers.Adapters.NavigationDrawerListExpandableListAdapter;
import com.gogreen.gogreen.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity
 {
    ExpandableListView mExpandableListView;
    View listHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mExpandableListView = (ExpandableListView) findViewById(R.id.navList);
        LayoutInflater inflater = getLayoutInflater();
        listHeaderView = inflater.inflate(R.layout.nav_header_home, null, false);
        mExpandableListView.addHeaderView(listHeaderView);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        ArrayList<String> mExpandableListTitle = new ArrayList();
        mExpandableListTitle.add(getString(R.string.serivce_request));
        mExpandableListTitle.add(getString(R.string.notification));
        mExpandableListTitle.add(getString(R.string.settings));
        mExpandableListTitle.add(getString(R.string.about));
        mExpandableListTitle.add(getString(R.string.feedback));
        mExpandableListTitle.add(getString(R.string.faq_s));

        Map<String, List<String>> mExpandableListData = new HashMap<>();
        List<String> infoMenu = new ArrayList<>();

        infoMenu.add(getString(R.string.newservicerequest));
        infoMenu.add(getString(R.string.pending));
        infoMenu.add(getString(R.string.rejected));
        infoMenu.add(getString(R.string.resolved));

        mExpandableListData.put(getString(R.string.serivce_request), infoMenu);

        NavigationDrawerListExpandableListAdapter mExpandableListAdapter = new NavigationDrawerListExpandableListAdapter(this, mExpandableListTitle, mExpandableListData);
        mExpandableListView.setAdapter(mExpandableListAdapter);

        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {


            }
        });
        mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {


            }
        });
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {


                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
