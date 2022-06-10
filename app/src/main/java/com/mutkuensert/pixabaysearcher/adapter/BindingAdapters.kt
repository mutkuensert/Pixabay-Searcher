package com.mutkuensert.pixabaysearcher.adapter

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.mutkuensert.pixabaysearcher.R

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String?){
    imageUrl?.let {

        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        val progressBar = CircularProgressDrawable(imageView.context).apply {
            strokeWidth = 15f
            centerRadius = 250f
            start()
        }

        Glide.with(imageView.context)
            .load(imageUri)
            .placeholder(progressBar)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(imageView)
    }
}

@BindingAdapter("pixabayUrl")
fun getPixabayLogo(imageView: ImageView, pixabayUrl: String){
    imageView.setOnClickListener(View.OnClickListener {
        startActivity(it.context, Intent(Intent.ACTION_VIEW, Uri.parse(pixabayUrl)),null)
    })
}