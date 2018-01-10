package com.example.vv.appmanager;

import android.app.Application;
import android.content.Intent;
import android.support.v4.app.AppLaunchChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        final List<AppInfo> appInfoList = AppInfo.parseApps(this, "");
        AppAdapter appAdapter = new AppAdapter(appInfoList);
        listView.setAdapter(appAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = appInfoList.get(position).getLaunch();
                startActivity(intent);
            }
        });
    }
}
