package mahyar.testretrofit.data.api;

import mahyar.testretrofit.data.models.RegisterResponseJM;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by mahyar on 8/9/2017.
 */

public interface AuthService {

    @POST("user")
    Call<RegisterResponseJM> registerUser(
            @Query("name") String name
            , @Query("email") String email
            , @Query("password") String password);
}
