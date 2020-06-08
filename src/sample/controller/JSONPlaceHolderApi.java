package sample.controller;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import sample.model.BearerToken;
import sample.model.User;

/**
 * @author zh.turemuratov on 5/21/20
 */
public interface JSONPlaceHolderApi {


    @POST("authenticate")
    Call<BearerToken> loginByPassword(@Body User user);


}
