package sampleproject.android.com.TestProject.presenter;

import sampleproject.android.com.TestProject.contract.WonderContract.Presenter;
import sampleproject.android.com.TestProject.contract.WonderContract.View;
import sampleproject.android.com.TestProject.database.AppDatabase;
import sampleproject.android.com.TestProject.util.base.BasePresenter;

public class WonderPresenter extends BasePresenter<View> implements Presenter {

    private AppDatabase mDB;

    public WonderPresenter(View view, AppDatabase db) {
        this.mDB = db;
        this.view = view;
        loadData();
    }

    @Override
    public void loadData() {
        if (view == null) {
            return;
        }
        if (mDB.wonderDao().getWonderData().size() > 0) {
            loadGridView();
        } else {
            view.loadContentFromAPI();
        }
    }

    @Override
    public void loadGridView() {
        if (view == null) {
            return;
        }
        view.updateGridView();
    }
}
