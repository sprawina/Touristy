package com.example.sr20022286.touristy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TouristAdapter extends RecyclerView.Adapter<TouristAdapter.t_placesViewHolder> {

    private static final String TAG = "TouristAdapter";


    private ArrayList<Tourist> frm_list ;
    private Context mContext;

    public TouristAdapter(Context context, ArrayList<Tourist> fList){

        frm_list = fList;
        mContext = context;
    }

    public class t_placesViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView txt;
        RelativeLayout ListLayout;

        public t_placesViewHolder(View v){
            super(v);
            img = v.findViewById(R.id.image_id);
            txt = v.findViewById(R.id.text_id);
            ListLayout = v.findViewById(R.id.list_layout);
        }
    }

    public int getItemCount(){
        return frm_list.size();
    }

    public t_placesViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.t_places,parent,false);
        return new t_placesViewHolder(itemView);
    }

    public void onBindViewHolder(final t_placesViewHolder holder, final int pos){

        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext).asBitmap().load(frm_list.get(pos).getImg()).into(holder.img);

        holder.txt.setText(frm_list.get(pos).getTitle());

        holder.ListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + frm_list.get(pos));

                //Toast.makeText(mContext, frm_list.get(pos), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext,GalleryActivity.class);
                intent.putExtra("imageUrl",frm_list.get(pos).getImg());
                intent.putExtra("imageName", frm_list.get(pos).getTitle());

                //shared element transition

                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                        .makeSceneTransitionAnimation((Activity)mContext,(ImageView)v.findViewById(R.id.image_id) ,"myImage");

                mContext.startActivity(intent,optionsCompat.toBundle());
            }
        });

    }

}


