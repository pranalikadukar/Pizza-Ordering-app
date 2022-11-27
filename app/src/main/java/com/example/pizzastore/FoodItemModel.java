package com.example.pizzastore;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class FoodItemModel implements Parcelable {
    String image;
    String foodName;
    String price;
//    Drawable foodbgcolor;

    public FoodItemModel(String image, String foodName,String price) {
        this.image = image;
        this.foodName = foodName;
        this.price= price;
//        this.foodImg = foodImg;
    }

    protected FoodItemModel(Parcel in) {
        image = in.readString();
        foodName = in.readString();
        price = in.readString();
    }

    public static final Creator<FoodItemModel> CREATOR = new Creator<FoodItemModel>() {
        @Override
        public FoodItemModel createFromParcel(Parcel in) {
            return new FoodItemModel(in);
        }

        @Override
        public FoodItemModel[] newArray(int size) {
            return new FoodItemModel[size];
        }
    };

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() { return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(image);
        parcel.writeString(foodName);
        parcel.writeString(price);
    }

//    public Drawable getFoodImg() {
//        return foodImg;
//    }
//
//    public void setFoodImg(Drawable foodImg) {
//        this.foodImg = foodImg;
//    }
}
