package com.gogreen.gogreen.Controllers.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.gogreen.gogreen.R;

import java.util.List;
import java.util.Map;

public class NavigationDrawerListExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<String> mExpandableListTitle;
    private Map<String, List<String>> mExpandableListDetail;
    private LayoutInflater mLayoutInflater;

    public NavigationDrawerListExpandableListAdapter(Context context, List<String> expandableListTitle,
                                                     Map<String, List<String>> expandableListDetail) {
        mContext = context;
        mExpandableListTitle = expandableListTitle;
        mExpandableListDetail = expandableListDetail;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return mExpandableListDetail.get(mExpandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {


        if (mExpandableListDetail.get(mExpandableListTitle.get(listPosition)) != null) {
            return mExpandableListDetail.get(mExpandableListTitle.get(listPosition))
                    .size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int listPosition) {
        return mExpandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return mExpandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(final int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);

        //   listTitleTextView.setCompoundDrawables(mContext.getResources().getDrawable(  R.drawable.home),null,null,null);
        //listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
/*
        ImageView menuImage = (ImageView) convertView
                .findViewById(R.id.menuImage);
        ArrayList<Integer> drawables=new ArrayList<>();
        drawables.add(R.drawable.home);
        drawables.add(R.drawable.archieve_gray);
        drawables.add(R.drawable.notification);
        drawables.add(R.drawable.notification);
        drawables.add(R.drawable.name);
        drawables.add(R.drawable.info);
        drawables.add(R.drawable.logout);
        Picasso.with(convertView.getContext()).load(drawables.get(listPosition)).resize(65,65).into(menuImage);
*/

        //menuImage.setImageDrawable(mContext.getResources().getDrawable(drawables.get(listPosition)));

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
