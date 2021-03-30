package com.example.adapterdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapterdemo.adapter.SongAdapter;
import com.example.adapterdemo.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongActivity extends AppCompatActivity {
    ListView songListView;
    List<Song> songs = new ArrayList<Song>();
    SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);


        songListView = findViewById(R.id.listView);
        songAdapter = new SongAdapter(songs, this);
        songListView.setAdapter(songAdapter);

        getSong();

        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SongActivity.this,
                        ""+songs.get(position).getSinger(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getSong() {
        for (int i = 0; i <= 50; i++) {
            songs.add(
                    new Song(
                            "Lady by Preap Sovanth" + i,
                            "Meas Soksophea",
                            R.drawable.preap_sovath,
                            false
                    )
            );
        }

        songAdapter.notifyDataSetChanged();
    }


}
