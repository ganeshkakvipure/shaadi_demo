package com.app.shaadi.common.bind;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;
import com.app.shaadi.R;

public class TextViewBindingAdapter {

    @BindingAdapter("isReject")
    public static void updateReject(@NonNull AppCompatTextView appCompatTextView, @Nullable int value) {
        if(value==0){
            appCompatTextView.setVisibility(View.GONE);
        }else if(value==1||value==2){
            appCompatTextView.setVisibility(View.VISIBLE);
            if(value==1){
                appCompatTextView.setText(appCompatTextView.getContext().getResources().getString(R.string.accepted_title));
                appCompatTextView.setBackground(appCompatTextView.getContext().getResources().getDrawable(R.drawable.border_green));
                appCompatTextView.setTextColor(appCompatTextView.getContext().getResources().getColor(R.color.green));
            }else{
                appCompatTextView.setText(appCompatTextView.getContext().getResources().getString(R.string.rejected_title));
                appCompatTextView.setBackground(appCompatTextView.getContext().getResources().getDrawable(R.drawable.border_red));
                appCompatTextView.setTextColor(appCompatTextView.getContext().getResources().getColor(R.color.red));
            }
        }
    }

}
