package com.ramesh.gitsample.ui.login;

import com.ramesh.gitsample.base.BaseView;
import com.ramesh.gitsample.data.model.Hero;
import java.util.List;

/**
 * Created by Ramesh R on 12-Feb-18.
 */

public interface LoginView extends BaseView<List<Hero>> {

  void onNavigation();
}
