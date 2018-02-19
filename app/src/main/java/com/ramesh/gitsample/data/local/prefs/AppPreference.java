package com.ramesh.gitsample.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;

/**
 * Created by lencare on 19-Feb-18.
 */

public class AppPreference implements PreferenceHelper {

  /* Preference */
  private final SharedPreferences preferences;

  /*Preference name*/

  public static final String PREF_KEY_PROFILE_NAME = "PREF_KEY_PROFILE_NAME";

  @Inject
  public AppPreference(Context context, String preferenceName) {
    preferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
  }

  @Override public void putUserName(String value) {
    preferences.edit().putString(PREF_KEY_PROFILE_NAME, value);
  }

  @Override public String getUserName() {
    return preferences.getString(PREF_KEY_PROFILE_NAME, null);
  }
}
