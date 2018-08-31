package sampleproject.android.com.TestProject.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import sampleproject.android.com.TestProject.model.WonderModelData;

@Dao
public interface WonderDao {
    @Query("SELECT * FROM WonderModelData")
    List<WonderModelData> getWonderData();

    @Insert
    void insertWonderData(WonderModelData... model);

    @Query("DELETE FROM WonderModelData")
    void clearWonderData();
}
