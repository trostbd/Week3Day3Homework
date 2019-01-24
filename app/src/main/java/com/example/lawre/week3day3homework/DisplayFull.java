package com.example.lawre.week3day3homework;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayFull extends AppCompatActivity
{
    FragmentManager fm;
    FullFragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_full);
        Intent i = getIntent();
        frag = new FullFragment();
        frag.setData(i.getStringExtra("image"),i.getStringExtra("name"),i.getStringExtra("email"),i.getStringExtra("password"),
                i.getStringExtra("dob"),i.getStringExtra("phone"),i.getStringExtra("street"),
                i.getStringExtra("city"),i.getStringExtra("state"),i.getStringExtra("post"),i.getStringExtra("zone"));
        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frmFragment,frag).addToBackStack("frag").commit();
    }
}
