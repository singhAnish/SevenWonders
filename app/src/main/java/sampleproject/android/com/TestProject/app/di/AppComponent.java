package sampleproject.android.com.TestProject.app.di;

import com.bumptech.glide.RequestManager;

import dagger.Component;
import sampleproject.android.com.TestProject.database.AppDatabase;
import sampleproject.android.com.TestProject.network.APIInterface;

@AppScope //@singleton is myth, internally it uses concept of scoping
@Component(modules = {AppModule.class, GlideModule.class, DataBaseModule.class})
public interface AppComponent {

    APIInterface getAPIInterface(); // will return instance of APIService

    RequestManager getGlideManager(); // Will return Glide RequestManager

    AppDatabase getDataBase(); // Will return instance of AppDataBase
}
