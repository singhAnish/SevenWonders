package sampleproject.android.com.TestProject.app.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import sampleproject.android.com.TestProject.database.AppDatabase;

@Module(includes = ContextModule.class)
public class DataBaseModule {

    @Provides
    @AppScope
    public AppDatabase requestDataBase(@AppContext Context context){
        return  Room.databaseBuilder(context, AppDatabase.class, "Development").allowMainThreadQueries().build();
    }
}
