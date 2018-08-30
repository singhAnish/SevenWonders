package sampleproject.android.com.TestProject.ui.activity.wonder.di;

import dagger.Component;
import sampleproject.android.com.TestProject.app.di.AppComponent;
import sampleproject.android.com.TestProject.ui.activity.wonder.WonderActivity;

@Component(modules = WonderModule.class, dependencies = AppComponent.class) //dependencies annotation include extra dependencies and dagger will provide those dependencies
@WonderActivityScope
public interface WonderComponent {

    void inject (WonderActivity activity);

}
