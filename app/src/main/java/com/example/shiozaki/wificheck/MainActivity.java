package com.example.shiozaki.wificheck;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    //ConnectivityManagerの取得
    ConnectivityManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ConnectivityManagerの取得
        cm = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);

        //コンポーネントの接続
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        //network情報の取得
        //マニフェストにACCESS_NETWORK_STATEを追加
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if(networkInfo == null){
            Log.v("Connection", "No Network Connection!");
            return;
        }
        if(networkInfo.isConnected()){
            //ネットワーク接続可能
            Log.v("Connection", String.valueOf(networkInfo.getTypeName()));
        }else{
            //ネットワーク接続不可能
            Log.v("Connection", "No Network Connection!");
        }


    }
}
