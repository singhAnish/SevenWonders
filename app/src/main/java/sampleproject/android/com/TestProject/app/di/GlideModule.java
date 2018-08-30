package sampleproject.android.com.TestProject.app.di;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class GlideModule {

    @Provides
    @AppScope
    public Glide glide(@AppContext Context context){
        return Glide.get(context);
    }

    @Provides
    @AppScope
    public RequestManager requestManager(@AppContext Context context){
        return Glide.with(context);
    }
}
