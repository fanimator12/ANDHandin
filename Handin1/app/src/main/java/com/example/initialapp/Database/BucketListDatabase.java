package com.example.initialapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BucketListGoals.class}, version = 4, exportSchema = false)
public abstract class BucketListDatabase extends RoomDatabase {

    private static BucketListDatabase instance;

    public abstract BucketListDAO bucketListDAO();

    public static synchronized BucketListDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    BucketListDatabase.class, "bucketlist_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
