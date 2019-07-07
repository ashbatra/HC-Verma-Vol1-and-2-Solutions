package com.knowledgeisgyaan.hcvermavol1and2solutions.Models;

import android.app.Activity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebviewClient extends WebViewClient {

    Activity activity;

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }

    public MyWebviewClient(Activity activity) {
        this.activity = activity;
    }
}
