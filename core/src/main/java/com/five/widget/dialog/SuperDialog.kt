package com.five.widget.dialog

import androidx.annotation.LayoutRes

/**
 * SuperDialog
 */
class SuperDialog : BaseDialog() {

    companion object {
        fun getInstance(): SuperDialog {
            return SuperDialog()
        }
    }

    private var convertListener: ConvertListener? = null

    override fun setUpLayoutId(): Int {
        return mLayoutResId
    }

    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
        convertListener?.convertView(holder, dialog)
    }

    fun setConvertListener(listener: ConvertListener): SuperDialog {
        convertListener = listener
        return this
    }

    fun setLayoutId(@LayoutRes layoutId: Int): SuperDialog {
        mLayoutResId = layoutId
        return this
    }
}