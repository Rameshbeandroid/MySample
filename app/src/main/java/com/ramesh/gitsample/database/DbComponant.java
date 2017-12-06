package com.ramesh.gitsample.database;

import com.ramesh.gitsample.ui.LoginActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by lencare on 05-Dec-17.
 */
@Subcomponent(modules = DbModule.class)
public interface DbComponant
    extends AndroidInjector<LoginActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<LoginActivity> {
  }
}
