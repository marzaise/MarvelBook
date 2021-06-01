package com.marzaise.marvelbook.binding

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import androidx.palette.graphics.Palette

object ViewBinding {
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
}
