package com.example.tp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/**
 * created by Fred on 13/04/2024.
 */
public class OnePieceCharacter implements Parcelable {
    private int id;
    private boolean isFavorite;
    private Map<String, String> name; //depends of settings language
    private Map<String, String>  description;  //depends of settings language
    private float value;
    private String pictureLowDefinition;
    private String pictureHighDefinition;
    public OnePieceCharacter() {
        this.isFavorite = false;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
    }
    public boolean isFavorite() {
        return isFavorite;
    }
    public String getName() {
        return name.get("english");
    }
    public void setName(Map<String, String> name) {
        this.name = name;
    }
    public String getDescription() {
        return description.get("french");
    }
    public void setDescription(Map<String, String> description) {
        this.description = description;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
    public String getPictureLowDefinition() {
        return pictureLowDefinition;
    }
    public void setPictureLowDefinition(String pictureLowDefinition) {
        this.pictureLowDefinition = "http://edu.info06.net/onepiece"
                + "/pictures_ld/"
                + pictureLowDefinition;
    }
    public String getPictureHighDefinition() {
        return pictureHighDefinition;
    }
    public void setPictureHighDefinition(String pictureHighDefinition) {
        this.pictureHighDefinition = pictureHighDefinition;
    }
    @Override
    public String toString(){
        return getName() + "(" +  getValue() +  ")";
    }
    // Parcelable

    public OnePieceCharacter(Parcel in) {
        id = in.readInt();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            this.isFavorite = in.readBoolean();
        }
        name = new HashMap<>();
        in.readMap(name, ClassLoader.getSystemClassLoader());
        description = new HashMap<>();
        in.readMap(description, ClassLoader.getSystemClassLoader());
        this.value = in.readFloat();
        this.pictureLowDefinition = in.readString();
        this.pictureHighDefinition = in.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @SuppressLint("NewApi")
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeBoolean(isFavorite);
        parcel.writeMap(name);
        parcel.writeMap(description);
        parcel.writeFloat(value);
        parcel.writeString(pictureLowDefinition);
        parcel.writeString(pictureHighDefinition);
    }
    public static final Parcelable.Creator<OnePieceCharacter> CREATOR = new Parcelable.Creator<OnePieceCharacter>() {
        @SuppressLint("NewApi")
        @Override
        public OnePieceCharacter createFromParcel(Parcel source) {
            Log.d("fred","parcel STATIC writing");
            return new OnePieceCharacter(source);
        }
        @Override
        public OnePieceCharacter[] newArray(int size)
        {
            return new OnePieceCharacter[size];
        }
    };
    public static Parcelable.Creator<OnePieceCharacter> getCreator() {
        return CREATOR;
    }
}








