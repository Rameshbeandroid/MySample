package com.ramesh.gitsample.base;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/* Ramesh. R */

public class BasePresenter<V> {

  public V view;
  private CompositeSubscription compositeSubscription;
  private Subscriber subscriber;

  public void attachView(V view) {
    this.view = view;
  }

  public void detachView() {
    view = null;
    if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
      compositeSubscription.unsubscribe();
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
