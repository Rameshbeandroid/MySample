package com.ramesh.gitsample.data.remote;

import com.ramesh.gitsample.data.model.Hero;
import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Ramesh R on 18-Feb-18.
 */

public interface ApiInterface {
  /*Do your network call here*/

  @GET("marvel") Observable<List<Hero>> getHeroes();
}
