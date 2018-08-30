package sampleproject.android.com.TestProject.ui.activity.wonder.di;

import dagger.Component;
import sampleproject.android.com.TestProject.adapter.WonderAdapter;
import sampleproject.android.com.TestProject.app.di.AppComponent;
import sampleproject.android.com.TestProject.database.AppDatabase;
import sampleproject.android.com.TestProject.network.APIInterface;

@Component(modules = WonderModule.class, dependencies = AppComponent.class) //dependencies annotation include extra dependencies and dagger will provide those dependencies
@WonderActivityScope
public interface WonderComponent {

    WonderAdapter wonderAdapter(); // will return instance of wonderAdapter

    APIInterface getAPIInterface(); // will return instance of APIInterface

    AppDatabase getDataBase(); //will return instance of AppDataBase
}
