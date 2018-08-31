package sampleproject.android.com.TestProject.presenter;

import javax.inject.Inject;

import sampleproject.android.com.TestProject.contract.WonderContract.Presenter;
import sampleproject.android.com.TestProject.contract.WonderContract.View;
import sampleproject.android.com.TestProject.database.AppDatabase;
import sampleproject.android.com.TestProject.ui.activity.wonder.WonderActivity;
import sampleproject.android.com.TestProject.util.base.BasePresenter;

public class WonderPresenter extends BasePresenter<View> implements Presenter {

    private AppDatabase mDB;
    private WonderActivity mActivity;

    @Inject
    WonderPresenter(WonderActivity activity, View view, AppDatabase db) {
        this.mActivity = activity;
        this.view = view;
        this.mDB = db;
    }

    @Override
    public void loadData() {
        if (mDB.wonderDao().getWonderData().size() > 0) {
            loadGridView();
        } else {
            view.loadContentFromAPI();
        }
    }

    @Override
    public void loadGridView() {
        if(mDB.wonderDao().getWonderData().size() > 0){
            view.updateGridView();
        }else{
            mActivity.showToast("No Data Found");
        }

    }
}
