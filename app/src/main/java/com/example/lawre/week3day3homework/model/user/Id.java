
package com.example.lawre.week3day3homework.model.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Id implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;
    public final static Creator<Id> CREATOR = new Creator<Id>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Id createFromParcel(Parcel in) {
            return new Id(in);
        }

        public Id[] newArray(int size) {
            return (new Id[size]);
        }

    }
    ;

    protected Id(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.value = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Id() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(value);
    }

    public int describeContents() {
        return  0;
    }

}
