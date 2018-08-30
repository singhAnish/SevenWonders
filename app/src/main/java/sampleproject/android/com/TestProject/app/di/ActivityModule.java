package sampleproject.android.com.TestProject.app.di;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity mContext;

    public ActivityModule(Activity context){
        this.mContext = context;
    }

    @Provides
    @AppScope
    @Named("activity_context")//Can also use annotation Qualifier to differentiate between context
    public Context provideContext(){
        return  mContext;
    }

}
