package com.ramesh.gitsample.base;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import butterknife.ButterKnife;
import javax.inject.Inject;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by lencare on 11-Feb-18.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

  protected P presenter;

  protected abstract P intPresenter();
  private CompositeSubscription compositeSubscription;
  private Subscriber subscriber;

  protected void bindLayout(int layOut) {
    setContentView(layOut);
    ButterKnife.bind(this);
    presenter = intPresenter();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.detachView();
    if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
      compositeSubscription.unsubscribe();
      Log.e("BasePresenter", "dettachView");
    }
  }

  protected void onSubscribe(Observable observable, Subscriber subscriber) {
    this.subscriber = subscriber;

    if (compositeSubscription == null) {
      compositeSubscription = new CompositeSubscription();
    }
    compositeSubscription.add(observable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber));
  }

  protected void stop() {
    if (subscriber != null) {
      subscriber.unsubscribe();
    }
  }
}
