package id.sch.smktelkom_mlg.privateassignment.xirpl312.upmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl312.upmovie.DetailActivity;
import id.sch.smktelkom_mlg.privateassignment.xirpl312.upmovie.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl312.upmovie.TopFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl312.upmovie.model.Results;

/**
 * Created by Agnes-PC on 14/05/2017.
 */

public class MyTop extends RecyclerView.Adapter<MyTop.MyViewHolder> {
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    ArrayList<Results> mlist;
    TopFragment topFragment;
    Context context;
    private int lastposition = -1;

    public MyTop(TopFragment topFragment, ArrayList<Results> mlist, Context context) {
        this.mlist = mlist;
        this.topFragment = topFragment;
        this.context = context;
    }

    @Override
    public MyTop.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyTop.MyViewHolder vh = new MyTop.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyTop.MyViewHolder holder, int position) {
        final Results results = mlist.get(position);
        holder.tvName.setText(results.title);
        holder.tvDesc.setText(results.overview);
        image = url + results.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("title", results.title);
                intent.putExtra("poster_path", results.poster_path);
                intent.putExtra("overview", results.overview);
                intent.putExtra("release_date", results.release_date);
                intent.putExtra("popularity", results.popularity);
                intent.putExtra("vote_count", results.vote_count);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mlist != null)
            return mlist.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(View v) {
            super(v);

            tvName = (TextView) v.findViewById(R.id.tv_text);
            tvDesc = (TextView) v.findViewById(R.id.tv_desc);
            imageView = (ImageView) v.findViewById(R.id.iv_image);
            cardView = (CardView) v.findViewById(R.id.card);
        }
    }
}
