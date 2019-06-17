package com.example.hotelbookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelAdapter extends ArrayAdapter<Hotel> {
    public HotelAdapter(Context context, ArrayList<Hotel> hotels){
        super(context,0,hotels);
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
        return ListItemView;
    }
}
