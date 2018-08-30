package sampleproject.android.com.TestProject.app.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context mContext;

    public ContextModule(Context context){
        this.mContext = context;
    }

    @Provides
    @AppScope
    @AppContext //can also use Named annotation to differentiate between context
    public Context provideContext(){
        return  mContext;
    }

}
