package com.learn.robby.moviecatalogue2.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Tv implements Parcelable {
    private int photo;
    private String title;
    private String description;
    private String fact;

    public Tv(){

    }

    protected Tv(Parcel in) {
        photo = in.readInt();
        title = in.readString();
        description = in.readString();
        fact = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(fact);
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    public static final Creator<Tv> CREATOR = new Creator<Tv>() {
        @Override
        public Tv createFromParcel(Parcel in) {
            return new Tv(in);
        }

        @Override
        public Tv[] newArray(int size) {
            return new Tv[size];
        }
    };

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
