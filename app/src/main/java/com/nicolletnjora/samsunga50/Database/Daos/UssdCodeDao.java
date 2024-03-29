package com.nicolletnjora.samsunga50.Database.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.nicolletnjora.samsunga50.Models.UssdCode;

import java.util.List;

@Dao
public interface UssdCodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUssdCode(UssdCode ussdCode);

    @Update
    void update(UssdCode ussdCode);

    @Query("SELECT * FROM UssdCode ORDER BY id ASC")
    List<UssdCode> getUssdCodes();

    @Delete()
    void delete(UssdCode ussdCode);
}
