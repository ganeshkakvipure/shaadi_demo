package com.app.shaadi.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.app.shaadi.model.Result;
import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertAll(List<Result> results);

    @Query("SELECT * from result")
    LiveData<List<Result>> results();

    @Query("DELETE FROM result")
    void deleteAllUsers();

    @Query("UPDATE result SET isReject= :isReject WHERE userId=:id")
    int updateReject(int id,int isReject);

}
