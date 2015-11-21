package com.zhuyikun.IBMtest.helper;

import android.app.Activity;
import android.content.Intent;

import com.zhuyikun.IBMtest.R;

/**
 * 项目名称：My Application
 * 类描述：
 * 创建人：zhuyikun
 * 创建时间：15/11/21 下午5:03
 * 修改人：zhuyikun
 * 修改时间：15/11/21 下午5:03
 * 修改备注：
 */
public class ForwardHelper {
    public static void toHomePage(Activity activity) {
        Intent in = new Intent(activity, com.zhuyikun.IBMtest.HomePage.class);
        activity.startActivity(in);
        activity.overridePendingTransition(R.anim.activity_open_in_anim,
                R.anim.activity_open_out_anim);
        activity.finish();
    }
}
