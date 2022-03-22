package com.example.retrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.Model.Data;
import com.example.retrofit.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Data> dataList=new ArrayList<>();
    private Context context;
    public RecyclerAdapter(Context context,List<Data> dataList) {
        this.context=context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       Data data=dataList.get(position);
       holder.tvTitle.setText(data.getTitle());
       Picasso.get().load(data.getUrl()).into(holder.imgView);
    }

     public void setData(List<Data> dataList){
        this.dataList=dataList;
     }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
         private TextView tvTitle;
         private ImageView imgView;
       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           tvTitle=itemView.findViewById(R.id.tv_title);
           imgView=itemView.findViewById(R.id.image_view);

       }
   }

}
