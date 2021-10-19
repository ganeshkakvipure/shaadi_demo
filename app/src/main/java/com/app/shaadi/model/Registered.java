
package com.app.shaadi.model;

import androidx.room.ColumnInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Registered {

    @SerializedName("date")
    @Expose
    @ColumnInfo(name ="reg_date")
    private String date;
    @SerializedName("age")
    @Expose
    @ColumnInfo(name ="reg_age")
    private int age;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Registered{" + "date='" + date + '\'' + ", age=" + age + '}';
    }
}
