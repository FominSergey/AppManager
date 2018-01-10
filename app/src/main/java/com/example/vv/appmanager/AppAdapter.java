package com.example.vv.appmanager;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppAdapter extends BaseAdapter {

    private List<AppInfo> appInfoList;

    AppAdapter(List<AppInfo> appInfoList) {
        this.appInfoList = appInfoList;
    }

    @Override
    public int getCount() {
        return appInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return appInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.myitem, parent, false);
        ImageView pic = convertView.findViewById(R.id.itemImage);
        TextView text = convertView.findViewById(R.id.itemText);
        TextView path = convertView.findViewById(R.id.itemPath);
        text.setText(appInfoList.get(position).getName() + "");
        path.setText(appInfoList.get(position).getInstallAt() + "");
        pic.setImageDrawable(appInfoList.get(position).getIcon());
        return convertView;
    }

}
