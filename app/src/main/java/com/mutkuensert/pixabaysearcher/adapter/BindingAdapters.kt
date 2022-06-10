package com.mutkuensert.pixabaysearcher.adapter

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mutkuensert.pixabaysearcher.R

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String?){
    imageUrl?.let {

        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imageUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.ic_baseline_downloading_24)
                .error(R.drawable.ic_baseline_error_outline_24))
            .into(imageView)
    }
}

@BindingAdapter("pixabayUrl")
fun getPixabayLogo(imageView: ImageView, pixabayUrl: String){
    imageView.setOnClickListener(View.OnClickListener {
        startActivity(it.context, Intent(Intent.ACTION_VIEW, Uri.parse(pixabayUrl)),null)
    })
}