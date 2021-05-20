package com.example.initialapp.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "authorization")
public class Authorization {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "token")
    private String token;

    public Authorization(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}