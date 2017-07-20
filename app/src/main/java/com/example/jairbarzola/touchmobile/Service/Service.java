package com.example.jairbarzola.touchmobile.Service;

import com.example.jairbarzola.touchmobile.MobileTest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jair Barzola on 20-Jul-17.
 */

public interface Service {
    @GET("mobiletest.json")
    Call<List<MobileTest>> getData ();
}
