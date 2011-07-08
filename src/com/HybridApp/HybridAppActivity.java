package com.HybridApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.HybridApp.R;

public class HybridAppActivity extends Activity {
    /** Called when the activity is first created. */
	private WebView mWebView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //mWebView = (WebView) findViewById(R.id.webView);
		mWebView = new WebView(this);

		mWebView.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		setContentView(mWebView);
		mWebView.loadUrl("file:///android_asset/www/index.html");
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.addJavascriptInterface(new MyHybrid(), "MyHybrid");
    }
    
    class MyHybrid {
    	public String hello() {
    		return "Hello hybrid App.";
    	}
    	
    	public String setInt(int data) {
    		return "setInt:" + Integer.toString(data);
    	}
    	
    	public String setFloat(float data) {
    		return "setFloat:" + Float.toString(data);
    	}
    	
    	public String setFloat(String data) {
    		return "setFloat:" + data + "<= string";
    	}
    	
    	public String setBoolean(boolean data) {
    		return "setBoolean:" + Boolean.toString(data);
    	}
    	
    	public String setString(String data) {
    		return "setString:" + data;
    	}
    	
    	public String setObject(String obj) {
    		return "setObject:" + obj;
    	}
    	
    	public String setArray(String obj) {
    		return "setArray:" + obj;
    	}
    	
    	public String setFunction(String obj) {
    		return "setFunction:" + obj;
    	}
    	
    	public void hang(int time) {
    		try {
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	public void asyncJob(final int time) {
    		Thread thread = new Thread(new Runnable() {
    			@Override
    			public void run() {
    				try {
    					Thread.sleep(time*1000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    			}
    		});

    		thread.run();
    	}
    }
}