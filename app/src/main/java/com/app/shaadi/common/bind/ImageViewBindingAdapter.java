package com.app.shaadi.common.bind;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import com.app.shaadi.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageViewBindingAdapter {

    @BindingAdapter("image")
    public static void loadImage(@NonNull ImageView imageView, @Nullable String path) {
        RequestOptions options = new RequestOptions().placeholder(R.drawable.default_user).error(R.drawable.default_error);
        Glide.with(imageView.getContext()).load(path).apply(options).into(imageView); //preview bitmap image.
    }


}
