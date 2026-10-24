package com.ethiolegacy.app;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.GeolocationPermissions;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends Activity {
    // IMPORTANT: Replace this with the exact HTTPS URL of your deployed Netlify website.
    private static final String WEBSITE_URL = "https://YOUR-ETHIOLEGACY-SITE.netlify.app/";
    private WebView webView;
    private ValueCallback<Uri[]> uploadCallback;
    private static final int FILE_CHOOSER_REQUEST = 1001;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccess(false);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);
        webView.setWebViewClient(new WebViewClient() {
            @Override public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri uri = request.getUrl();
                if ("https".equalsIgnoreCase(uri.getScheme()) || "http".equalsIgnoreCase(uri.getScheme())) {
                    view.loadUrl(uri.toString()); return true;
                }
                return false;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override public void onPermissionRequest(PermissionRequest request) {
                runOnUiThread(() -> {
                    if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, 2001);
                        Toast.makeText(MainActivity.this, "Allow camera/microphone, then retry the call.", Toast.LENGTH_LONG).show();
                    } else request.grant(request.getResources());
                });
            }
            @Override public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                if (uploadCallback != null) uploadCallback.onReceiveValue(null);
                uploadCallback = filePathCallback;
                Intent intent = fileChooserParams.createIntent();
                try { startActivityForResult(intent, FILE_CHOOSER_REQUEST); return true; }
                catch (Exception e) { uploadCallback = null; Toast.makeText(MainActivity.this, "Could not open file picker.", Toast.LENGTH_SHORT).show(); return false; }
            }
        });
        webView.loadUrl(WEBSITE_URL);
    }
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_CHOOSER_REQUEST && uploadCallback != null) {
            Uri[] results = WebChromeClient.FileChooserParams.parseResult(resultCode, data);
            uploadCallback.onReceiveValue(results); uploadCallback = null;
        }
    }
    @Override public void onBackPressed() { if (webView != null && webView.canGoBack()) webView.goBack(); else super.onBackPressed(); }
}
