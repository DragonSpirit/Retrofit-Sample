package ru.testtask.trintiytest.adapters;

/**
 * Created by nfedorov online 15.03.17.
 */

import android.databinding.DataBindingUtil;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.testtask.trintiytest.R;
import ru.testtask.trintiytest.databinding.ListItemBinding;
import ru.testtask.trintiytest.models.User;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private List<User> users = new ArrayList<>();

    public UserAdapter(List<User> userList) {
        this.users = userList;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final ListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false);

        return new ViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final User user = this.users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding binding;

        public ViewHolder(final View view, final ListItemBinding binding) {
            super(view);
            this.binding = binding;
        }

        @UiThread
        public void bind(final User user) {
            this.binding.setUser(user);
        }
    }
}
