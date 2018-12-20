package com.five.widget.dialog

/**
 * 弹窗内容管理
 */
interface ConvertListener {
    fun convertView(holder: ViewHolder, dialog: BaseDialog)
}

/**
 * 弹窗消失回调
 */
interface DismissListener {
    fun onDismiss(dialog: BaseDialog)
}