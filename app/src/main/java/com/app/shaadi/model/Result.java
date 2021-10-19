package com.app.shaadi.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "result")
public class Result {

    @PrimaryKey(autoGenerate = true)
    private int userId;

    @SerializedName("cell")
    @Expose
    private String cell;
    @SerializedName("dob")
    @Expose
    @Embedded
    private Dob dob;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("id")
    @Expose
    @Embedded
    private Id id;

    @SerializedName("location")
    @Expose
    @Embedded
    private Location location;
    @SerializedName("login")
    @Expose
    @Embedded
    private Login login;
    @SerializedName("name")
    @Expose
    @Embedded
    private Name name;
    @SerializedName("nat")
    @Expose
    private String nat;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("picture")
    @Expose
    @Embedded
    private Picture picture;
    @SerializedName("registered")
    @Expose
    @Embedded
    private Registered registered;

    private int isReject;

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public int getIsReject() {
        return isReject;
    }

    public void setIsReject(final int isReject) {
        this.isReject = isReject;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Result{" + "userId=" + userId + ", cell='" + cell + '\'' + ", dob=" + dob + ", email='" + email + '\'' + ", gender='" + gender + '\'' + ", id=" + id + ", location=" + location + ", login=" + login + ", name=" + name + ", nat='" + nat + '\'' + ", phone='" + phone + '\'' + ", picture=" + picture + ", registered=" + registered + ", isReject=" + isReject + '}';
    }
}
