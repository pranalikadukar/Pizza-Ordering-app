package com.example.pizzastore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomActivity<totalAmount> extends AppCompatActivity {

    FoodItemModel data;
    CheckBox redhilly, periperi, capsicum, onion, paneer, mushroom;
    CircleImageView redsauce, periperi1, onion1, paneer1, mushroom1, capsium1;
     TextView addtocart;
    int totalAmount = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_custom);
        // text1 = findViewById(R.id.custom);
        redhilly = findViewById(R.id.chkboxRedchilly);
        periperi = findViewById(R.id.chkboxperiperi);
        capsicum = findViewById(R.id.capsicum1);
        onion = findViewById(R.id.onion1);
        paneer = findViewById(R.id.paneer1);
        mushroom = findViewById(R.id.mushroom1);
        addtocart = findViewById(R.id.addtocart);

        redsauce = findViewById(R.id.redsause);
        periperi1 = findViewById(R.id.periperi);
        onion1 = findViewById(R.id.onion);
        paneer1 = findViewById(R.id.paneer);
        mushroom1 = findViewById(R.id.mushroom);
        capsium1 = findViewById(R.id.capsicum);

        data = getIntent().getParcelableExtra("foodData");

        doSetPrice(50);

        redhilly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (redhilly.isChecked()) {
                    redsauce.setVisibility(View.VISIBLE);
                    doSetPrice(20);
                } else {
                    redsauce.setVisibility(View.GONE);
                    doSetPrice(-20);
                }
            }
        });
        periperi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (periperi.isChecked()) {
                    periperi1.setVisibility(View.VISIBLE);
                    doSetPrice(20);
                } else {
                    periperi1.setVisibility(View.GONE);
                    doSetPrice(-20);
                }
            }
        });
        capsicum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (capsicum.isChecked()) {
                    capsium1.setVisibility(View.VISIBLE);
                    doSetPrice(30);
                } else {
                    capsium1.setVisibility(View.GONE);
                    doSetPrice(-30);
                }
            }
        });
        onion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onion.isChecked()) {
                    onion1.setVisibility(View.VISIBLE);
                    doSetPrice(40);
                } else {
                    onion1.setVisibility(View.GONE);
                    doSetPrice(-40);
                }
            }
        });
        mushroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mushroom.isChecked()) {
                    mushroom1.setVisibility(View.VISIBLE);
                    doSetPrice(60);
                } else {
                    mushroom1.setVisibility(View.GONE);
                    doSetPrice(-60);
                }
            }
        });
        paneer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (paneer.isChecked()) {
                    paneer1.setVisibility(View.VISIBLE);
                    doSetPrice(70);
                } else {
                    paneer1.setVisibility(View.GONE);
                    doSetPrice(-70);
                }
            }
        });

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CustomActivity.this, MainCart.class);
                i.putExtra("foodData", data);
                i.putExtra("CustomPizzaPrice", totalAmount);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public void doSetPrice(int price) {
        totalAmount = totalAmount + price;
        addtocart.setText("Add Rs " + totalAmount);
    }
}