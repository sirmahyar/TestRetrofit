package mahyar.testretrofit.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mahyar.testretrofit.R;
import mahyar.testretrofit.data.api.AuthService;
import mahyar.testretrofit.data.models.RegisterResponseJM;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mahyar on 8/9/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.email_edt)
    EditText email;

    @BindView(R.id.password_edt)
    EditText password;

    @BindView(R.id.username_edt)
    EditText userName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mahyar.testretrofit.R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.register_btn)
    void click() {
        registerUser();
    }

    private void registerUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://todo.vestaak.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuthService service = retrofit.create(AuthService.class);

        Call<RegisterResponseJM> call = service.registerUser(
                userName.getText().toString()
                , email.getText().toString()
                , password.getText().toString()
        );

        call.enqueue(new Callback<RegisterResponseJM>() {
            @Override
            public void onResponse(Call<RegisterResponseJM> call, Response<RegisterResponseJM> response) {
                Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<RegisterResponseJM> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_LONG).show();
                Log.d("error is ", "the error " + t.getLocalizedMessage());
            }
        });
    }


}
