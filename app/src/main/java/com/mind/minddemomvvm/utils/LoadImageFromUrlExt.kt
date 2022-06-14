package com.mind.minddemomvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mind.minddemomvvm.R

@BindingAdapter("loadImageFromUrl")
fun ImageView.loadImageFromUrl(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(this.context).load(url)
            .placeholder(R.drawable.placeholder_image).into(this);
    }
}