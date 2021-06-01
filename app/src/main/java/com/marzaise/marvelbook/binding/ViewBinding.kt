package com.marzaise.marvelbook.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.marzaise.marvelbook.R

object ViewBinding {

    @JvmStatic
    @BindingAdapter("snackBar")
    fun snackBar(view: View, text: String?) {
        if (!text.isNullOrEmpty())
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
    }

    @JvmStatic
    @BindingAdapter("isVisible")
    fun setVisible(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter(value = ["imageUrl", "textView"], requireAll = false)
    fun bindImageUrl(view: ImageView, imageUrl: String?, textView: TextView? = null) {
        Glide.with(view.context)
            .asBitmap()
            .load(imageUrl)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter(value = ["favoriteSource"], requireAll = false)
    fun bindFavoriteIcon(view: ImageView, isFavorite: Boolean) {
        view.setImageResource(if (isFavorite) R.drawable.ic_favourite_selected else R.drawable.ic_favourite_unselected)
    }
}
