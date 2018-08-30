package sampleproject.android.com.TestProject.ui.activity.wonder.di;

import com.bumptech.glide.RequestManager;

import dagger.Module;
import dagger.Provides;
import sampleproject.android.com.TestProject.adapter.WonderAdapter;
import sampleproject.android.com.TestProject.database.AppDatabase;
import sampleproject.android.com.TestProject.ui.activity.wonder.WonderActivity;

@Module
public class WonderModule {

    private final WonderActivity mActivity;

    public WonderModule(WonderActivity activity){
        this.mActivity = activity;
    }

    @Provides
    @WonderActivityScope //Activity and App lifecycle are different, providing activity scope
    public WonderAdapter wonderAdapter(RequestManager manager, AppDatabase db){
        return new WonderAdapter(mActivity, manager, db);
    }
}
