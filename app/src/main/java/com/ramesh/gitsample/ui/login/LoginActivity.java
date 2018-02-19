package com.ramesh.gitsample.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.ramesh.gitsample.AppClass;
import com.ramesh.gitsample.R;
import com.ramesh.gitsample.base.BaseActivity;
import com.ramesh.gitsample.data.model.Hero;
import com.ramesh.gitsample.data.remote.ApiInterface;
import dagger.android.AndroidInjection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

  @BindView(R.id.et_user_name) EditText etUserName;

  @BindView(R.id.et_user_password) EditText etPassword;

  @Inject Retrofit retrofit;

  @BindView(R.id.lstv_heros) ListView listView;

  @Override public LoginPresenter intPresenter() {
    Log.d("LogTrack", " : LoginPresenter() ");
    return new LoginPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bindLayout(R.layout.activity_login);
    ((AppClass) getApplication()).getNetComponent().inject(this);

    getHeroes();
  }

  private void display(@Nullable String value) {
    Toast.makeText(this, " : " + value, Toast.LENGTH_SHORT).show();
  }

  @Override protected void onResume() {
    super.onResume();
    presenter.isLogin();
  }

  @OnClick() public void btUserLogin() {
    String userName = etUserName.getText().toString();
    String userPassword = etPassword.getText().toString();
  }

  @Override public void onSuccess(Object model) {

  }

  @Override public void onError(String s) {
    Toast.makeText(this, "" + s, Toast.LENGTH_LONG).show();
  }

  @Override public void onNavigation() {
    /*Moving to another activity*/
  }

  private void getHeroes() {
    ApiInterface api = retrofit.create(ApiInterface.class);
    Call<List<Hero>> call = api.getHeroes();

    call.enqueue(new Callback<List<Hero>>() {
      @Override public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
        List<Hero> heroList = response.body();
        String[] heroes = new String[heroList.size()];

        for (int i = 0; i < heroList.size(); i++) {
          heroes[i] = heroList.get(i).getName();
        }

        listView.setAdapter(
            new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
                heroes));
      }

      @Override public void onFailure(Call<List<Hero>> call, Throwable t) {
        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }
}
