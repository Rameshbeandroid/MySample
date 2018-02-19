package com.ramesh.gitsample.base;


public interface BaseView<M> {

  void onSuccess(M model);

  void onError(String s);
}
