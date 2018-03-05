package com.ramesh.gitsample.data.local.db;

import android.content.Context;
import android.content.res.Resources;
import com.ramesh.gitsample.data.local.prefs.SharedPrefsHelper;
import com.ramesh.gitsample.data.model.User;
import com.ramesh.gitsample.di.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lencare on 05-Mar-18.
 */

@Singleton
public class DataManager {

  private Context mContext;
  private DbHelper mDbHelper;
  private SharedPrefsHelper mSharedPrefsHelper;

  //@Inject
  //public DataManager(@ApplicationContext Context context,
  //    DbHelper dbHelper,
  //    SharedPrefsHelper sharedPrefsHelper) {
  //  mContext = context;
  //  mDbHelper = dbHelper;
  //  mSharedPrefsHelper = sharedPrefsHelper;
  //}


  public DataManager(Context context,
      DbHelper dbHelper,
      SharedPrefsHelper sharedPrefsHelper) {
    mContext = context;
    mDbHelper = dbHelper;
    mSharedPrefsHelper = sharedPrefsHelper;
  }

  public void saveAccessToken(String accessToken) {
    mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
  }

  public String getAccessToken(){
    return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
  }

  public Long createUser(User user) throws Exception {
    return mDbHelper.insertUser(user);
  }

  public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
    return mDbHelper.getUser(userId);
  }
}
