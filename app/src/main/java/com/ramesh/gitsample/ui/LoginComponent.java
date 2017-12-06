package com.ramesh.gitsample.ui;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by lencare on 05-Dec-17.
 */
@Subcomponent public interface LoginComponent extends AndroidInjector<LoginActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<LoginActivity> {
  }
}
