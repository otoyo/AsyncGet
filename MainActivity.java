package com.example.sample_app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.util.Log;

public class MainActivity extends Activity {
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AsyncGet asyncGet = new AsyncGet(new AsyncCallback() {
            public void onPreExecute() {
                // do something
            }
            public void onProgressUpdate(int progress) {
            	// do something
            }
            public void onPostExecute(String result) {
            	// do something
            	Log.d("onPostExecute", result);
            }
            public void onCancelled() {
            	// do something
            }
        });
        asyncGet.execute("http://alpacat.com/");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
