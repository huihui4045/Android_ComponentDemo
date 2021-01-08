package com.alizhezi.lib_common.router;

import android.content.Context;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class ActivityRouter {

    private static ActivityRouter mInstance = new ActivityRouter();
    private Map<String, Group> mGroupMap;

    private ActivityRouter() {
        mGroupMap = new HashMap<>();
    }

    public static ActivityRouter getInstance() {
        return mInstance;
    }

    public void registerActivity(String path, Class<? extends AppCompatActivity> clazz) {
        Group group = getGroupByPath(path);
        group.addActivity(path, clazz);

    }

    public void startActivity(Context context,String path){

    }


    private Group getGroupByPath(String path) {

        //path="/group/activity"

        Group group = null;
        String groupName = "";

        if (!TextUtils.isEmpty(path) && path.startsWith("/")) {

            String[] split = path.split("/");

            if (split != null && split.length > 0) {
                groupName = split[1];

                if (mGroupMap != null && mGroupMap.containsKey(groupName)) {
                    group = mGroupMap.get(groupName);
                }
            }
        }

        if (TextUtils.isEmpty(groupName)) {
            throw new RuntimeException("group name is not null");
        }

        if (group == null) {
            group = new Group(groupName);

        }

        return group;
    }
}
