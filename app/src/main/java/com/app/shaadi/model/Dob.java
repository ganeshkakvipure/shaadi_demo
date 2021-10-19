
package com.app.shaadi.model;

import androidx.room.ColumnInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dob {

    @SerializedName("date")
    @Expose
    @ColumnInfo(name = "dob_date")
    private String date;
    @SerializedName("age")
    @Expose
    @ColumnInfo(name ="dob_age")
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
        return "Dob{" + "date='" + date + '\'' + ", age=" + age + '}';
    }
}
