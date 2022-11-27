package com.example.pizzastore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainCart extends AppCompatActivity {
    FoodItemModel data;
    ImageView pizzaImg, add, subtract;
    TextView mName, mPrice, value, totalPrize, addButton;
    int customPizzaPrice;
    //    int totalPrice;
    int count = 1;
    RadioGroup radioGroup;
    RadioButton small, medium, large;
    int amount;
    int originalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cart);

        data = getIntent().getParcelableExtra("foodData");
        customPizzaPrice = getIntent().getIntExtra("CustomPizzaPrice", 50);

        amount = Integer.parseInt(data.getPrice());
        pizzaImg = findViewById(R.id.imgPizza);
        mName = findViewById(R.id.PizzaName);
        mPrice = findViewById(R.id.PizzaPrice);
        add = findViewById(R.id.inc);
        subtract = findViewById(R.id.dec);
        value = findViewById(R.id.val);
        //totalPrize = findViewById(R.id.totalPrice);
        small = findViewById(R.id.small1);
        large = findViewById(R.id.large1);
        medium = findViewById(R.id.medium1);
        addButton = findViewById(R.id.add);
        radioGroup = findViewById(R.id.radiogrp);
        originalPrice = Integer.parseInt(data.getPrice());

        if (data.getFoodName().equalsIgnoreCase("Custom")) {
            amount = customPizzaPrice;
            mPrice.setText("Rs " + amount);
        } else {
            amount = Integer.parseInt(data.getPrice());
            mPrice.setText("" + amount);
        }
        //--------------------------------------------------------------------------------------------------
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count >= 2) {
                    String s = doCheckSelectionForSubtract(count);
                    count = count - 1;
                    value.setText(String.valueOf(count));
                    mPrice.setText(s);
                } else {
                    Toast.makeText(MainCart.this, "Select at least one item", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //--------------------------------------------------------------------------------------------------
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count + 1;
                value.setText(String.valueOf(count));
                String s = doCheckSelectionForAdd(count);
                mPrice.setText(s);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price = mPrice.getText().toString().trim();
                Toast.makeText(MainCart.this, "Ordered successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainCart.this, CartActivity.class);
                i.putExtra("foodData", data);
                i.putExtra("CustomPizzaPrice", customPizzaPrice);
                i.putExtra("price", price);

                startActivity(i);
            }
        });
        mName.setText(data.getFoodName());
        Glide.with(this).load(data.getImage()).into(pizzaImg);
//--------------------------------------------------------------------------------------------------
        small.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mPrice.setText("" + amount * count);
                }

            }
        });
        large.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    int temp = amount + 50;
                    mPrice.setText("" + temp * count);
                }
            }
        });

        medium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    int temp = amount + 30;
                    mPrice.setText("" + temp * count);
                }
            }
        });

    }

    private String doCheckSelectionForAdd(int count) {
        if (small.isChecked()) {
            return "" + (amount * count);
        } else if (medium.isChecked()) {
            return "" + ((amount + 30) * count);
        } else if (large.isChecked()) {
            return "" + ((amount + 50) * count);
        }
        return amount + "";
    }

    private String doCheckSelectionForSubtract(int count) {
        if (small.isChecked()) {
            return "" + ((amount * count) - amount);
        } else if (medium.isChecked()) {
            return "" + (((amount + 30) * count) - (amount + 30));
        } else if (large.isChecked()) {
            return "" + (((amount + 50) * count) - (amount + 50));
        }
        return amount + "";
    }

}



