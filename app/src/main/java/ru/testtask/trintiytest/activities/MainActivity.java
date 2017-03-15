package ru.testtask.trintiytest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.testtask.trintiytest.R;
import ru.testtask.trintiytest.adapters.UserAdapter;
import ru.testtask.trintiytest.models.User;
import ru.testtask.trintiytest.services.ServerApi;
import ru.testtask.trintiytest.stuff.SimpleDividerItemDecoration;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static ServerApi serverApi;
    RecyclerView recyclerView;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://a11d.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userList = new ArrayList<>();
        serverApi = retrofit.create(ServerApi.class);
        recyclerView = (RecyclerView) findViewById(R.id.users);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        UserAdapter adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));
        getApi().getData().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static ServerApi getApi() {
        return serverApi;
    }


}
