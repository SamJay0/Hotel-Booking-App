package com.example.hotelbookingapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelAdapter extends ArrayAdapter<Hotel> {

    private int colorResourceID;

    public HotelAdapter(Context context, ArrayList<Hotel> hotels){
        super(context,0,hotels);
//        colorResourceID=mcolorResourceID;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View ListItemView=convertView;
        if(ListItemView == null){
            ListItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Hotel currentHotel=getItem(position);
        TextView nameOfHotel=ListItemView.findViewById(R.id.nameOfHotelTxtView);
        nameOfHotel.setText(currentHotel.getNameofHotel());
        TextView priceChargedPerNight=ListItemView.findViewById(R.id.priceTxtView);
        priceChargedPerNight.setText("Ksh "+currentHotel.getPriceChargedPerNight());

//        //set background color
//        View textContainer=ListItemView.findViewById(R.id.hotel_container);
//        int color= ContextCompat.getColor(getContext(),colorResourceID);
//        textContainer.setBackgroundColor(colorResourceID);
        return ListItemView;
    }
}
