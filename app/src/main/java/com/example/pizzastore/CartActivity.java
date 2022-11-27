package com.example.pizzastore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import com.example.pizzastore.CustomActivity;

public class CartActivity extends AppCompatActivity {
    FoodItemModel data;
  TextView name,amount;
  int customPizzaPrice;
  String price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_cart);
       name= findViewById(R.id.itemName);
       amount=findViewById(R.id.itemPrice);
        data = getIntent().getParcelableExtra("foodData");
        customPizzaPrice=getIntent().getIntExtra("CustomPizzaPrice",50);
        price = getIntent().getStringExtra("price");
        if(data.getFoodName().equalsIgnoreCase("Custom"))
        {
            name.setText(data.getFoodName());
            amount.setText(""+price);
        }else {
            name.setText(data.getFoodName());
            amount.setText(""+price);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
