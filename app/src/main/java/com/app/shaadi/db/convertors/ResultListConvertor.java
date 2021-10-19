package com.app.shaadi.db.convertors;

import androidx.room.TypeConverter;
import com.app.shaadi.model.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResultListConvertor {
    @TypeConverter
    public String fromResultList(List<Result> resultList) {
        if (resultList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Result>>() {}.getType();
        return gson.toJson(resultList, type);
    }

    @TypeConverter
    public List<Result> toResultList(String result) {
        if (result == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Result>>() {}.getType();
        return gson.fromJson(result, type);
    }
}
