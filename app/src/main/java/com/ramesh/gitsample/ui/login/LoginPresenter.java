package com.ramesh.gitsample.ui.login;

import com.ramesh.gitsample.base.BasePresenter;
import com.ramesh.gitsample.data.model.Hero;
import com.ramesh.gitsample.data.remote.ApiInterface;
import com.ramesh.gitsample.data.remote.RequestCallback;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Ramesh R on 15-Feb-18.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

  public LoginPresenter(LoginView view) {
    super.attachView(view);
  }

  public void getHero(Retrofit retrofit) {
    ApiInterface api = retrofit.create(ApiInterface.class);
    onSubscribe(api.getHeroes(), new RequestCallback<List<Hero>>() {
      @Override public void onSuccess(List<Hero> heroList) {
        view.onSuccess(heroList);
      }

      @Override public void onFailure(String message) {
        view.onError(message);
      }

      @Override public void onFinish() {

      }
    });

    //Call<List<Hero>> call = api.getHeroes();
    //
    //call.enqueue(new Callback<List<Hero>>() {
    //  @Override public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
    //    List<Hero> heroList = response.body();
    //
    //    view.onSuccess(heroList);
    //  }
    //
    //  @Override public void onFailure(Call<List<Hero>> call, Throwable t) {
    //    view.onError(String.valueOf(t));
    //  }
    //});
  }
}
