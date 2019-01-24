package com.example.lawre.week3day3homework;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FullFragment extends Fragment
{
    ImageView myImage;
    TextView tvName,tvEmail,tvPassword,tvDOB,tvPhone,tvStreet,tvCity,tvState,tvPostcode,tvTimezone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.user_full, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myImage = view.findViewById(R.id.imImageFull);
        tvName = view.findViewById(R.id.tvNameFull);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvPassword = view.findViewById(R.id.tvPassword);
        tvDOB = view.findViewById(R.id.tvDOB);
        tvPhone = view.findViewById(R.id.tvPhone);
        tvStreet = view.findViewById(R.id.tvStreet);
        tvCity = view.findViewById(R.id.tvCity);
        tvState = view.findViewById(R.id.tvState);
        tvPostcode = view.findViewById(R.id.tvPostcode);
        tvTimezone = view.findViewById(R.id.tvTimezone);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setText(String img, String name, String email, String password, String dob, String phone, String street, String city, String state, String post, String time)
    {
        Glide.with(myImage.getContext()).load(img).into(myImage);
        tvName.setText(name);
        tvEmail.setText(email);
        tvPassword.setText(password);
        tvDOB.setText(dob);
        tvPhone.setText(phone);
        tvStreet.setText(street);
        tvCity.setText(city);
        tvState.setText(state);
        tvPostcode.setText(post);
        tvTimezone.setText(time);
    }
}
