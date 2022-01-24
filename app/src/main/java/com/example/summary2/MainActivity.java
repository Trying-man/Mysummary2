package com.example.summary2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button likeButton;
    TextView likeCountView;

    int likeCount = 1;
    boolean likeState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = (Button) findViewById(R.id.likeButton);
        likeCountView = (TextView) findViewById(R.id.likeCountView);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeState){
                    decrLikeCount();
                }else {
                    incrLikeCount();
                }
                likeState = ! likeState;
            }
        });

        likeCountView = (TextView) findViewById(R.id.likeCountView);

        ListView listView = (ListView) findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        listView.setAdapter(adapter);

    }

    class CommentAdapter extends BaseAdapter {

    }

    public void incrLikeCount(){
        likeCount +=1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);

    }

    public void decrLikeCount(){
        likeCount -=1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
    }

}