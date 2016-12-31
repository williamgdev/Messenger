package com.adnroid.devcuba.messengerproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adnroid.devcuba.messengerproject.R;
import com.adnroid.devcuba.messengerproject.firebase.User;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder>{
    List<User> users;
    Context context;

    public ContactsAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(users.get(position).getName());
        holder.txtPhone.setText(users.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView txtName, txtPhone;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.contact_imageView);
            txtName = (TextView) itemView.findViewById(R.id.contact_name);
            txtPhone = (TextView) itemView.findViewById(R.id.contact_phone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "The user selected is " + users.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
