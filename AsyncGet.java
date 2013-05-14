package com.example.sample_app;

import android.os.AsyncTask;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import java.lang.Exception;
import java.io.ByteArrayOutputStream;

public class AsyncGet extends AsyncTask<String, Integer, String> {
    
    private AsyncCallback _asyncCallback = null;;

    public AsyncGet(AsyncCallback asyncCallback) {
        this._asyncCallback = asyncCallback;
    }

    protected String doInBackground(String... urls) {
    	HttpClient httpClient = new DefaultHttpClient();
    	HttpGet httpGet = new HttpGet(urls[0]);
    	try {
    		HttpResponse httpResponse = httpClient.execute(httpGet);
    		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
    			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    	        httpResponse.getEntity().writeTo(outputStream);
    	        return outputStream.toString();
    		}
    	} catch (Exception e) {
    		return null;
    	}
        return null;
    }
    
    protected void onPreExecute() {
        super.onPreExecute();
        this._asyncCallback.onPreExecute();
    }

    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        this._asyncCallback.onProgressUpdate(values[0]);
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        this._asyncCallback.onPostExecute(result);
    }
    
    protected void onCancelled() {
        super.onCancelled();
        this._asyncCallback.onCancelled();
    }

}
