package ovh.benjah.newsreader;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private List<FakeNews> articles;
    private HomeActivity homeActivity;

    public ArticleAdapter(HomeActivity currentHomeActivity, List<FakeNews> list) {
        articles = list;
        homeActivity = currentHomeActivity;
    }

    @Override
    public ArticleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.MyViewHolder holder, int position) {
        FakeNews fakeNews = articles.get(position);
        holder.display(fakeNews);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleView;

        private FakeNews currentNews;

        public MyViewHolder(final View itemView) {
            super(itemView);

            titleView = ((TextView) itemView.findViewById(R.id.name));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    homeActivity.startArticleActivity(currentNews);
                }
            });
        }

        public void display(FakeNews fakeNews) {
            currentNews = fakeNews;
            titleView.setText(fakeNews.title);
        }
    }
}
