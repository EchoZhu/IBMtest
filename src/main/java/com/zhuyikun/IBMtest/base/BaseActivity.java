package com.zhuyikun.IBMtest.base;

import android.app.Activity;
import android.view.View;

/**
 * 项目名称：My Application
 * 类描述：
 * 创建人：zhuyikun
 * 创建时间：15/11/20 下午4:53
 * 修改人：zhuyikun
 * 修改时间：15/11/20 下午4:53
 * 修改备注：
 */
public class BaseActivity extends Activity implements View.OnClickListener {
    public void setListener(View...views){
        for (int i = 0;i < views.length;i++){
            views[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
