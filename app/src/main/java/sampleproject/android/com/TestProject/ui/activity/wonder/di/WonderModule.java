package sampleproject.android.com.TestProject.ui.activity.wonder.di;

import dagger.Module;
import dagger.Provides;
import sampleproject.android.com.TestProject.contract.WonderContract;
import sampleproject.android.com.TestProject.ui.activity.wonder.WonderActivity;

@Module
public class WonderModule {

    private final WonderActivity mActivity;
    private final WonderContract.View mView;

    public WonderModule(WonderActivity activity, WonderContract.View view){
        this.mActivity = activity;
        this.mView = view;
    }

    @Provides
    @WonderActivityScope
    public WonderActivity wonderActivity(){
        return mActivity;
    }

    @Provides
    @WonderActivityScope
    public WonderContract.View wonderView(){
        return mView;
    }
}
