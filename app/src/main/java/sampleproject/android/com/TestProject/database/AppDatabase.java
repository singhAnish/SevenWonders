package sampleproject.android.com.TestProject.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import sampleproject.android.com.TestProject.dao.WonderDao;
import sampleproject.android.com.TestProject.model.WonderModelData;

@Database(entities = {WonderModelData.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WonderDao wonderDao();

}
