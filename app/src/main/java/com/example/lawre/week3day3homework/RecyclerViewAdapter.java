package com.example.lawre.week3day3homework;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lawre.week3day3homework.model.user.Result;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    ArrayList<Result> userList;
    FragmentManager fm;

    public RecyclerViewAdapter(ArrayList<Result> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position)
    {
        Result newUser = userList.get(position);
        if(newUser != null)
        {
            String name = newUser.getName().getFullName();
            String image = newUser.getPicture().getThumbnail();
            viewHolder.setItemUserResponse(newUser);
            viewHolder.tvName.setText(name);
            Glide.with(viewHolder.myImage.getContext()).load(image).into(viewHolder.myImage);
        }
    }

    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView myImage;
        TextView tvName;
        Result itemUser;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.imgThumbnail);
            tvName = itemView.findViewById(R.id.tvName);
        }

        public Result getItemUserResponse() {
            return itemUser;
        }

        public void setItemUserResponse(Result itemUserResponse) {
            this.itemUser = itemUserResponse;
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(v.getContext(),DisplayFull.class);
            for(int i = 0; i< userList.size();i++)
            {
                String fullName = userList.get(i).getName().getFullName();
                if(tvName.equals(fullName))
                {

                }
            }
        }
    }

    public void addSUserResponse(Result mu)
    {
        userList.add(mu);
        notifyDataSetChanged();;
    }

    public void addUserResponsees(List<Result> useres)
    {
        Log.d("RVA_", "addUserResponsees: " + useres.size());
        if(useres == null)
            return;
        for(int i=0;i<useres.size();i++)
        {
            addSUserResponse(useres.get(i));
        }
    }

    public void setFragManager(FragmentManager fragmentManager)
    {
        fm = fragmentManager;
    }
}
