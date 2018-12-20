package com.five.widget.dialog

import android.graphics.Bitmap
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes

/**
 * 内容容器辅助类
 */
class ViewHolder(private var convertView: View) {

    companion object {
        fun create(view: View): ViewHolder {
            return ViewHolder(view)
        }
    }

    //子View集合
    private var views: SparseArray<View> = SparseArray()

    @Suppress("UNCHECKED_CAST")
    fun <T : View> getViews(@IdRes viewId: Int): T {
        var view = views.get(viewId)
        if (view == null) {
            view = convertView.findViewById(viewId)
            views.put(viewId, view)
        }
        return view as T
    }

    fun setTextSize(@IdRes viewId: Int, size: Float) {
        val view: TextView = getViews(viewId)
        view.textSize = size
    }

    fun setTextColor(@IdRes viewId: Int, @ColorInt colorId: Int) {
        val view: TextView = getViews(viewId)
        view.setTextColor(colorId)
    }

    fun setBackgroundResource(@IdRes viewId: Int, @DrawableRes resId: Int) {
        val view: View = getViews(viewId)
        view.setBackgroundResource(resId)
    }

    fun setBackgroundColor(@IdRes viewId: Int, @ColorInt colorId: Int) {
        val view: View = getViews(viewId)
        view.setBackgroundColor(colorId)
    }

    fun setOnClickListener(@IdRes viewId: Int, listener: View.OnClickListener) {
        val view: View = getViews(viewId)
        view.setOnClickListener(listener)
    }

    fun setVisibility(@IdRes viewId: Int, visibility: Int) {
        val view: View = getViews(viewId)
        view.visibility = visibility
    }

    fun setImageResource(@IdRes viewId: Int, @DrawableRes resId: Int) {
        val view: ImageView = getViews(viewId)
        view.setImageResource(resId)
    }

    fun setImageBitmap(@IdRes viewId: Int, bitmap: Bitmap) {
        val view: ImageView = getViews(viewId)
        view.setImageBitmap(bitmap)
    }

    fun setText(@IdRes viewId: Int, text: CharSequence) {
        val view: TextView = getViews(viewId)
        view.text = text
    }

    fun setText(@IdRes viewId: Int, @StringRes strId: Int) {
        val view: TextView = getViews(viewId)
        view.setText(strId)
    }

    fun setProgress(@IdRes viewId: Int, progress: Int) {
        val view: ProgressBar = getViews(viewId)
        view.progress = progress
    }

    fun setProgress(@IdRes viewId: Int, progress: Int, max: Int) {
        val view: ProgressBar = getViews(viewId)
        view.max = max
        view.progress = progress
    }

    fun setMax(@IdRes viewId: Int, max: Int) {
        val view: ProgressBar = getViews(viewId)
        view.max = max
    }

    fun getConvertView(): View {
        return convertView
    }
}