package com.ramesh.gitsample.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import com.ramesh.gitsample.AppClass;
import com.ramesh.gitsample.R;
import com.ramesh.gitsample.base.BaseActivity;
import com.ramesh.gitsample.data.local.prefs.SharedPrefsHelper;
import com.ramesh.gitsample.data.model.Hero;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Retrofit;

import static com.ramesh.gitsample.data.local.prefs.SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

  @BindView(R.id.lstv_heros) ListView listView;

  @Inject Retrofit retrofit;
  @Inject SharedPrefsHelper mSharedPrefsHelper;

  @Override public LoginPresenter intPresenter() {
    Log.d("LogTrack", " : LoginPresenter() ");
    return new LoginPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bindLayout(R.layout.activity_login);
    ((AppClass) getApplication()).getNetComponent().inject(this);
  }

  @Override protected void onResume() {
    super.onResume();

    Log.d("RAMESHSAMPLE"," :::::::: "+mSharedPrefsHelper.get(PREF_KEY_ACCESS_TOKEN,null));
    presenter.getHero(retrofit);
  }

  @Override public void onSuccess(List<Hero> heroList) {

    String[] heroes = new String[heroList.size()];

    for (int i = 0; i < heroList.size(); i++) {
      heroes[i] = heroList.get(i).getName();
    }
    listView.setAdapter(
        new ArrayAdapter<String>(getApplicationContext(), R.layout.v_textview_block,
            heroes));
  }

  @Override public void onError(String s) {
    Toast.makeText(this, "" + s, Toast.LENGTH_LONG).show();
  }

  @Override public void onNavigation() {
    /*Moving to another activity*/
  }
}
