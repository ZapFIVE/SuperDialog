package com.five.widget.dialog

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import androidx.annotation.FloatRange
import androidx.annotation.StyleRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

/**
 * -弹窗基类
 * -默认内容区以外点击不可取消
 * -顶部和部弹窗时默认内容外点击可取消
 */
abstract class BaseDialog : DialogFragment() {

    companion object {

        fun getScreenWidth(context: Context): Int {
            return context.resources.displayMetrics.widthPixels
        }

        fun dp2px(context: Context, dp: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dp * scale + 0.5f).toInt()
        }

    }

    private lateinit var mContext: Context //上下文
    private var dismissListener: DismissListener? = null //上下文
    protected var mLayoutResId = -1 //布局文件
    private var mDimAmount = 0.5f //背景灰度
    private var mShowBottomEnable = false //底部显示
    private var mShowTopEnable = false //顶部显示
    private var mMargin = 0 //边距
    private var mAnimStyle = 0 //出入动画
    private var mOutCancel = false //内容区以外点击是否消失
    private var mWidth = 0 //宽
    private var mHeight = 0 //高

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        if (!isRemoving) {
            dismissListener?.onDismiss(this)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BaseDialog)
        mLayoutResId = setUpLayoutId()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(mLayoutResId, container, false)
        convertView(ViewHolder.create(view), this)
        return view
    }

    override fun onStart() {
        super.onStart()
        initParams()
    }

    private fun initParams() {
        val window = dialog.window
        if (window != null) {
            val params = window.attributes
            params.dimAmount = mDimAmount

            if (mShowBottomEnable) {
                params.gravity = Gravity.BOTTOM
            }
            if (mShowTopEnable) {
                params.gravity = Gravity.TOP
            }

            if (mWidth == 0) {
                params.width = getScreenWidth(mContext) - 2 * dp2px(mContext, mMargin.toFloat())
            } else {
                params.width = dp2px(mContext, mWidth.toFloat())
            }

            if (mHeight == 0) {
                params.height = WindowManager.LayoutParams.WRAP_CONTENT
            } else {
                params.height = dp2px(mContext, mHeight.toFloat())
            }

            if (mAnimStyle != 0) {
                window.setWindowAnimations(mAnimStyle)
            }

            window.attributes = params
        }
        isCancelable = mOutCancel
    }

    abstract fun setUpLayoutId(): Int
    abstract fun convertView(holder: ViewHolder, dialog: BaseDialog)

    fun setDimAmount(@FloatRange(from = 0.0, to = 1.0) dimAmount: Float): BaseDialog {
        mDimAmount = dimAmount
        return this
    }

    fun setShowBottom(showBottom: Boolean): BaseDialog {
        mShowBottomEnable = showBottom
        mOutCancel = true
        return this
    }

    fun setShowTop(showTop: Boolean): BaseDialog {
        mShowTopEnable = showTop
        mOutCancel = true
        return this
    }

    fun setSize(width: Int, height: Int): BaseDialog {
        mWidth = width
        mHeight = height
        return this
    }

    fun setMargin(margin: Int): BaseDialog {
        mMargin = margin
        return this
    }

    fun setAnimStyle(@StyleRes animStyle: Int): BaseDialog {
        mAnimStyle = animStyle
        return this
    }

    fun setOutCancel(outCancel: Boolean): BaseDialog {
        mOutCancel = outCancel
        return this
    }

    fun show(manager: FragmentManager): BaseDialog {
        super.show(manager, "${System.currentTimeMillis()}")
        return this
    }

    fun setDismissListener(listener: DismissListener): BaseDialog {
        dismissListener = listener
        return this
    }
}