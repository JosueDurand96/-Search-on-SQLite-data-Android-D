package com.josue.searchsqliteprueba.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.josue.searchsqliteprueba.Model.Friend;
import com.josue.searchsqliteprueba.R;

import java.util.List;


class SearchViewHolder extends RecyclerView.ViewHolder {

    public TextView name,address,email,phone;
    public SearchViewHolder(View itemView){
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.txtNombre);
        address = (TextView)itemView.findViewById(R.id.txtAnddress);
        email = (TextView)itemView.findViewById(R.id.txtEmail);
        phone = (TextView)itemView.findViewById(R.id.txtphone);
    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    public Context context;
    public List<Friend> friends;

    public SearchAdapter(Context context,List<Friend> friends){
        this.context = context;
        this.friends = friends;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item,parent,false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.name.setText(friends.get(position).getName());
        holder.address.setText(friends.get(position).getAddress());
        holder.email.setText(friends.get(position).getEmail());
        holder.phone.setText(friends.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }
}
