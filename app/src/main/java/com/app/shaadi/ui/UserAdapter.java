package com.app.shaadi.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.shaadi.databinding.UserLayoutBinding;
import com.app.shaadi.model.Result;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MainViewHolder> {

    private List<Result> mResultList =new ArrayList<>();
    private LayoutInflater mInflater;
    private UserViewModel mUserViewModel;


    public UserAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void updateData(List<Result> resultList,UserViewModel userViewModel) {
        if(!this.mResultList.isEmpty()){
            this.mResultList.clear();
        }
        this.mResultList = resultList;
        this.mUserViewModel=userViewModel;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(UserLayoutBinding.inflate(mInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.binding.setViewModel(mUserViewModel);
        holder.binding.setModel(mResultList.get(position));
    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }


    class MainViewHolder extends RecyclerView.ViewHolder {

        private UserLayoutBinding binding;

        private MainViewHolder(UserLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
