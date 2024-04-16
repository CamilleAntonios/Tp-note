package com.example.tp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Map;

public class OnePieceCharacter implements Parcelable {
    private int id;
    private boolean isFavorite;
    private Map<String, String> name; //depends of settings language
    private Map<String, String>  description;  //depends of settings language
    private float value;
    private String pictureLowDefinition;
    private String pictureHighDefinition;

    public OnePieceCharacter(int id, Map<String, String>name,Map<String, String>  description,float val, String low, String high ){
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = val;
        this.pictureLowDefinition = low;
        this.pictureHighDefinition = high;
    }

    protected OnePieceCharacter(Parcel in) {
        id = in.readInt();
        isFavorite = in.readByte() != 0;
        value = in.readFloat();
        pictureLowDefinition = in.readString();
        pictureHighDefinition = in.readString();
    }

    public static final Creator<OnePieceCharacter> CREATOR = new Creator<OnePieceCharacter>() {
        @Override
        public OnePieceCharacter createFromParcel(Parcel in) {
            return new OnePieceCharacter(in);
        }

        @Override
        public OnePieceCharacter[] newArray(int size) {
            return new OnePieceCharacter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
        dest.writeFloat(value);
        dest.writeString(pictureLowDefinition);
        dest.writeString(pictureHighDefinition);
    }

    public float getValue() {
        return value;
    }

    public void setName(Map<String, String> map){
        name = map;
        pictureLowDefinition = "http://edu.info06.net/onepiece/pictures_ld/"+name.get("english")+".png";
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.get("english");
    }
}
