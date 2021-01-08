package com.alizhezi.lib_common.router;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Group {

    private String groupName;

    private Map<String, Class<? extends AppCompatActivity>> activitys;

    public Group(String groupName) {
        this.groupName = groupName;
        activitys = new HashMap<>();
    }

    public void addActivity(String path, Class<? extends AppCompatActivity> clzss) {
        activitys.put(path, clzss);
    }

    public Class<? extends AppCompatActivity> getActivityClass(String path) {

        if (activitys != null && activitys.containsKey(path)) {
            return activitys.get(path);
        }
        return null;
    }
}
