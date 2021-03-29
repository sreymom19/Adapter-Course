package com.example.adapterdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapterdemo.R;
import com.example.adapterdemo.model.Song;

import java.util.List;

public class SongAdapter extends BaseAdapter {

    //Array object
    private List <Song> songs;
    private Context context;

    //constructor one to catch object song and context when we call to use it.
    //
    public SongAdapter(List<Song> songs, Context context) {
        this.songs = songs;
        this.context = context;
    }

    // need to Override 4 method

    // get adapter know quantity of item
    @Override
    public int getCount() {

        return this.songs.size();
    }


    // get item each one.
    @Override
    public Object getItem(int position) {
        return this.songs.get(position);
    }


    // get item id of position.
    @Override
    public long getItemId(int position) {

        return position;
    }


    // Object view of item.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //convert xml to java and study condition
        View view=null;
        if(convertView==null){
            //covert xml file to java
            view = LayoutInflater.from(context)
                    .inflate(R.layout.song_item_layout,parent,false);
        }else {
            view=convertView;
        }

        //bind data or set data in layout.
        ImageView thumb = view.findViewById(R.id.thumb);
        TextView title = view.findViewById(R.id.tvTittle);
        TextView singer = view.findViewById(R.id.tvSinger);
        ImageView btnPlay = view.findViewById(R.id.btnPlay);
            //create viarable song
        Song song = songs.get(position);
        thumb.setImageResource(song.getThumbnail());
        title.setText(song.getTitle());
        singer.setText(song.getSinger());
        btnPlay.setOnClickListener(v->{
            Toast.makeText(context, "Playing", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
