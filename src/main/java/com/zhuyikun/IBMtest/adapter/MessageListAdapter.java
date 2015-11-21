package com.zhuyikun.IBMtest.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuyikun.IBMtest.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 项目名称：My Application
 * 类描述：
 * 创建人：zhuyikun
 * 创建时间：15/11/20 下午4:36
 * 修改人：zhuyikun
 * 修改时间：15/11/20 下午4:36
 * 修改备注：
 */
public class MessageListAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<HashMap<String,String>> data;
    public MessageListAdapter(Context context,ArrayList<HashMap<String,String>> data){
        this.mContext = context;
        this.data  = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder ViewHolder=null;
        if(convertView==null){
            ViewHolder=new ViewHolder();
            convertView= LinearLayout.inflate(mContext, R.layout.messagelist_item, null);
            ViewHolder.tv_content=(TextView) convertView.findViewById(R.id.tv_content);
            ViewHolder.tv_coordinates=(TextView) convertView.findViewById(R.id.tv_coordinates);
            convertView.setTag(ViewHolder);
        }else{
            ViewHolder=(ViewHolder) convertView.getTag();
        }
        String inputContent = data.get(position).get("msgInput");
        if (inputContent.equals("")){
            ViewHolder.tv_content.setText("NULL");
        }else{
            ViewHolder.tv_content.setText(inputContent);
        }

        ViewHolder.tv_coordinates.setText("FROM:"+data.get(position).get("longitude")+","+data.get(position).get("latitude"));
        return convertView;
    }
    private static class ViewHolder
    {
        TextView tv_content;
        TextView tv_coordinates;
    }
}
