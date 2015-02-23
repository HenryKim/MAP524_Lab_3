package hkim142.map524lab3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by student on 2/12/15.
 */
public class ActivityWebsites extends ActionBarActivity {
    private WebView webView;
    private String[] websites;
    private String[] weburl;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);
        /*_rssFeedListView = (ListView) findViewById(R.id.rssfeed_listview);

        textview = (TextView) findViewById(R.id.loading);
        RssFeedTask rssTask = new RssFeedTask();
        rssTask.execute();
    */
        final ListView listView = (ListView) findViewById(R.id.listView1);
        websites = getResources().getStringArray(R.array.websitesName);
        weburl = getResources().getStringArray(R.array.websitesArray);
        ArrayAdapter adapter = new ArrayAdapter(ActivityWebsites.this, R.layout.activity_listview, websites);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long id) {
               webView.loadUrl(weburl[position]);
            }
            });
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new MyWebViewClient());
        listView.setClickable(false);
        listView.setLongClickable(false);
        listView.setFocusable(false);
        listView.setFocusableInTouchMode(false);

    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }
}
