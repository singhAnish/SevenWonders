package sampleproject.android.com.TestProject.app.di;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module (includes = ContextModule.class)
public class NetworkModule {

    @Provides @AppScope
    public OkHttpClient getOKHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache mCache ){
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).cache(mCache).build();
    }

    @Provides @AppScope
    public HttpLoggingInterceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor =  new HttpLoggingInterceptor(message -> Timber.i(message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return  interceptor;
    }

    @Provides @AppScope
    public Cache getCache(File mFile){
        return new Cache(mFile, 10*1000*1000);
    }

    @Provides @AppScope
    public File getFile(@AppContext Context mContext){
        return new File(mContext.getCacheDir(), "okhttp_cache");
    }
}
