package com.five.widget.dialog.demo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.five.widget.dialog.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_normal_show.setOnClickListener { showNormalDialog() }
        btn_top_show.setOnClickListener { showTopDialog() }
        btn_bottom_show.setOnClickListener { showBottomDialog() }
        btn_center_show.setOnClickListener { showCenterDialog() }
        btn_2_btn_show.setOnClickListener { show2ButtonDialog() }
        btn_1_btn_show.setOnClickListener { show1ButtonDialog() }
        btn_no_cancel_show.setOnClickListener { showNoCancelDialog() }
        btn_on_listener_show.setOnClickListener { showOnListenerDialog() }
    }

    private fun showNormalDialog() {
        SuperDialog.getInstance()
                .setLayoutId(R.layout.layout_center)
                .setConvertListener(object : ConvertListener {
                    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
                        holder.setOnClickListener(R.id.aiv_close, View.OnClickListener {
                            dialog.dismiss()
                        })
                    }
                })
                .setOutCancel(true)
                .show(supportFragmentManager)
    }

    private fun showTopDialog() {
        SuperDialog.getInstance()
                .setLayoutId(R.layout.layout_top)
                .setConvertListener(object : ConvertListener {
                    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
                        holder.setOnClickListener(R.id.tv_weixin_share, View.OnClickListener {
                            Toast.makeText(this@MainActivity, "点击了微信", Toast.LENGTH_SHORT).show()
                        })
                    }
                })
                .setAnimStyle(R.style.TopEnterExitAnimation)
                .setDimAmount(0.3f)
                .setShowTop(true)
                .show(supportFragmentManager)
    }

    private fun showBottomDialog() {
        SuperDialog.getInstance()
                .setLayoutId(R.layout.layout_bottom)
                .setConvertListener(object : ConvertListener {
                    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
                        holder.setOnClickListener(R.id.tv_weixin_share, View.OnClickListener {
                            Toast.makeText(this@MainActivity, "点击了微信", Toast.LENGTH_SHORT).show()
                        })
                    }
                })
                .setAnimStyle(R.style.BottomEnterExitAnimation)
                .setShowBottom(true)
                .show(supportFragmentManager)
    }

    private fun showCenterDialog() {
        SuperDialog.getInstance()
                .setLayoutId(R.layout.layout_center)
                .setConvertListener(object : ConvertListener {
                    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
                        holder.getViews<AppCompatImageView>(R.id.aiv_close).visibility = View.GONE
                    }
                })
                .setOutCancel(true)
                .setAnimStyle(R.style.CenterEnterExitAnimation)
                .show(supportFragmentManager)
    }

    private fun show2ButtonDialog() {
        SuperDialog.getInstance()
                .setLayoutId(R.layout.layout_2_button)
                .setConvertListener(object : ConvertListener {
                    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
                        holder.setOnClickListener(R.id.tv_dialog_cancel, View.OnClickListener {
                            dialog.dismiss()
                        })
                        holder.setOnClickListener(R.id.tv_dialog_confirm, View.OnClickListener {
                            dialog.dismiss()
                        })
                    }
                })
                .setAnimStyle(R.style.CenterEnterExitAnimation)
                .setSize(300, 0)
                .show(supportFragmentManager)
    }

    private fun show1ButtonDialog() {
        SuperDialog.getInstance()
                .setLayoutId(R.layout.layout_1_button)
                .setConvertListener(object : ConvertListener {
                    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
                        holder.setOnClickListener(R.id.tv_dialog_cancel, View.OnClickListener {
                            dialog.dismiss()
                        })
                    }
                })
                .setAnimStyle(R.style.CenterEnterExitAnimation)
                .setSize(300, 0)
                .show(supportFragmentManager)
    }

    private fun showNoCancelDialog() {
        SuperDialog.getInstance()
                .setLayoutId(R.layout.layout_center)
                .setConvertListener(object : ConvertListener {
                    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
                        holder.setOnClickListener(R.id.aiv_close, View.OnClickListener {
                            dialog.dismiss()
                        })
                    }
                })
                .setAnimStyle(R.style.CenterEnterExitAnimation)
                .show(supportFragmentManager)
    }

    private fun showOnListenerDialog() {
        SuperDialog.getInstance()
                .setLayoutId(R.layout.layout_1_button)
                .setConvertListener(object : ConvertListener {
                    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
                        holder.setOnClickListener(R.id.tv_dialog_cancel, View.OnClickListener {
                            dialog.dismiss()
                        })
                    }
                })
                .setDismissListener(object : DismissListener {
                    override fun onDismiss(dialog: BaseDialog) {
                        Toast.makeText(this@MainActivity, "onDismiss", Toast.LENGTH_SHORT).show()
                    }
                })
                .setAnimStyle(R.style.CenterEnterExitAnimation)
                .setSize(300, 0)
                .show(supportFragmentManager)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_top_show -> {
            }
            R.id.btn_bottom_show -> {
            }
            R.id.btn_center_show -> {
            }
            R.id.btn_2_btn_show -> {
            }
            R.id.btn_1_btn_show -> {
            }
            R.id.btn_no_cancel_show -> {
            }
            R.id.btn_on_listener_show -> {
            }
        }
    }
}
