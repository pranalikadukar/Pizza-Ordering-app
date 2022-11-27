package com.example.pizzastore.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pizzastore.CartActivity;
import com.example.pizzastore.CustomActivity;
import com.example.pizzastore.FoodItemModel;
import com.example.pizzastore.MainActivity;
import com.example.pizzastore.MainCart;
import com.example.pizzastore.R;

import java.util.ArrayList;
import java.util.Random;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodViewHolder> {

    Context mContext;
    ArrayList<FoodItemModel> foodItemList;

    public FoodItemAdapter(Context mContext, ArrayList<FoodItemModel> foodItemList) {
        this.mContext = mContext;
        this.foodItemList = foodItemList;
    }

    @NonNull
    @Override
    public FoodItemAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.food_item_list, parent, false);
        FoodViewHolder foodViewHolder = new FoodViewHolder(view);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemAdapter.FoodViewHolder holder, int position) {
        FoodItemModel data = foodItemList.get(position);
        Glide.with(mContext).load(data.getImage()).into(holder.foodImage);
//        holder.foodImage.setImageDrawable(data.getFoodImg());
        holder.foodName.setText(data.getFoodName());
        holder.price.setText(data.getPrice());
        Random r = new Random();
        holder.cardView.setCardBackgroundColor(Color.argb(255, r.nextInt(256), r.nextInt(257), r.nextInt(258)));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getFoodName().equalsIgnoreCase("Custom")) {
                    Toast.makeText(mContext, "CustomeCall=>" + data.getFoodName(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mContext, CustomActivity.class);
                    i.putExtra("foodData",data);
                    mContext.startActivity(i);
                } else {
                    Toast.makeText(mContext, data.getFoodName(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mContext, MainCart.class);
                    i.putExtra("foodData",data);
                    mContext.startActivity(i);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodName;
        TextView price;
        CardView cardView;
        TextView button;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.food_img);
            foodName = itemView.findViewById(R.id.food_name);
            price = itemView.findViewById(R.id.price);
            cardView = itemView.findViewById(R.id.main_layout);
            button = itemView.findViewById(R.id.addbutton);
        }
    }
}
