package com.example.shwetatripathi.recyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shwetatripathi.recyclerview.GalActivity;
import com.example.shwetatripathi.recyclerview.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    public static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> txtTitle = new ArrayList<>();
    private ArrayList<String> imgIcon = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<String> txtTitle, ArrayList<String> imgIcon) {
        this.txtTitle = txtTitle;
        this.imgIcon = imgIcon;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(context)
                .asBitmap()
                .load(imgIcon.get(position))
                .into(holder.imgIcon);

       // holder.imgIcon.setImageDrawable(Drawable.createFromPath(imgIcon.get(position)));

        holder.txtTitle.setText(txtTitle.get(position));

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, txtTitle.get(position) +" Clicked", Toast.LENGTH_SHORT).show();

                Intent i=new Intent(context, GalActivity.class);
                i.putExtra("image_url",imgIcon.get(position) );
                i.putExtra("image_name",txtTitle.get(position) );
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return txtTitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgIcon;
        TextView txtTitle;
        RelativeLayout parent_layout;

        public ViewHolder(View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
