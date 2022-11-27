package com.example.pizzastore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.example.pizzastore.adapters.FoodItemAdapter;

import java.util.ArrayList;
import java.util.Random;

public class welcomeActivity extends AppCompatActivity {
    private RecyclerView foodRecycler;
    private ArrayList<FoodItemModel> list;
    private FoodItemAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        foodRecycler = findViewById(R.id.food_recycler);

        list = new ArrayList<>();
        list.add(new FoodItemModel("https://w7.pngwing.com/pngs/375/121/png-transparent-pizza-with-tomatos-new-york-style-pizza-italian-cuisine-take-out-pizza-margherita-pizza-food-recipe-pizza-logo-thumbnail.png", "Veggies","500"));
        list.add(new FoodItemModel("https://w7.pngwing.com/pngs/21/55/png-transparent-pepperoni-pizza-margarita-pizza-margherita-italian-cuisine-tomato-pizza-food-cheese-recipe-thumbnail.png", "" + "Pepproni","600"));
        list.add(new FoodItemModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRB5lu3IqWITUglXN25iILQwRIifrReIaTekBEJeHzgC2MrtdNUH7s0Yiz0It4KtU1tk1E&usqp=CAU", "Farm","700"));
        list.add(new FoodItemModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiD6Fgzy88F8rX6nK-3iBnPxiz8q9XUJR8Mw&usqp=CAU", "Chesse","900"));
        list.add(new FoodItemModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1WvBJ90flwy5WmRlZMFUrBIPetq3aTp5pvQ&usqp=CAU", "Paneer","1000"));
        list.add(new FoodItemModel("https://w7.pngwing.com/pngs/526/288/png-transparent-cooked-pizza-pizza-delivery-italian-cuisine-pizza-food-image-file-formats-recipe-thumbnail.png", "Custom","50"));
        setRecyclerView();
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        foodRecycler.setLayoutManager(layoutManager);
        foodRecycler.setHasFixedSize(true);
        mAdapter = new FoodItemAdapter(this, list);
        foodRecycler.setAdapter(mAdapter);
    }

/*
     public  int getRandomColor(){
        Random r = new Random();

        return Color.argb(255,r.nextInt(256),r.nextInt(256),r.nextInt(256));
    }
*/

}