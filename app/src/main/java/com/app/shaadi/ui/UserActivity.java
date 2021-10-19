package com.app.shaadi.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.app.shaadi.R;
import com.app.shaadi.common.NetworkHelper;
import com.app.shaadi.databinding.ActivityUserBinding;

public class UserActivity extends BaseActivity {


    private final String TAG = "UserActivity";
    private UserViewModel mUserViewModel;
    private UserAdapter mUserAdapter;
    private ActivityUserBinding mActivityUserBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyBinding();
        applyViewModel();
        applyObservers();
        setUpRecyclerView();
    }


    private void applyBinding() {
        mActivityUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_user);
        // Specify the current activity as the lifecycle owner.
        mActivityUserBinding.setLifecycleOwner(this);
        mActivityUserBinding.setViewModel(mUserViewModel);
    }

    private void applyViewModel() {
        // Get the ViewModel.
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
    }

    private void applyObservers() {
        //observer delivery response from network
        mUserViewModel.getUsers().observe(this, resultResource  -> {
            if (resultResource != null) {
                switch (resultResource.getStatus()) {
                    case LOADING: {
                        Log.d(TAG, "Loading...");
                        showProgressBar();
                        break;
                    }
                    case ERROR: {
                        Log.d(TAG, "Error"+resultResource.getException());
                        hideProgressBar();
                        Toast.makeText(this,getResources().getString(R.string.unable_to_load),Toast.LENGTH_LONG).show();
                        break;


                    }
                    case SUCCESS: {
                        Log.d(TAG, "Success...");
                        hideProgressBar();
                        if(resultResource.getData()!=null && !resultResource.getData().isEmpty()){
                            if(mUserAdapter !=null){
                                mUserAdapter.updateData(resultResource.getData(),mUserViewModel);
                            }
                        }
                        break;
                    }
                }
            }
        });

    }

    private void setUpRecyclerView() {
        mActivityUserBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this));
        mUserAdapter = new UserAdapter(this);
        mActivityUserBinding.rvUsers.setAdapter(mUserAdapter);
    }
}
