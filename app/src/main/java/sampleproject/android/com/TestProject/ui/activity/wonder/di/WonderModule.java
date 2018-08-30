package sampleproject.android.com.TestProject.ui.activity.wonder.di;

import dagger.Module;
import dagger.Provides;
import sampleproject.android.com.TestProject.ui.activity.wonder.WonderActivity;

@Module
public class WonderModule {

    private final WonderActivity mActivity;

    public WonderModule(WonderActivity activity){
        this.mActivity = activity;
    }

    @Provides
    @WonderActivityScope //Activity and App lifecycle are different, providing activity scope
    public WonderActivity wonderActivity(){
        return mActivity;
    }
}
