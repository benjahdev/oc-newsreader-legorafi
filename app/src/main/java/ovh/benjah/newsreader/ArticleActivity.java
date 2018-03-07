package ovh.benjah.newsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        setTitle("LeGorafi");

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadData(getIntent().getStringExtra("html_article"), "text/html", "UTF-8");
    }
}
