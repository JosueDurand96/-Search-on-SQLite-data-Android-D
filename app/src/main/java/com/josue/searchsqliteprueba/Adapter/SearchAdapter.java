package com.josue.searchsqliteprueba.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.josue.searchsqliteprueba.Model.Friend;
import com.josue.searchsqliteprueba.R;
import com.josue.searchsqliteprueba.SecondActivity;

import java.util.List;


class SearchViewHolder extends RecyclerView.ViewHolder {

    public TextView name, address, email, phone;

    public SearchViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.txtNombre);
        address = (TextView) itemView.findViewById(R.id.txtAnddress);
        email = (TextView) itemView.findViewById(R.id.txtEmail);
        phone = (TextView) itemView.findViewById(R.id.txtphone);
    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> implements  View.OnClickListener{

    public Context context;
    public List<Friend> friends;
    private View.OnClickListener listener;

    public SearchAdapter(Context context, List<Friend> friends) {
        this.context = context;
        this.friends = friends;
    }

    @Override
    public SearchViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item, parent, false);


        itemView.setOnClickListener(this);

        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( SearchViewHolder holder, int position) {
        holder.name.setText(friends.get(position).getName());
        holder.address.setText(friends.get(position).getAddress());
        holder.email.setText(friends.get(position).getEmail());
        holder.phone.setText(friends.get(position).getPhone());
    }


    public  void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }
}
