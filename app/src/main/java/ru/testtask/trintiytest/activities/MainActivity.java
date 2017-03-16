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
import ru.testtask.trintiytest.BaseApplication;
import ru.testtask.trintiytest.R;
import ru.testtask.trintiytest.adapters.UserAdapter;
import ru.testtask.trintiytest.models.User;
import ru.testtask.trintiytest.stuff.SimpleDividerItemDecoration;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.users);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        UserAdapter adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));
        BaseApplication.getApi().getData().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Check network connection", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
