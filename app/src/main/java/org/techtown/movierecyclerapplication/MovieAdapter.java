package org.techtown.movierecyclerapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> implements OnMovieItemClickListener{
    ArrayList<Movie> movies=new ArrayList<Movie>();
    OnMovieItemClickListener listener;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(itemView, this);//view를 홀더 형태로 리턴하고
    }

    //만들어진 홀더에 아이템을 리턴
    //movie객체에 데이터가 모니터에 뿌려지게 연결시켜주는 기능
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.setItem(movie);
    }

    //현재 아이템이 몇개인가, 아이템 갯수만큼 뿌려 줄 것
    @Override
    public int getItemCount() {
        return movies.size();
    }

    //현재 없거나 추가해야되는 아이템을 위해 메소드를 넣어 준다.
    public void addItem(Movie movie){
        movies.add(movie);
    }
    public Movie getItem(int position){
        return movies.get(position);
    }
    public void setItems(ArrayList<Movie> movies){
        this.movies=movies;
    }
    public void setItem(int position, Movie movie){
        movies.set(position, movie);
    }



    //이벤트 붙이기
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener!=null){
            listener.onItemClick(holder, view, position);
        }
    }

    public void setOnItemClickListener(OnMovieItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tvTitle, tvPoint;
        public ViewHolder(@NonNull View itemView, final OnMovieItemClickListener listener) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvPoint=itemView.findViewById(R.id.tvPoint);

            //인터페이스에서 받아온 이벤트를 받아오기 전에 먼저 선언
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(listener !=null){
                        listener.onItemClick(ViewHolder.this, v, position);
                    }
                }
            });
        }

        public void setItem(Movie item) {
            iv.setImageResource(item.getImgId());
            tvTitle.setText(item.getTitle());
            tvPoint.setText(item.getPoint()+"점");
        }
    }
}
