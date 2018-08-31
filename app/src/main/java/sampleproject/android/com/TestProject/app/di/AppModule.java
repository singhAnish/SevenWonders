package sampleproject.android.com.TestProject.app.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sampleproject.android.com.TestProject.BuildConfig;
import sampleproject.android.com.TestProject.network.APIInterface;
import sampleproject.android.com.TestProject.network.DateTimeConverter;

@Singleton
@Module(includes = NetworkModule.class) //include annotation will provide corresponding dependencies
public class AppModule {

    @Provides @AppScope
    public APIInterface getAPIInterface(Retrofit mRetrofit){
        return mRetrofit.create(APIInterface.class);
    }

    @Provides @AppScope
    public Retrofit getRetrofit(OkHttpClient mOKHttpClient, Gson gson){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(mOKHttpClient)
                .baseUrl(BuildConfig.BASE_URL).build();
    }

    @Provides @AppScope
    public Gson getGson(){
        GsonBuilder builder = new GsonBuilder();
        return builder.registerTypeAdapter(DateTime.class, new DateTimeConverter()).create();
    }

}
