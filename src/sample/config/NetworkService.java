package sample.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sample.controller.JSONPlaceHolderApi;

public class NetworkService {

    private final String BASE_URL = "http://localhost:8080/api/";
    private static NetworkService mInstance;
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public JSONPlaceHolderApi getJSONApi() {
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }


}
