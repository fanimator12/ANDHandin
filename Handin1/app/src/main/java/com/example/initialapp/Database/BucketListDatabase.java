package com.example.initialapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.google.android.gms.auth.api.Auth;

@Database(entities = {BucketListGoals.class, Authorization.class}, version = 7, exportSchema = false)
public abstract class BucketListDatabase extends RoomDatabase {

    private static BucketListDatabase instance;
    private static Authorization secondInstance;

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
