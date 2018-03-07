package ovh.benjah.newsreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("LeGorafi - Liste des articles");

        final RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ArticleAdapter adapter = new ArticleAdapter(this, FakeNewsList.all);
        rv.setAdapter(adapter);
    }

    public void startArticleActivity(FakeNews fakeNews) {
        Intent intent = new Intent(HomeActivity.this, ArticleActivity.class);
        intent.putExtra("html_article", fakeNews.htmlContent);
        startActivity(intent);
    }
}
