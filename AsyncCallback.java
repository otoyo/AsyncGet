package com.example.sample_app;

public interface AsyncCallback {
	
	void onPreExecute();
    void onPostExecute(String result);
    void onProgressUpdate(int progress);
    void onCancelled();
    
}
