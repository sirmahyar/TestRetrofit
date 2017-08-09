package mahyar.testretrofit.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;

/**
 * Created by mahyar on 8/9/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    @BindView(mahyar.testretrofit.R.id.email_edt)
    EditText email;

    @BindView(mahyar.testretrofit.R.id.password_edt)
    EditText pasword;

    @BindView(mahyar.testretrofit.R.id.username_edt)
    EditText userName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mahyar.testretrofit.R.layout.activity_main);


    }
}
