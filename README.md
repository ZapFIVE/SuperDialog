# SuperDialog

### 这是一个以Kotlin语言编写的弹窗类库，支持更高的自定义方式

### Demo中类举了几个简单的例子仅供参考 可参照下面图片寻找适合自己的样式

![顶部弹窗](https://github.com/ZapFIVE/SuperDialog/raw/master/img/Screenshot_2018-12-20-15-10-35.png)![底部弹窗](https://github.com/ZapFIVE/SuperDialog/raw/master/img/Screenshot_2018-12-20-15-10-41.png)
![双选项弹窗](https://github.com/ZapFIVE/SuperDialog/raw/master/img/Screenshot_2018-12-20-15-10-55.png)![但选项弹窗](https://github.com/ZapFIVE/SuperDialog/raw/master/img/Screenshot_2018-12-20-15-11-02.png)

### Example

```kotlin
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
```
