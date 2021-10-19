package com.app.shaadi.common.bind;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

public class LinearLayoutBindingAdapter {

    @BindingAdapter("isVisible")
    public static void loadImage(@NonNull LinearLayout linearLayout, @Nullable int value) {
        if(value==0){
            linearLayout.setVisibility(View.VISIBLE);
        }else{
            linearLayout.setVisibility(View.GONE);
        }
    }

}
