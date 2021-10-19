package com.app.shaadi.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.TypeConverters;
import com.app.shaadi.db.convertors.ResultListConvertor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class User {

    @Expose
    private Info info;

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(final Info info) {
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(final List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "User{" + "info=" + info + ", results=" + results + '}';
    }
}
