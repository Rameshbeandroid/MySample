package com.ramesh.gitsample.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ramesh.gitsample.data.local.db.DataManager;
import com.ramesh.gitsample.data.local.db.DbHelper;
import com.ramesh.gitsample.data.local.prefs.SharedPrefsHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Belal on 12/2/2017.
 */

@Module public class ApiModule {

  String mBaseUrl;
  Context mContext;

  public ApiModule(String mBaseUrl, Context mContext) {
    this.mBaseUrl = mBaseUrl;
    this.mContext = mContext;
  }

  @Provides Context provideContext() {
    return mContext;
  }

  @Provides @Singleton Cache provideHttpCache(Application application) {
    int cacheSize = 10 * 1024 * 1024;
    Cache cache = new Cache(application.getCacheDir(), cacheSize);
    return cache;
  }

  @Provides @Singleton Gson provideGson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    return gsonBuilder.create();
  }

  @Provides @Singleton OkHttpClient provideOkhttpClient(Cache cache) {
    OkHttpClient.Builder client = new OkHttpClient.Builder();
    client.cache(cache);
    return client.build();
  }

  @Provides @Singleton Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
    return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(mBaseUrl)
        .client(okHttpClient)
        .build();
  }

  @Provides @DatabaseInfo String provideDatabaseName() {
    return "demo-dagger.db";
  }

  @Provides @DatabaseInfo Integer provideDatabaseVersion() {
    return 2;
  }

  @Provides @PrefInfo String providePreferenceName() {
    return "demo-prefs";
  }

  @Singleton @Provides DbHelper provideDbHelper(Context context, @DatabaseInfo String dbname,
      @DatabaseInfo Integer version) {
    return new DbHelper(context, dbname, version);
  }

  @Singleton @Provides SharedPreferences provideSharedPrefs(Context context,
      @PrefInfo String prefName) {
    return context.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
  }

  @Singleton @Provides SharedPrefsHelper provideSharedPrefsHelper(
      SharedPreferences sharedPreferences) {
    return new SharedPrefsHelper(sharedPreferences);
  }

  @Singleton @Provides DataManager provideDataManager(Context context, DbHelper dbHelper,
      SharedPrefsHelper sharedPrefsHelper) {
    return new DataManager(context, dbHelper, sharedPrefsHelper);
  }
}
