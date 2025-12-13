package com.samir.androidapptesting.presentation.extensions

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.samir.androidapptesting.R

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}


fun ImageView.loadRounded(
    url: String?,
    radiusDp: Int = 20
) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.placeholder_avatar)
        .error(R.drawable.placeholder_avatar)
        .transform(
            CenterCrop(),
            RoundedCorners(radiusDp.dpToPx(context))
        )
        .into(this)
}

fun Int.dpToPx(context: Context): Int =
    (this * context.resources.displayMetrics.density).toInt()

