package com.app.shaadi.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.app.shaadi.db.convertors.ResultListConvertor;
import com.app.shaadi.db.dao.UserDao;
import com.app.shaadi.model.Result;

/**
 * Created by Ganesh on 18/10/2021.
 */



@Database(version = 1, entities = {Result.class}, exportSchema = false)
@TypeConverters(ResultListConvertor.class)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;
    private static final String TAG="AppDatabase";
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "shaadi_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    public abstract UserDao userDao();
}

