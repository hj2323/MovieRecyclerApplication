package org.techtown.movierecyclerapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;//리싸이클러뷰는 매니저가지고 만든다
    GridLayoutManager gridLayoutManager;
    MovieAdapter adapter;
    int[] imgids={
            R.drawable.mov01,R.drawable.mov02,
            R.drawable.mov03,R.drawable.mov04,
            R.drawable.mov05,R.drawable.mov06,
            R.drawable.mov07,R.drawable.mov08,
            R.drawable.mov09,R.drawable.mov10
    };
    String[] title={
            "써니", "완득이", "괴물", "라디오스타", "비열한 거리",
            "왕의 남자", "아일랜드", "웰컴투 동막골", "헬보이", "백투더퓨쳐"
    };
    double[] points={3.5, 3.2, 4.5,5,3.5,4.0,3.5,3.2,4.5,5,3.5,4.0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleView1);
        gridLayoutManager=new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new MovieAdapter();
        for(int i=0;i<imgids.length;i++){
            adapter.addItem(new Movie(imgids[i], title[i], points[i]));
        }
        adapter.setItem(1, new Movie(imgids[9], title[9],points[9]));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnMovieItemClickListener(){

            @Override
            public void onItemClick(MovieAdapter.ViewHolder holder, View view, int position) {
                Movie movie=adapter.getItem(position);

                View dialogView=(View)View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                ImageView iv=dialogView.findViewById(R.id.imageView);
                TextView tvDlgTitle=dialogView.findViewById(R.id.tvDlgTitle);
                TextView tvDlgPoint=dialogView.findViewById(R.id.tvDlgPoint);
                tvDlgPoint.setText(movie.getPoint()+"점");
                tvDlgPoint.setText(movie.getTitle());
                iv.setImageResource(movie.getImgId());
                dlg.setTitle(movie.getTitle());
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
    }
}