package sampleproject.android.com.TestProject.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import sampleproject.android.com.TestProject.app.di.AppComponent;
import sampleproject.android.com.TestProject.app.di.ContextModule;
import sampleproject.android.com.TestProject.app.di.DaggerAppComponent;
import sampleproject.android.com.TestProject.util.ConnectionDetector;
import timber.log.Timber;

public class MyApp extends Application {

    private static MyApp mInstance;
    private AppComponent component;

    public static MyApp get(Activity activity) {
        return (MyApp) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        this.registerReceiver(ConnectionDetector.getDetector().new NetworkReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        ConnectionDetector.getDetector().initConnectionState(this);

        Timber.plant(new Timber.DebugTree());
        //Initializing Dagger
        component = DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();
    }

    public static Context getContext(){
        return mInstance;
    }

    public AppComponent getComponent() {
        return component;
    }
}