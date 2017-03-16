package ru.testtask.trintiytest;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.testtask.trintiytest.services.ServerApi;

/**
 * Created by nfedorov online 16.03.17.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;
    private Retrofit retrofit;
    private static ServerApi serverApi;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://a11d.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        serverApi = retrofit.create(ServerApi.class);
    }

    public static ServerApi getApi() {
        return serverApi;
    }

    public BaseApplication() {
        super();
        instance = this;
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
