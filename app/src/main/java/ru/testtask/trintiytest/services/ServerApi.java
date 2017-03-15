package ru.testtask.trintiytest.services;

/**
 * Created by nfedorov on 15.03.17.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import ru.testtask.trintiytest.models.User;
public interface ServerApi {
    @GET("/users.json")
    Call<List<User>> getData();
}
