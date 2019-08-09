package com.nicolletnjora.samsunga50.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.nicolletnjora.samsunga50.Database.Daos.UssdCodeDao;
import com.nicolletnjora.samsunga50.Models.UssdCode;



@Database(entities = {UssdCode.class}, version = 1)
public abstract class UssdCodesDatabase extends RoomDatabase {

    private static UssdCodesDatabase INSTANCE;
    public abstract UssdCodeDao UssdCodeDao();
    private static final Object syncLockObject = new Object();

    public static UssdCodesDatabase getDatabaseInstance(Context context){
        if (INSTANCE == null){
            synchronized (syncLockObject){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        UssdCodesDatabase.class, "UssdCode.db")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

}
