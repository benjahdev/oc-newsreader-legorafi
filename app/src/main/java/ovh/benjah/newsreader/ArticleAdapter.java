package ovh.benjah.newsreader;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private List<FakeNews> articles;

    public ArticleAdapter(List<FakeNews> list) {
        articles = list;
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

            final Context context = itemView.getContext();
            titleView = ((TextView) itemView.findViewById(R.id.name));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ArticleActivity.class);
                    intent.putExtra("html_article", currentNews.htmlContent);
                    context.startActivity(intent);
                }
            });
        }

        public void display(FakeNews fakeNews) {
            currentNews = fakeNews;
            titleView.setText(fakeNews.title);
        }
    }
}
