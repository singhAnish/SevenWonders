package sampleproject.android.com.TestProject.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import sampleproject.android.com.TestProject.BuildConfig;
import sampleproject.android.com.TestProject.model.MockyModel;

public interface APIInterface {

    @GET(BuildConfig.KEY)
    Call<MockyModel> getMovieListData();

}