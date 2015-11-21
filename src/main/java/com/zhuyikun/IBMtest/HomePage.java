package com.zhuyikun.IBMtest;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuyikun.IBMtest.adapter.MessageListAdapter;
import com.zhuyikun.IBMtest.base.BaseActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 项目名称：My Application
 * 类描述：
 * 创建人：zhuyikun
 * 创建时间：15/11/21 下午4:39
 * 修改人：zhuyikun
 * 修改时间：15/11/21 下午4:39
 * 修改备注：
 */
public class HomePage extends BaseActivity {
    private ListView lv_list;
    private EditText et_input;
    private Button btn_send;
    private ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    private MessageListAdapter adapter;
    private double latitude = 0;
    private double longitude = 0;
    private String longitudeString = null;
    private String latitudeString = null;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        findView();
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_send:
                getGPS();
                if (latitude == 0 && longitude == 0){
                    Toast.makeText(this, "GPS get a wrong position,please try a again", Toast.LENGTH_LONG).show();
                }else{

                    final String msgInput = et_input.getText().toString().trim();

                    AlertDialog.Builder builder=new AlertDialog.Builder(this);
                    final AlertDialog alertDialog=builder.create();
                    alertDialog.show();

                    Window window = alertDialog.getWindow();
                    window.setContentView(R.layout.dialog_yes_or_no);

                    Button btn_Accept=(Button) window.findViewById(R.id.btn_Accept);
                    Button btn_Decline=(Button) window.findViewById(R.id.btn_Decline);
                    TextView tip=(TextView) window.findViewById(R.id.tip);
                    //Formate the data
                    DecimalFormat df = new DecimalFormat(".0");
                    if (longitude>0){
                        longitudeString ="E"+df.format(longitude);
                    }else{
                        longitudeString = "W"+df.format(-longitude);
                    }

                    if (latitude>0){
                        latitudeString ="N"+df.format(latitude);
                    }else{
                        latitudeString = "S"+df.format(-latitude);
                    }

                    tip.setText(msgInput+"  FROM:"+latitudeString+","+longitudeString);
                    btn_Accept.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub
                            HashMap<String ,String > dataMap = new HashMap<String,String>();
                            dataMap.put("msgInput", msgInput);
                            dataMap.put("latitude", latitudeString);
                            dataMap.put("longitude",longitudeString);
                            data.add(dataMap);
                            adapter = new MessageListAdapter(HomePage.this,data);
                            lv_list.setAdapter(adapter);
                            et_input.setText("");
                            alertDialog.dismiss();
                        }
                    });
                    btn_Decline.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub
                            alertDialog.dismiss();
                        }
                    });

                }

                break;
            default:
                break;
        }
    }

    private void findView() {
        lv_list = (ListView) findViewById(R.id.lv_list);
        et_input = (EditText) findViewById(R.id.et_input);
        btn_send = (Button) findViewById(R.id.btn_send);
        setListener(btn_send);
    }


    public void getGPS() {
        // Create class object
        gps = new GPSTracker(HomePage.this);
        // Check if GPS enabled
        if(gps.canGetLocation()) {
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
        } else {
            gps.showSettingsAlert();
        }
    }
}
